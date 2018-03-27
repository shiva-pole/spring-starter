
package com.homeunion.investor.property.exception;

import com.homeunion.investor.config.constants.ErrorCodes;
import com.homeunion.investor.config.exception.InvestorPortalException;

public class PlatformServiceException extends RuntimeException implements InvestorPortalException {

	private static final long serialVersionUID = -5516818379057909804L;

	public PlatformServiceException(String message) {

		super(message);
	}

	@Override
	public String getErrorCode() {

		return ErrorCodes.PLATFORM_SERVICE_EXCEPTION;
	}
}
