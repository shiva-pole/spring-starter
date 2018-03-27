
package com.analytics.scatterfit.user.exception;

import com.analytics.scatterfit.config.constants.ErrorCodes;
import com.analytics.scatterfit.config.exception.ScatterFitException;

public class UserNotFoundException extends RuntimeException implements ScatterFitException {

	private static final long serialVersionUID = 3173726815256007810L;

	public UserNotFoundException(String emailAddress) {

		super("User " + emailAddress + " not found");
	}

	@Override
	public String getErrorCode() {

		return ErrorCodes.USER_NOT_FOUND_EXCEPTION;
	}
}
