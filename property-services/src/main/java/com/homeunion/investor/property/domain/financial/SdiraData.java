
package com.homeunion.investor.property.domain.financial;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SdiraData", description = "The SDIRA data")
public class SdiraData {

	@ApiModelProperty(value = "The average monthly management fee")
	private double managementFeeMonthly;
	@ApiModelProperty(value = "The average yearly management fee")
	private double managementFeeAnnual;
	@ApiModelProperty(value = "The average monthly maintenance percent of monthly rent")
	private double maintenanceProvisionMonthly;
	@ApiModelProperty(value = "The average monthly vacancy percentage of monthly rent")
	private double vacancyProvisionMonthly;
	@ApiModelProperty(value = "The ration of rent to property price")
	private double rentPriceRatioPercent;
	@ApiModelProperty(value = "The difference between the average home price and property price")
	private double marketEquity;
	@ApiModelProperty(value = "The rate of average loan principal to investment")
	private double principalBuildUpRate;
	@ApiModelProperty(value = "The flag indicating whether property qualifies the target DSCR value")
	private boolean isSdiraQualified;

	public double getManagementFeeMonthly() {

		return managementFeeMonthly;
	}

	public void setManagementFeeMonthly(double managementFeeMonthly) {

		this.managementFeeMonthly = managementFeeMonthly;
	}

	public double getManagementFeeAnnual() {

		return managementFeeAnnual;
	}

	public void setManagementFeeAnnual(double managementFeeAnnual) {

		this.managementFeeAnnual = managementFeeAnnual;
	}

	public double getMaintenanceProvisionMonthly() {

		return maintenanceProvisionMonthly;
	}

	public void setMaintenanceProvisionMonthly(double maintenanceProvisionMonthly) {

		this.maintenanceProvisionMonthly = maintenanceProvisionMonthly;
	}

	public double getVacancyProvisionMonthly() {

		return vacancyProvisionMonthly;
	}

	public void setVacancyProvisionMonthly(double vacancyProvisionMonthly) {

		this.vacancyProvisionMonthly = vacancyProvisionMonthly;
	}

	public double getRentPriceRatioPercent() {

		return rentPriceRatioPercent;
	}

	public void setRentPriceRatioPercent(double rentPriceRatioPercent) {

		this.rentPriceRatioPercent = rentPriceRatioPercent;
	}

	public double getMarketEquity() {

		return marketEquity;
	}

	public void setMarketEquity(double marketEquity) {

		this.marketEquity = marketEquity;
	}

	public double getPrincipalBuildUpRate() {

		return principalBuildUpRate;
	}

	public void setPrincipalBuildUpRate(double principalBuildUpRate) {

		this.principalBuildUpRate = principalBuildUpRate;
	}

	public boolean isSdiraQualified() {

		return isSdiraQualified;
	}

	public void setSdiraQualified(boolean isSdiraQualified) {

		this.isSdiraQualified = isSdiraQualified;
	}
}
