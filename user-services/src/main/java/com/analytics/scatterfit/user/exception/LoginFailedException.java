
package com.analytics.scatterfit.user.exception;

import com.analytics.scatterfit.config.constants.ErrorCodes;
import com.analytics.scatterfit.config.exception.ScatterFitException;

public class LoginFailedException extends RuntimeException implements ScatterFitException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6148889155661318377L;

	public LoginFailedException() {

		super("Sorry, the email address and password do not match, please try again or reset your password.");
	}

	@Override
	public String getErrorCode() {

		return ErrorCodes.LOGIN_FAILED_EXCEPTION;
	}
}
