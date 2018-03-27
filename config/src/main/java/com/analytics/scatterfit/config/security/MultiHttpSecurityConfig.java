
package com.analytics.scatterfit.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.header.writers.frameoptions.RegExpAllowFromStrategy;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

import com.analytics.scatterfit.config.constants.ConfigConstants;
import com.analytics.scatterfit.config.security.auth.AuthConfig;
import com.analytics.scatterfit.config.security.auth.provider.ScatterfitAuthProvider;
import com.analytics.scatterfit.config.security.filter.SecurityFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class MultiHttpSecurityConfig {

	@Configuration
	@Order(100)
	public static class SessionSecurityConfig extends WebSecurityConfigurerAdapter {

		@Autowired
		private ScatterfitAuthProvider authenticationProvider;

		@Override
		protected void configure(HttpSecurity http) throws Exception {

			http.csrf().disable();
			http.headers().addHeaderWriter(new XFrameOptionsHeaderWriter(new RegExpAllowFromStrategy(".*")));
			http.antMatcher(ConfigConstants.SCATTERFIT_API + "/**").sessionManagement().sessionFixation().none()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().exceptionHandling()
					.authenticationEntryPoint(new Http403ForbiddenEntryPoint()).and()
					.addFilterBefore(new SecurityFilter(authenticationManagerBean()), BasicAuthenticationFilter.class);
			return;
		}

		@Bean
		public AuthenticationManager authenticationManagerBean() throws Exception {

			return super.authenticationManagerBean();
		}

		@Override
		protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception {

			authManagerBuilder.authenticationProvider(authenticationProvider);
		}
	}

	@Configuration
	@Order(101)
	public static class BasicSecurityConfig extends WebSecurityConfigurerAdapter {

		@Autowired
		private AuthConfig authConfig;

		@Override
		protected void configure(HttpSecurity http) throws Exception {

			BasicAuthenticationEntryPoint authenticationEntryPoint = new BasicAuthenticationEntryPoint();
			authenticationEntryPoint.setRealmName(authConfig.getRealm());

			if (authConfig.getSecurityBypassUrls() != null) {
				http.csrf().disable().authorizeRequests().antMatchers(authConfig.getSecurityBypassUrls()).permitAll();
			}
		}
	}

}
