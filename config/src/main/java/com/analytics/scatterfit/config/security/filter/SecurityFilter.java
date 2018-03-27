
package com.analytics.scatterfit.config.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.web.filter.GenericFilterBean;

import com.analytics.scatterfit.config.constants.ConfigConstants;
import com.analytics.scatterfit.config.logging.ThreadLocalContext;
import com.analytics.scatterfit.config.security.domain.SessionAuthenticationToken;
import com.analytics.scatterfit.dto.session.UserSessionData;

public class SecurityFilter extends GenericFilterBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityFilter.class);
	private static final String MASKED = "######";
	private AuthenticationManager authenticationManager;
	private AuthenticationEntryPoint authenticationEntryPoint = new Http403ForbiddenEntryPoint();

	public SecurityFilter(AuthenticationManager authenticationManager) {

		this.authenticationManager = authenticationManager;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		// if not an http request, let it go ahead
		if (!(req instanceof HttpServletRequest)) {
			chain.doFilter(req, resp);
			return;
		}
		HttpServletRequest request = (HttpServletRequest) req;
		// if not a REST API, let it go ahead
		if (!request.getServletPath().contains(ConfigConstants.SCATTERFIT_API)) {
			chain.doFilter(req, resp);
			return;
		}
		ThreadLocalContext.instance().initRequestId();
		HttpServletResponse response = (HttpServletResponse) resp;
		/*
		 * Set the appropriate response headers to allow CORS with all domains
		 */
		setAccessControlResponseHeaders(response);
		String requestMethod = request.getMethod();
		if ("OPTIONS".equalsIgnoreCase(requestMethod)) {
			// if OPTIONS call, then response headers are enough
			LOGGER.debug("Received OPTIONS call on {}", request.getServletPath());
			chain.doFilter(request, response);
			return;
		}
		LOGGER.info("SecurityFilter intercepted request on {}", request.getServletPath());
		HttpSession session = request.getSession();
		LOGGER.info("Session Id: {}", request.getSession().getId());
		// get session data
		UserSessionData userData = (UserSessionData) session.getAttribute(ConfigConstants.USER_DATA_SESSION_KEY);
		if (userData != null && userData.getMemberInfo() != null) {
			String memberEmailAddress = userData.getMemberInfo().getEmailAddress();
			Authentication authToken = new SessionAuthenticationToken(userData.getMemberInfo().getMemberId(), MASKED);
			try {
				Authentication successfulAuthentication = authenticationManager.authenticate(authToken);
				SecurityContextHolder.getContext().setAuthentication(successfulAuthentication);
				LOGGER.debug("User session for {} has valid authentication", memberEmailAddress);
				ThreadLocalContext.instance().setRequestEmailId(userData.getMemberInfo().getEmailAddress());
				chain.doFilter(req, resp);
				ThreadLocalContext.instance().clearRequestEmailId();
			} catch (AuthenticationException e) {
				LOGGER.warn("Exception occured while authenticating User session for {}.", memberEmailAddress, e);
				SecurityContextHolder.clearContext();
				authenticationEntryPoint.commence(request, response, e);
			}
		} else {
			LOGGER.debug("Could not find any user session token.");
			chain.doFilter(req, resp);
		}
		ThreadLocalContext.instance().clearRequestId();
	}

	private void setAccessControlResponseHeaders(HttpServletResponse response) {

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, OPTIONS");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers",
				"Origin, X-Requested-With, Content-Type, Accept, requestUUID, Authorization");
	}
}
