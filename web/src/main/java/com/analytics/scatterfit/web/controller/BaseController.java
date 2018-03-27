
package com.analytics.scatterfit.web.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.analytics.scatterfit.config.constants.ErrorCodes;
import com.analytics.scatterfit.config.exception.ScatterFitException;
import com.analytics.scatterfit.response.BaseResponse;
import com.analytics.scatterfit.web.controller.exception.InputValidationException;
import com.analytics.scatterfit.web.controller.util.ViewMapper;

public class BaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);
	@Autowired
	protected ViewMapper viewMapper;
	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	private Validator validator = factory.getValidator();
	@Value("${application.host}")
	private String host;

	protected String getApplicationHost() {

		return host;
	}

	protected void prepareFailureResponse(BaseResponse baseResponse, Exception e) {

		baseResponse.setSuccessFlag(false);
		if (e instanceof ScatterFitException) {
			LOGGER.warn("Expected Exception occurred while serving Rest API ", e);
			baseResponse.setErrorCode(((ScatterFitException) e).getErrorCode());
			baseResponse.setErrorMsg(e.getMessage());
		} else {
			LOGGER.error("Exception occurred while serving Rest API ", e);
			// exceptions
			baseResponse.setErrorCode(ErrorCodes.GENERIC_EXCEPTION);
			baseResponse.setErrorMsg("Error processing request.");
		}
	}

	protected ResponseEntity<byte[]> prepareFileFailureResponse(Exception e) {

		if (e instanceof ScatterFitException) {
			LOGGER.warn("Expected Exception occurred while serving Rest API ", e);
		} else {
			LOGGER.error("Exception occurred while serving Rest API ", e);
		}
		return new ResponseEntity<byte[]>(HttpStatus.NO_CONTENT);
	}

	protected void validate(Object obj) {

		Set<ConstraintViolation<Object>> violations = validator.validate(obj);
		LOGGER.debug("Validation of {} result: {}", obj, violations);
		if (violations != null && !violations.isEmpty()) {
			LOGGER.info("Validation errors for {} are: {}", obj, violations);
			throw new InputValidationException();
		}
	}
}
