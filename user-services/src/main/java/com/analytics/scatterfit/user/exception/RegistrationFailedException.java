
package com.analytics.scatterfit.user.exception;

import com.analytics.scatterfit.config.constants.ErrorCodes;
import com.analytics.scatterfit.config.exception.ScatterFitException;

public class RegistrationFailedException extends RuntimeException implements ScatterFitException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4314019432854657698L;

	public RegistrationFailedException() {

		super("Registration Failed. Try registering again with different fields.");
	}

	@Override
	public String getErrorCode() {

		return ErrorCodes.REGISTRATION_FAILED_EXCEPTION;
	}
}
