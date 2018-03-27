
package com.analytics.scatterfit.config.logging;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadLocalContext {

	private static final Logger LOGGER = LoggerFactory.getLogger(ThreadLocalContext.class);
	private ThreadLocal<String> requestId = new ThreadLocal<>();
	private ThreadLocal<String> requestEmailId = new ThreadLocal<>();
	private static final ThreadLocalContext instance = new ThreadLocalContext();

	private ThreadLocalContext() {

	}

	public static ThreadLocalContext instance() {

		return instance;
	}

	public void initRequestId() {

		String value = UUID.randomUUID().toString();
		requestId.set(value);
		LOGGER.debug("Generated Request Id {}", value);
	}

	public String getRequestId() {

		return requestId.get();
	}

	public void clearRequestId() {

		LOGGER.debug("Clearing Request Id {}", requestId.get());
		requestId.remove();
	}

	public void setRequestEmailId(String emailId) {

		requestEmailId.set(emailId);
		LOGGER.debug("Setting Email: {} for Logging", emailId);
	}

	public String getRequestEmailId() {

		return requestEmailId.get();
	}

	public void clearRequestEmailId() {

		LOGGER.debug("Clearing Email Request Id {}", requestEmailId.get());
		requestEmailId.remove();
	}
}