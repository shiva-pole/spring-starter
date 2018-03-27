
package com.analytics.scatterfit.config.security.auth.provider;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.analytics.scatterfit.config.security.domain.SessionAuthenticationToken;

@Component
public class ScatterfitAuthProvider implements AuthenticationProvider {
	private static final Logger LOGGER = LoggerFactory.getLogger(ScatterfitAuthProvider.class);

	private static final List<Class<? extends UsernamePasswordAuthenticationToken>> SUPPORTED_CLASSES = Arrays
			.asList(SessionAuthenticationToken.class, UsernamePasswordAuthenticationToken.class);

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		LOGGER.debug("Authentication request received for {}", authentication.getName());
		if (authentication instanceof SessionAuthenticationToken) {
			// Session Authentication
			SessionAuthenticationToken authToken = (SessionAuthenticationToken) authentication;
			return authenticateSessionToken(authToken);
		}
		return null;
	}

	private Authentication authenticateSessionToken(SessionAuthenticationToken authToken) {

		// nothing to validate here.. just log at debug level
		if (authToken.getPrincipal() != null) {
			LOGGER.debug("Session Authentication successful for user {}", authToken.getPrincipal());
			return authToken.copy();
		}
		LOGGER.debug("Session Authentication failed for null user {}");
		throw new BadCredentialsException("Invalid session token.");
	}

	@Override
	public boolean supports(Class<?> authentication) {

		return SUPPORTED_CLASSES.contains(authentication);
	}
}
