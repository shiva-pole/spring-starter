
package com.analytics.scatterfit.web;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class, JmxAutoConfiguration.class })
@ImportResource({ "classpath:net/bull/javamelody/monitoring-spring-datasource.xml", "classpath:Spring-Quartz.xml" })
@ComponentScan(basePackages = { "com.analytics.scatterfit", "com.analytics.security" })
@EnableAsync
public class Application extends SpringBootServletInitializer implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	@Value("${application.version}")
	private String applicationVersion;

	public static void main(String[] args) throws Exception {

		new SpringApplicationBuilder(Application.class).bannerMode(Banner.Mode.CONSOLE).run(args);
	}

	@Override
	protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {

		return application.sources(Application.class);
	}

	@Override
	public void run(String... args) throws Exception {

		LOGGER.info("Scatterfit Application [Version: {}] Started at {}", applicationVersion, new Date());
	}
}
