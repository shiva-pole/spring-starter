
package com.analytics.scatterfit.web.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class SchedulerConfig implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerConfig.class);
	@Value("${spring.profiles.active}")
	private String activeProfile;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		LOGGER.info("Entered Application Startup Event Handler");
		LOGGER.info("Exiting Application Startup Event Handler");
	}

}
