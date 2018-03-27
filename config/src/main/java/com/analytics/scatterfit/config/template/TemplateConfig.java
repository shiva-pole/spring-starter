
package com.analytics.scatterfit.config.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.analytics.scatterfit.config.constants.ConfigConstants;

import freemarker.template.TemplateExceptionHandler;

@Configuration
public class TemplateConfig {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(TemplateConfig.class);

	@Bean
	public freemarker.template.Configuration freemarkerConfig() {

		LOGGER.info("Configuring FreeMarker Template Engine");
		freemarker.template.Configuration freemarkerCfg = new freemarker.template.Configuration(
				freemarker.template.Configuration.VERSION_2_3_23);
		// the base path for all templates
		freemarkerCfg.setClassForTemplateLoading(this.getClass(), "/templates");
		freemarkerCfg.setDefaultEncoding(ConfigConstants.DEFAULT_ENCODING);
		freemarkerCfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		LOGGER.info("Configured FreeMarker Template Engine successfully");
		return freemarkerCfg;
	}
}
