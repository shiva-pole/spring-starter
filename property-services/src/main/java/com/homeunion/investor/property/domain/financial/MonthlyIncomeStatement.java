
package com.homeunion.investor.property.domain.financial;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MonthlyIncomeStatement", description = "The expected basic monthly statement")
public class MonthlyIncomeStatement {

	@ApiModelProperty(value = "The monthly loan payment")
	private double loanPayment;
	@ApiModelProperty(value = "The monthly rent earned")
	private double rent;
	@ApiModelProperty(value = "The monthly property tax expense")
	private double propertyTax;
	@ApiModelProperty(value = "The monthly property insurance expense")
	private double propertyInsuarance;
	@ApiModelProperty(value = "The monthly hoa expense")
	private double hoa;
	@ApiModelProperty(value = "The monthly asset management fee")
	private double assetManagementFee;
	@ApiModelProperty(value = "The monthly cashflow")
	private double cashflow;

	public double getLoanPayment() {

		return loanPayment;
	}

	public void setLoanPayment(double loanPayment) {

		this.loanPayment = loanPayment;
	}

	public double getRent() {

		return rent;
	}

	public void setRent(double rent) {

		this.rent = rent;
	}

	public double getPropertyTax() {

		return propertyTax;
	}

	public void setPropertyTax(double propertyTax) {

		this.propertyTax = propertyTax;
	}

	public double getPropertyInsuarance() {

		return propertyInsuarance;
	}

	public void setPropertyInsuarance(double propertyInsuarance) {

		this.propertyInsuarance = propertyInsuarance;
	}

	public double getHoa() {

		return hoa;
	}

	public void setHoa(double hoa) {

		this.hoa = hoa;
	}

	public double getAssetManagementFee() {

		return assetManagementFee;
	}

	public void setAssetManagementFee(double assetManagementFee) {

		this.assetManagementFee = assetManagementFee;
	}

	public double getCashflow() {

		return cashflow;
	}

	public void setCashflow(double cashflow) {

		this.cashflow = cashflow;
	}
}
