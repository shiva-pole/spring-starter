
package com.analytics.scatterfit.user.exception;

import com.analytics.scatterfit.config.constants.ErrorCodes;
import com.analytics.scatterfit.config.exception.ScatterFitException;

public class EmailNotSentException extends RuntimeException implements ScatterFitException {

	private static final long serialVersionUID = 3173726815256007810L;

	public EmailNotSentException(String emailAddress) {

		super("Forgot passsword email for user " + emailAddress + " could not be sent.");
	}

	@Override
	public String getErrorCode() {

		return ErrorCodes.EMAIL_NOT_SENT_EXCEPTION;
	}
}
