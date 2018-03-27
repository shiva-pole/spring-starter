
package com.homeunion.investor.property.domain.financial.excel;

import com.homeunion.investor.property.domain.financial.FinancialProjection;

public class AnnualReturnsRow {

	private Integer year;
	private Double netRentalIncome;
	private Double rentalIncome;
	private Double vacancyLoss;
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
	private Double investment;
	private Double yield;
	private Double cashOnCashReturn;
	private Double capRate;
	private Double price;
	private Double debtServiceCoverageRatio;

	public AnnualReturnsRow(FinancialProjection projection, int yearIndex) {

		year = yearIndex + 1;
		rentalIncome = projection.getRentalIncome().getYearlyValues()[yearIndex];
		vacancyLoss = projection.getVacancyLoss().getYearlyValues()[yearIndex];
		netRentalIncome = projection.getNetRentalIncome().getYearlyValues()[yearIndex];
		loanPayment = projection.getLoanPayment().getYearlyValues()[yearIndex];
		loanInterest = projection.getLoanInterest().getYearlyValues()[yearIndex];
		loanPrincipal = projection.getLoanPrincipal().getYearlyValues()[yearIndex];
		loanExtraPayment = projection.getLoanExtraPayment().getYearlyValues()[yearIndex];
		propertyTax = projection.getPropertyTax().getYearlyValues()[yearIndex];
		propertyInsurance = projection.getPropertyInsurance().getYearlyValues()[yearIndex];
		hoa = projection.getHoa().getYearlyValues()[yearIndex];
		leasingFee = projection.getLeasingFee().getYearlyValues()[yearIndex];
		assetManagementFee = projection.getAssetManagementFee().getYearlyValues()[yearIndex];
		repairAndMaintenanceFee = projection.getRepairAndMaintenanceFee().getYearlyValues()[yearIndex];
		utilitiesLandscape = projection.getUtilitiesLandscape().getYearlyValues()[yearIndex];
		operatingExpenses = projection.getOperatingExpenses().getYearlyValues()[yearIndex];
		netOperatingIncome = projection.getNetOperatingIncome().getYearlyValues()[yearIndex];
		cashflow = projection.getCashflow().getYearlyValues()[yearIndex];
		investment = projection.getInvestment();
		yield = projection.getYield().getYearlyValues()[yearIndex] / 100;
		cashOnCashReturn = projection.getCashOnCashReturn().getYearlyValues()[yearIndex] / 100;
		capRate = projection.getCapRate().getYearlyValues()[yearIndex] / 100;
		price = projection.getPrice();
		if (projection.getRehabCost() >= 2500) {
			price += projection.getRehabCost();
		}
		debtServiceCoverageRatio = projection.getDebtServiceCoverageRatio().getYearlyValues()[yearIndex];
	}

	public Integer getYear() {

		return year;
	}

	public void setYear(Integer year) {

		this.year = year;
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

	public Double getVacancyLoss() {

		return vacancyLoss;
	}

	public void setVacancyLoss(Double vacancyLoss) {

		this.vacancyLoss = vacancyLoss;
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

	public Double getInvestment() {

		return investment;
	}

	public void setInvestment(Double investment) {

		this.investment = investment;
	}

	public Double getYield() {

		return yield;
	}

	public void setYield(Double yield) {

		this.yield = yield;
	}

	public Double getCashOnCashReturn() {

		return cashOnCashReturn;
	}

	public void setCashOnCashReturn(Double cashOnCashReturn) {

		this.cashOnCashReturn = cashOnCashReturn;
	}

	public Double getCapRate() {

		return capRate;
	}

	public void setCapRate(Double capRate) {

		this.capRate = capRate;
	}

	public Double getPrice() {

		return price;
	}

	public void setPrice(Double price) {

		this.price = price;
	}

	public Double getDebtServiceCoverageRatio() {

		return debtServiceCoverageRatio;
	}

	public void setDebtServiceCoverageRatio(Double debtServiceCoverageRatio) {

		this.debtServiceCoverageRatio = debtServiceCoverageRatio;
	}

	public Double getLoanExtraPayment() {

		return loanExtraPayment;
	}

	public void setLoanExtraPayment(Double loanExtraPayment) {

		this.loanExtraPayment = loanExtraPayment;
	}
}
