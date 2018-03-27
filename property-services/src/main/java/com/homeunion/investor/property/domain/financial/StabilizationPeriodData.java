
package com.homeunion.investor.property.domain.financial;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "StabilizationPeriodData", description = "The stabilization reserve breakup")
public class StabilizationPeriodData {

	@ApiModelProperty(value = "The rental income earned")
	private StabilizationMonthValue rentalIncome;
	@ApiModelProperty(value = "The total income earned")
	private StabilizationMonthValue totalIncome;
	@ApiModelProperty(value = "The loan payment")
	private StabilizationMonthValue loanPayment;
	@ApiModelProperty(value = "The property tax expense")
	private StabilizationMonthValue propertyTax;
	@ApiModelProperty(value = "The property insurance expense")
	private StabilizationMonthValue propertyInsurance;
	@ApiModelProperty(value = "The hoa expense")
	private StabilizationMonthValue hoa;
	@ApiModelProperty(value = "The leasing fee")
	private StabilizationMonthValue leasingFee;
	@ApiModelProperty(value = "The asset management fee")
	private StabilizationMonthValue assetManagementFee;
	@ApiModelProperty(value = "The utilities & landscaping expense")
	private StabilizationMonthValue utilitiesAndLandscape;
	@ApiModelProperty(value = "The total stabilization estimate")
	private StabilizationMonthValue stabilizationEstimate;
	@ApiModelProperty(value = "The loan principal")
	private StabilizationMonthValue loanPrincipal;
	@ApiModelProperty(value = "The loan interest")
	private StabilizationMonthValue loanInterest;
	@ApiModelProperty(value = "The operating expense")
	private StabilizationMonthValue operatingExpense;
	@ApiModelProperty(value = "The cash flow")
	private StabilizationMonthValue cashflow;
	@ApiModelProperty(value = "The net operating income")
	private StabilizationMonthValue netOperatingIncome;

	public StabilizationMonthValue getCashflow() {

		return cashflow;
	}

	public void setCashflow(StabilizationMonthValue cashflow) {

		this.cashflow = cashflow;
	}

	public StabilizationMonthValue getLoanPrincipal() {

		return loanPrincipal;
	}

	public void setLoanPrincipal(StabilizationMonthValue loanPrincipal) {

		this.loanPrincipal = loanPrincipal;
	}

	public StabilizationMonthValue getLoanInterest() {

		return loanInterest;
	}

	public void setLoanInterest(StabilizationMonthValue loanInterest) {

		this.loanInterest = loanInterest;
	}

	public StabilizationMonthValue getOperatingExpense() {

		return operatingExpense;
	}

	public void setOperatingExpense(StabilizationMonthValue operatingExpense) {

		this.operatingExpense = operatingExpense;
	}

	public StabilizationMonthValue getNetOperatingIncome() {

		return netOperatingIncome;
	}

	public void setNetOperatingIncome(StabilizationMonthValue netOperatingIncome) {

		this.netOperatingIncome = netOperatingIncome;
	}

	public StabilizationMonthValue getRentalIncome() {

		return rentalIncome;
	}

	public void setRentalIncome(StabilizationMonthValue rentalIncome) {

		this.rentalIncome = rentalIncome;
	}

	public StabilizationMonthValue getTotalIncome() {

		return totalIncome;
	}

	public void setTotalIncome(StabilizationMonthValue totalIncome) {

		this.totalIncome = totalIncome;
	}

	public StabilizationMonthValue getLoanPayment() {

		return loanPayment;
	}

	public void setLoanPayment(StabilizationMonthValue loanPayment) {

		this.loanPayment = loanPayment;
	}

	public StabilizationMonthValue getPropertyTax() {

		return propertyTax;
	}

	public void setPropertyTax(StabilizationMonthValue propertyTax) {

		this.propertyTax = propertyTax;
	}

	public StabilizationMonthValue getPropertyInsurance() {

		return propertyInsurance;
	}

	public void setPropertyInsurance(StabilizationMonthValue propertyInsurance) {

		this.propertyInsurance = propertyInsurance;
	}

	public StabilizationMonthValue getHoa() {

		return hoa;
	}

	public void setHoa(StabilizationMonthValue hoa) {

		this.hoa = hoa;
	}

	public StabilizationMonthValue getLeasingFee() {

		return leasingFee;
	}

	public void setLeasingFee(StabilizationMonthValue leasingFee) {

		this.leasingFee = leasingFee;
	}

	public StabilizationMonthValue getAssetManagementFee() {

		return assetManagementFee;
	}

	public void setAssetManagementFee(StabilizationMonthValue assetManagementFee) {

		this.assetManagementFee = assetManagementFee;
	}

	public StabilizationMonthValue getUtilitiesAndLandscape() {

		return utilitiesAndLandscape;
	}

	public void setUtilitiesAndLandscape(StabilizationMonthValue utilitiesAndLandscape) {

		this.utilitiesAndLandscape = utilitiesAndLandscape;
	}

	public StabilizationMonthValue getStabilizationEstimate() {

		return stabilizationEstimate;
	}

	public void setStabilizationEstimate(StabilizationMonthValue stabilizationEstimate) {

		this.stabilizationEstimate = stabilizationEstimate;
	}
}
