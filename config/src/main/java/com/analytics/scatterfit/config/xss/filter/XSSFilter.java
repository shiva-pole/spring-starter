
package com.analytics.scatterfit.config.xss.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.analytics.scatterfit.config.constants.ConfigConstants;
import com.analytics.scatterfit.config.xss.AuthenticationRequestWrapper;

@Component
@WebFilter(value = ConfigConstants.SCATTERFIT_API + "/*")
public class XSSFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		if (httpRequest.getServletPath().contains(ConfigConstants.SCATTERFIT_API)) {
			AuthenticationRequestWrapper authRequest = new AuthenticationRequestWrapper(httpRequest);
			chain.doFilter(authRequest, response);
		} else {
			chain.doFilter(request, response);
		}
	}
}
