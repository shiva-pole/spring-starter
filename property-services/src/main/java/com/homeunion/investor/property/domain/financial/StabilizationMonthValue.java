
package com.homeunion.investor.property.domain.financial;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "StabilizationMonthValue", description = "The stabilization breakup item monthly values")
public class StabilizationMonthValue {

	@ApiModelProperty(value = "The total value for the stabilization period")
	private double total;
	@ApiModelProperty(value = "The monthly values for each month in stabilization period")
	private double[] monthlyValues;

	public double getTotal() {

		return total;
	}

	public void setTotal(double total) {

		this.total = total;
	}

	public double[] getMonthlyValues() {

		return monthlyValues;
	}

	public void setMonthlyValues(double[] monthlyValues) {

		this.monthlyValues = monthlyValues;
	}
}
