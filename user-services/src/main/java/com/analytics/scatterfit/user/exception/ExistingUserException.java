
package com.analytics.scatterfit.user.exception;

import com.analytics.scatterfit.config.constants.ErrorCodes;
import com.analytics.scatterfit.config.exception.ScatterFitException;

public class ExistingUserException extends RuntimeException implements ScatterFitException {

	private static final long serialVersionUID = 3173726815256007810L;

	public ExistingUserException(String emailAddress) {

		super("User " + emailAddress + " already exists");
	}

	@Override
	public String getErrorCode() {

		return ErrorCodes.EXISTING_USER_EXCEPTION;
	}
}
