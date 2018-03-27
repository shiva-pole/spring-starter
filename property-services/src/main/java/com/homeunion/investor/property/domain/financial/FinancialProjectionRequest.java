
package com.homeunion.investor.property.domain.financial;

import javax.validation.constraints.NotNull;

public class FinancialProjectionRequest {

	@NotNull
	private PropertyFinancialsInput propertyInput;
	private UserOverrideInput userInput;

	public PropertyFinancialsInput getPropertyInput() {

		return propertyInput;
	}

	public void setPropertyInput(PropertyFinancialsInput propertyInput) {

		this.propertyInput = propertyInput;
	}

	public UserOverrideInput getUserInput() {

		return userInput;
	}

	public void setUserInput(UserOverrideInput userInput) {

		this.userInput = userInput;
	}
}
