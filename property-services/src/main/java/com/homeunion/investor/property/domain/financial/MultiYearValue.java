
package com.homeunion.investor.property.domain.financial;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MultiYearValue", description = "The amounts for each year of the projection term along with the total & average values")
public class MultiYearValue {

	@ApiModelProperty(value = "The yearly amounts")
	private double[] yearlyValues;
	@ApiModelProperty(value = "The total amount. Can be sum OR final value in case of cumulative yearly amounts")
	private double total;
	@ApiModelProperty(value = "The average yearly amount")
	private double average;
	@ApiModelProperty(value = "The average monthly amount")
	private double monthlyAverage;

	public double getMonthlyAverage() {

		return monthlyAverage;
	}

	public void setMonthlyAverage(double monthlyAverage) {

		this.monthlyAverage = monthlyAverage;
	}

	public double[] getYearlyValues() {

		return yearlyValues;
	}

	public void setYearlyValues(double[] yearlyValues) {

		this.yearlyValues = yearlyValues;
	}

	public double getTotal() {

		return total;
	}

	public void setTotal(double total) {

		this.total = total;
	}

	public double getAverage() {

		return average;
	}

	public void setAverage(double average) {

		this.average = average;
	}
}
