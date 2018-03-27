
package com.homeunion.investor.property.domain.financial.excel;

import com.homeunion.investor.property.domain.financial.FinancialProjection;

public class AmmortizationRow {

	private Integer month;
	private Double payment;
	private Double interest;
	private Double principal;
	private Double outstanding;
	private Double equity;
	private Double extraPayment;

	public AmmortizationRow(FinancialProjection projection, int monthIndex) {

		month = monthIndex + 1;
		payment = projection.getLoanPayment().getMonthlyValues()[monthIndex];
		interest = projection.getLoanInterest().getMonthlyValues()[monthIndex];
		principal = projection.getLoanPrincipal().getMonthlyValues()[monthIndex];
		outstanding = projection.getLoanOutstanding().getMonthlyValues()[monthIndex];
		equity = projection.getLoanEquity().getMonthlyValues()[monthIndex];
		extraPayment = projection.getLoanExtraPayment().getMonthlyValues()[monthIndex];
	}

	public Integer getMonth() {

		return month;
	}

	public void setMonth(Integer month) {

		this.month = month;
	}

	public Double getPayment() {

		return payment;
	}

	public void setPayment(Double payment) {

		this.payment = payment;
	}

	public Double getInterest() {

		return interest;
	}

	public void setInterest(Double interest) {

		this.interest = interest;
	}

	public Double getPrincipal() {

		return principal;
	}

	public void setPrincipal(Double principal) {

		this.principal = principal;
	}

	public Double getOutstanding() {

		return outstanding;
	}

	public void setOutstanding(Double outstanding) {

		this.outstanding = outstanding;
	}

	public Double getEquity() {

		return equity;
	}

	public void setEquity(Double equity) {

		this.equity = equity;
	}

	public Double getExtraPayment() {

		return extraPayment;
	}

	public void setExtraPayment(Double extraPayment) {

		this.extraPayment = extraPayment;
	}
}
