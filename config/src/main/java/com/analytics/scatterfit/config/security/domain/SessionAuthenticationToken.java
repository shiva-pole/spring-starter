
package com.analytics.scatterfit.config.security.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.analytics.scatterfit.config.constants.ConfigConstants;

public class SessionAuthenticationToken extends UsernamePasswordAuthenticationToken {

	private static final long serialVersionUID = 2401736884683020884L;
	private String memberEmailAddress;
	private String memberPassword;
	private List<GrantedAuthority> authorities;

	private SessionAuthenticationToken(String memberEmailAddress, String memberPassword,
			List<GrantedAuthority> authorities) {

		super(memberEmailAddress, memberPassword, authorities);
		this.memberEmailAddress = memberEmailAddress;
		this.memberPassword = memberPassword;
		this.authorities = authorities;
	}

	public SessionAuthenticationToken(String memberEmailAddress, String memberPassword) {

		super(memberEmailAddress, memberPassword, null);
		this.memberEmailAddress = memberEmailAddress;
		this.memberPassword = memberPassword;
		authorities = new ArrayList<>();

		// add the logged in user authority to any logged in user
		authorities.add(new SimpleGrantedAuthority(ConfigConstants.AUTHORITY_LOGGED_IN_USER));

	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {

		return authorities;
	}

	public SessionAuthenticationToken copy() {

		return new SessionAuthenticationToken(memberEmailAddress, memberPassword, authorities);
	}
}
