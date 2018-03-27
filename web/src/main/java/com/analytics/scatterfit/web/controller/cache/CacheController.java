
package com.analytics.scatterfit.web.controller.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.analytics.scatterfit.config.constants.ConfigConstants;
import com.analytics.scatterfit.response.BaseResponse;
import com.analytics.scatterfit.web.controller.BaseController;
import com.analytics.scatterfit.web.service.CacheService;

@RestController
@RequestMapping(ConfigConstants.SCATTERFIT_API)
public class CacheController extends BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CacheController.class);
	@Autowired
	private CacheService cacheService;

	@RequestMapping(value = "/cache/refresh", method = RequestMethod.GET)
	public BaseResponse refreshCache() {

		LOGGER.info("Rest API /cache/refresh invoked");
		final long start = System.currentTimeMillis();
		BaseResponse response = new BaseResponse();
		try {
			cacheService.refreshCache();
			final long end = System.currentTimeMillis();
			LOGGER.info("Returning successful response for /cache/refresh. Time: {}ms", end - start);
		} catch (Exception e) {
			LOGGER.warn("Exception occurred while serving Rest API /cache/refresh.");
			prepareFailureResponse(response, e);
		}
		return response;
	}
}
