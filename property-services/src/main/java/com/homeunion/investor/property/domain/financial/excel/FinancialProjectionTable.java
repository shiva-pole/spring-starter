
package com.homeunion.investor.property.domain.financial.excel;

import java.util.ArrayList;
import java.util.List;

import com.homeunion.investor.property.domain.financial.FinancialProjection;

public class FinancialProjectionTable {

	private List<AmmortizationRow> loans = new ArrayList<AmmortizationRow>();
	private List<AnnualReturnsRow> annualReturns = new ArrayList<AnnualReturnsRow>();
	private List<StabilizationPeriodRow> stabilizationPeriods = new ArrayList<StabilizationPeriodRow>();
	private List<ReturnsOnInvestmentRow> returnsOnInvestments = new ArrayList<ReturnsOnInvestmentRow>();

	public FinancialProjectionTable(FinancialProjection projection) {

		for (int i = 0; i < projection.getLoanPayment().getMonthlyValues().length; i++) {
			if (projection.getLoanPayment().getMonthlyValues()[i] > 0) {
				loans.add(new AmmortizationRow(projection, i));
			} else {
				break;
			}
		}
		for (int i = 0; i < projection.getProjectionTerm(); i++) {
			annualReturns.add(new AnnualReturnsRow(projection, i));
		}
		for (int i = 0; i <= projection.getStabilizationPeriod(); i++) {
			stabilizationPeriods.add(new StabilizationPeriodRow(projection, i));
		}
		int[] years = new int[] { 4, 9, 14 };
		if (projection.getProjectionTerm() > 15) {
			years = new int[] { 9, 14, 29 };
		}
		for (int i : years) {
			returnsOnInvestments.add(new ReturnsOnInvestmentRow(projection, i));
		}
	}

	public List<AmmortizationRow> getLoans() {

		return loans;
	}

	public void setLoans(List<AmmortizationRow> loans) {

		this.loans = loans;
	}

	public List<AnnualReturnsRow> getAnnualReturns() {

		return annualReturns;
	}

	public void setAnnualReturns(List<AnnualReturnsRow> annualReturns) {

		this.annualReturns = annualReturns;
	}

	public List<StabilizationPeriodRow> getStabilizationPeriods() {

		return stabilizationPeriods;
	}

	public void setStabilizationPeriods(List<StabilizationPeriodRow> stabilizationPeriods) {

		this.stabilizationPeriods = stabilizationPeriods;
	}

	public List<ReturnsOnInvestmentRow> getReturnsOnInvestments() {

		return returnsOnInvestments;
	}

	public void setReturnsOnInvestments(List<ReturnsOnInvestmentRow> returnsOnInvestments) {

		this.returnsOnInvestments = returnsOnInvestments;
	}
}
