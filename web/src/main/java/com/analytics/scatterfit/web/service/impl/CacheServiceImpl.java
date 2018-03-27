
package com.analytics.scatterfit.web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.analytics.scatterfit.web.service.CacheService;

@Component
public class CacheServiceImpl implements CacheService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CacheServiceImpl.class);

	@Override
	public void refreshCache() {

		// Refresh cache here
	}

}
