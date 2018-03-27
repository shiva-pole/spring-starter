
package com.analytics.scatterfit.user.exception;

import com.analytics.scatterfit.config.constants.ErrorCodes;
import com.analytics.scatterfit.config.exception.ScatterFitException;

public class PasswordAuthFailedException extends RuntimeException implements ScatterFitException {

	private static final long serialVersionUID = 3173726815256007810L;

	public PasswordAuthFailedException(String emailAddress) {

		super("User " + emailAddress + " failed password authentication");
	}

	@Override
	public String getErrorCode() {

		return ErrorCodes.AUTHENTICATION_FAILED_EXCEPTION;
	}
}
