
package com.analytics.scatterfit.config.logging;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class RequestIdConverter extends ClassicConverter {

	@Override
	public String convert(ILoggingEvent event) {

		if (ThreadLocalContext.instance().getRequestId() != null) {
			return ThreadLocalContext.instance().getRequestId();
		} else {
			return "server";
		}
	}
}