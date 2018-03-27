
package com.analytics.scatterfit.config.logging;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class RequestEmailIdConverter extends ClassicConverter {

	@Override
	public String convert(ILoggingEvent event) {

		if (ThreadLocalContext.instance().getRequestEmailId() != null) {
			return ThreadLocalContext.instance().getRequestEmailId();
		} else {
			return "anonymous";
		}
	}
}