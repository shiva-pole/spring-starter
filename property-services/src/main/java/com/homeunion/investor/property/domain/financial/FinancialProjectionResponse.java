
package com.homeunion.investor.property.domain.financial;

import com.homeunion.investor.response.BaseResponse;

public class FinancialProjectionResponse extends BaseResponse {

	private FinancialProjection financedProjection;
	private FinancialProjection allCashProjection;

	public FinancialProjection getFinancedProjection() {

		return financedProjection;
	}

	public void setFinancedProjection(FinancialProjection financedProjection) {

		this.financedProjection = financedProjection;
	}

	public FinancialProjection getAllCashProjection() {

		return allCashProjection;
	}

	public void setAllCashProjection(FinancialProjection allCashProjection) {

		this.allCashProjection = allCashProjection;
	}
}
