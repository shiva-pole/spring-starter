
package com.homeunion.investor.property.domain.financial.excel;

import com.homeunion.investor.property.domain.financial.FinancialProjection;

public class ReturnsOnInvestmentRow {

	private Integer year;
	private Double projectedPrice;
	private Double loanOutstanding;
	private Double sellingCost;
	private Double grossSalesProceeds;
	private Double investment;
	private Double netSalesProceeds;
	private Double accumulatedNetOperatingIncome;
	private Double accumulatedLoanInterest;
	private Double annualizedYield;
	private Double accumulatedCashflow;
	private Double annualizedCashOnCash;
	private Double totalAnnualizedReturn;

	public ReturnsOnInvestmentRow(FinancialProjection projection, int yearIndex) {

		year = yearIndex + 1;
		projectedPrice = projection.getProjectedPrice().getYearlyValues()[yearIndex];
		loanOutstanding = projection.getLoanOutstanding().getYearlyValues()[yearIndex];
		sellingCost = projection.getSellingCost().getYearlyValues()[yearIndex];
		grossSalesProceeds = projection.getGrossSalesProceeds().getYearlyValues()[yearIndex];
		investment = projection.getInvestment();
		netSalesProceeds = projection.getNetSalesProceeds().getYearlyValues()[yearIndex];
		accumulatedNetOperatingIncome = projection.getAccumulatedNetOperatingIncome().getYearlyValues()[yearIndex];
		accumulatedLoanInterest = projection.getAccumulatedLoanInterest().getYearlyValues()[yearIndex];
		annualizedYield = projection.getAnnualizedYield().getYearlyValues()[yearIndex] / 100;
		accumulatedCashflow = projection.getAccumulatedCashflow().getYearlyValues()[yearIndex];
		annualizedCashOnCash = projection.getAnnualizedCashOnCash().getYearlyValues()[yearIndex] / 100;
		totalAnnualizedReturn = projection.getTotalAnnualizedReturn().getYearlyValues()[yearIndex] / 100;
	}

	public Integer getYear() {

		return year;
	}

	public void setYear(Integer year) {

		this.year = year;
	}

	public Double getProjectedPrice() {

		return projectedPrice;
	}

	public void setProjectedPrice(Double projectedPrice) {

		this.projectedPrice = projectedPrice;
	}

	public Double getLoanOutstanding() {

		return loanOutstanding;
	}

	public void setLoanOutstanding(Double loanOutstanding) {

		this.loanOutstanding = loanOutstanding;
	}

	public Double getSellingCost() {

		return sellingCost;
	}

	public void setSellingCost(Double sellingCost) {

		this.sellingCost = sellingCost;
	}

	public Double getGrossSalesProceeds() {

		return grossSalesProceeds;
	}

	public void setGrossSalesProceeds(Double grossSalesProceeds) {

		this.grossSalesProceeds = grossSalesProceeds;
	}

	public Double getInvestment() {

		return investment;
	}

	public void setInvestment(Double investment) {

		this.investment = investment;
	}

	public Double getNetSalesProceeds() {

		return netSalesProceeds;
	}

	public void setNetSalesProceeds(Double netSalesProceeds) {

		this.netSalesProceeds = netSalesProceeds;
	}

	public Double getAccumulatedNetOperatingIncome() {

		return accumulatedNetOperatingIncome;
	}

	public void setAccumulatedNetOperatingIncome(Double accumulatedNetOperatingIncome) {

		this.accumulatedNetOperatingIncome = accumulatedNetOperatingIncome;
	}

	public Double getAccumulatedLoanInterest() {

		return accumulatedLoanInterest;
	}

	public void setAccumulatedLoanInterest(Double accumulatedLoanInterest) {

		this.accumulatedLoanInterest = accumulatedLoanInterest;
	}

	public Double getAnnualizedYield() {

		return annualizedYield;
	}

	public void setAnnualizedYield(Double annualizedYield) {

		this.annualizedYield = annualizedYield;
	}

	public Double getAccumulatedCashflow() {

		return accumulatedCashflow;
	}

	public void setAccumulatedCashflow(Double accumulatedCashflow) {

		this.accumulatedCashflow = accumulatedCashflow;
	}

	public Double getAnnualizedCashOnCash() {

		return annualizedCashOnCash;
	}

	public void setAnnualizedCashOnCash(Double annualizedCashOnCash) {

		this.annualizedCashOnCash = annualizedCashOnCash;
	}

	public Double getTotalAnnualizedReturn() {

		return totalAnnualizedReturn;
	}

	public void setTotalAnnualizedReturn(Double totalAnnualizedReturn) {

		this.totalAnnualizedReturn = totalAnnualizedReturn;
	}
}
