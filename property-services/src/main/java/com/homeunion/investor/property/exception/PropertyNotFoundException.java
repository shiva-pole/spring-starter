
package com.homeunion.investor.property.exception;

import com.homeunion.investor.config.constants.ErrorCodes;
import com.homeunion.investor.config.exception.InvestorPortalException;

public class PropertyNotFoundException extends RuntimeException implements InvestorPortalException {

	private static final long serialVersionUID = 3173726815256007810L;

	public PropertyNotFoundException(String propertyId) {

		super("Property " + propertyId + " not found");
	}

	@Override
	public String getErrorCode() {

		return ErrorCodes.PROPERTY_NOT_FOUND_EXCEPTION;
	}
}
