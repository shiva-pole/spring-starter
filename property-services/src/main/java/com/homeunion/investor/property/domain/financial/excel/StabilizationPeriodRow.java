
package com.homeunion.investor.property.domain.financial.excel;

import com.homeunion.investor.property.domain.financial.FinancialProjection;

public class StabilizationPeriodRow {

	private Integer month;
	private String tenanted = "";
	private Double netRentalIncome;
	private Double rentalIncome;
	private Double loanPayment;
	private Double loanInterest;
	private Double loanPrincipal;
	private Double loanExtraPayment;
	private Double propertyTax;
	private Double propertyInsurance;
	private Double hoa;
	private Double leasingFee;
	private Double assetManagementFee;
	private Double repairAndMaintenanceFee;
	private Double utilitiesLandscape;
	private Double operatingExpenses;
	private Double netOperatingIncome;
	private Double cashflow;

	public StabilizationPeriodRow(FinancialProjection projection, int monthIndex) {

		month = monthIndex + 1;
		if (monthIndex == projection.getStabilizationPeriod()) {
			tenanted = "Tenanted";
		}
		rentalIncome = projection.getStabilizationData().getRentalIncome().getMonthlyValues()[monthIndex];
		netRentalIncome = projection.getStabilizationData().getRentalIncome().getMonthlyValues()[monthIndex];
		loanPayment = projection.getStabilizationData().getLoanPayment().getMonthlyValues()[monthIndex];
		loanInterest = projection.getStabilizationData().getLoanInterest().getMonthlyValues()[monthIndex];
		loanPrincipal = projection.getStabilizationData().getLoanPrincipal().getMonthlyValues()[monthIndex];
		propertyTax = projection.getStabilizationData().getPropertyTax().getMonthlyValues()[monthIndex];
		propertyInsurance = projection.getStabilizationData().getPropertyInsurance().getMonthlyValues()[monthIndex];
		hoa = projection.getStabilizationData().getHoa().getMonthlyValues()[monthIndex];
		leasingFee = projection.getStabilizationData().getLeasingFee().getMonthlyValues()[monthIndex];
		assetManagementFee = projection.getStabilizationData().getAssetManagementFee().getMonthlyValues()[monthIndex];
		operatingExpenses = projection.getStabilizationData().getOperatingExpense().getMonthlyValues()[monthIndex];
		netOperatingIncome = projection.getStabilizationData().getNetOperatingIncome().getMonthlyValues()[monthIndex];
		cashflow = projection.getStabilizationData().getCashflow().getMonthlyValues()[monthIndex];
	}

	public Integer getMonth() {

		return month;
	}

	public void setMonth(Integer month) {

		this.month = month;
	}

	public String getTenanted() {

		return tenanted;
	}

	public void setTenanted(String tenanted) {

		this.tenanted = tenanted;
	}

	public Double getNetRentalIncome() {

		return netRentalIncome;
	}

	public void setNetRentalIncome(Double netRentalIncome) {

		this.netRentalIncome = netRentalIncome;
	}

	public Double getRentalIncome() {

		return rentalIncome;
	}

	public void setRentalIncome(Double rentalIncome) {

		this.rentalIncome = rentalIncome;
	}

	public Double getLoanPayment() {

		return loanPayment;
	}

	public void setLoanPayment(Double loanPayment) {

		this.loanPayment = loanPayment;
	}

	public Double getLoanInterest() {

		return loanInterest;
	}

	public void setLoanInterest(Double loanInterest) {

		this.loanInterest = loanInterest;
	}

	public Double getLoanPrincipal() {

		return loanPrincipal;
	}

	public void setLoanPrincipal(Double loanPrincipal) {

		this.loanPrincipal = loanPrincipal;
	}

	public Double getLoanExtraPayment() {

		return loanExtraPayment;
	}

	public void setLoanExtraPayment(Double loanExtraPayment) {

		this.loanExtraPayment = loanExtraPayment;
	}

	public Double getPropertyTax() {

		return propertyTax;
	}

	public void setPropertyTax(Double propertyTax) {

		this.propertyTax = propertyTax;
	}

	public Double getPropertyInsurance() {

		return propertyInsurance;
	}

	public void setPropertyInsurance(Double propertyInsurance) {

		this.propertyInsurance = propertyInsurance;
	}

	public Double getHoa() {

		return hoa;
	}

	public void setHoa(Double hoa) {

		this.hoa = hoa;
	}

	public Double getLeasingFee() {

		return leasingFee;
	}

	public void setLeasingFee(Double leasingFee) {

		this.leasingFee = leasingFee;
	}

	public Double getAssetManagementFee() {

		return assetManagementFee;
	}

	public void setAssetManagementFee(Double assetManagementFee) {

		this.assetManagementFee = assetManagementFee;
	}

	public Double getRepairAndMaintenanceFee() {

		return repairAndMaintenanceFee;
	}

	public void setRepairAndMaintenanceFee(Double repairAndMaintenanceFee) {

		this.repairAndMaintenanceFee = repairAndMaintenanceFee;
	}

	public Double getUtilitiesLandscape() {

		return utilitiesLandscape;
	}

	public void setUtilitiesLandscape(Double utilitiesLandscape) {

		this.utilitiesLandscape = utilitiesLandscape;
	}

	public Double getOperatingExpenses() {

		return operatingExpenses;
	}

	public void setOperatingExpenses(Double operatingExpenses) {

		this.operatingExpenses = operatingExpenses;
	}

	public Double getNetOperatingIncome() {

		return netOperatingIncome;
	}

	public void setNetOperatingIncome(Double netOperatingIncome) {

		this.netOperatingIncome = netOperatingIncome;
	}

	public Double getCashflow() {

		return cashflow;
	}

	public void setCashflow(Double cashflow) {

		this.cashflow = cashflow;
	}
}
