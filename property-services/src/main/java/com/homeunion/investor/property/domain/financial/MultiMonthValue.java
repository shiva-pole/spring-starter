
package com.homeunion.investor.property.domain.financial;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MultiYearValue", description = "The amounts for each month & year of the projection term along with the total & average values")
public class MultiMonthValue extends MultiYearValue {

	@ApiModelProperty(value = "The monthly amounts")
	private double monthlyValues[];

	public double[] getMonthlyValues() {

		return monthlyValues;
	}

	public void setMonthlyValues(double[] monthlyValues) {

		this.monthlyValues = monthlyValues;
	}
}
