/**
 * 
 */

package com.analytics.scatterfit.config.monitoring;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;

import net.bull.javamelody.MonitoringFilter;
import net.bull.javamelody.Parameter;

/**
 * The Configuration of Java Melody Monitoring of the Application.
 */
@Configuration
public class MonitoringConfig implements WebApplicationInitializer, ServletContextInitializer {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(MonitoringConfig.class);

	/**
	 * @see ServletContextInitializer#onStartup(ServletContext)
	 */
	@Override
	public void onStartup(ServletContext container) throws ServletException {

		/*
		 * In embedded server mode, the java melody filter is not initialized
		 * automatically. When deployed in an external Servlet Container, the
		 * web-fragment in javamelody.jar will load the filter. In this case, we
		 * need to modify the mapping and init params
		 */
		FilterRegistration javaMelody = container.getFilterRegistration("javamelody");
		if (javaMelody != null) {
			LOGGER.info("Java Melody Filter Registration found: {}", javaMelody);
			// Filter registered by Servlet Container via web-fragment in
			// javamelody.jar
			javaMelody.addMappingForUrlPatterns(
					EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.ASYNC), true, "/*");
			javaMelody.setInitParameter(Parameter.LOG.getCode(), Boolean.toString(false));
			javaMelody.setInitParameter(Parameter.DISPLAYED_COUNTERS.getCode(), "http,sql,error,log");
		} else {
			LOGGER.info("Java Melody Filter Registration not found. Registering dynamically");
			// Running in embedded server mode.
			Dynamic javaMelodyFilter = container.addFilter("javamelody", new MonitoringFilter());
			javaMelodyFilter.addMappingForUrlPatterns(
					EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.ASYNC), true, "/*");
			javaMelodyFilter.setInitParameter(Parameter.LOG.getCode(), Boolean.toString(false));
			javaMelodyFilter.setInitParameter(Parameter.DISPLAYED_COUNTERS.getCode(), "http,sql,error,log");
		}
	}
}
