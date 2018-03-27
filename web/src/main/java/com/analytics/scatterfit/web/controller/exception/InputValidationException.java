
package com.analytics.scatterfit.web.controller.exception;

import com.analytics.scatterfit.config.constants.ErrorCodes;
import com.analytics.scatterfit.config.exception.ScatterFitException;

public class InputValidationException extends RuntimeException implements ScatterFitException {

	private static final long serialVersionUID = 3173726815256007810L;

	public InputValidationException() {

		super("Input Validation failed for REST API input");
	}

	@Override
	public String getErrorCode() {

		return ErrorCodes.INPUT_VALIDATION_EXCEPTION;
	}
}
