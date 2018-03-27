
package com.analytics.scatterfit.config.security.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AuthConfig implements InitializingBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthConfig.class);
	@Autowired
	private Environment env;
	private String realm;
	private String[] securityBypassUrls;
	private boolean docSecurityEnabled;
	private String docSecurityUser;
	private String docSecurityPassword;
	private boolean monitoringSecurityEnabled;
	private String monitoringSecurityUser;
	private String monitoringSecurityPassword;

	@Override
	public void afterPropertiesSet() throws Exception {

		// Security Realm
		realm = env.getProperty("security.realm");
		// Web Resources - No Authentication
		if (env.getProperty("security.bypass.urls") != null) {
			securityBypassUrls = env.getProperty("security.bypass.urls").split(",");
		}
		// Basic Authentication - Rest API Documentation
		docSecurityEnabled = Boolean.parseBoolean(env.getProperty("security.doc.enabled"));
		docSecurityUser = env.getProperty("security.doc.user");
		docSecurityPassword = env.getProperty("security.doc.password");
		LOGGER.info("Security Config: docs: {}, {}, {}", docSecurityEnabled, docSecurityUser, docSecurityPassword);
		// Basic Authentication - Java Melody Monitoring
		monitoringSecurityEnabled = Boolean.parseBoolean(env.getProperty("security.monitoring.enabled"));
		monitoringSecurityUser = env.getProperty("security.monitoring.user");
		monitoringSecurityPassword = env.getProperty("security.monitoring.password");
		LOGGER.info("Security Config: monitoring: {}, {}, {}", monitoringSecurityEnabled, monitoringSecurityUser,
				monitoringSecurityPassword);
	}

	public String getRealm() {

		return realm;
	}

	public String[] getSecurityBypassUrls() {

		return securityBypassUrls;
	}

	public boolean isDocSecurityEnabled() {

		return docSecurityEnabled;
	}

	public String getDocSecurityUser() {

		return docSecurityUser;
	}

	public String getDocSecurityPassword() {

		return docSecurityPassword;
	}

	public boolean isMonitoringSecurityEnabled() {

		return monitoringSecurityEnabled;
	}

	public String getMonitoringSecurityUser() {

		return monitoringSecurityUser;
	}

	public String getMonitoringSecurityPassword() {

		return monitoringSecurityPassword;
	}
}
