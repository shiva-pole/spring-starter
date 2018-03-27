
package com.homeunion.investor.property.domain.financial.excel;

import com.homeunion.investor.common.excel.domain.ExcelTemplateType;

public enum FinancialProjectionReportType {
	DETAILED_CALCULATIONS(ExcelTemplateType.FINANCIAL_PROJECTION_DETAILED_CALCULATIONS),
	AMORTIZATION(ExcelTemplateType.FINANCIAL_PROJECTION_AMORTIZATION),
	ANNUAL_RETURNS(ExcelTemplateType.FINANCIAL_PROJECTION_ANNUAL_RETURNS),
	STABILIZATION_PERIOD(ExcelTemplateType.FINANCIAL_PROJECTION_STABILIZATION_PERIOD),
	RETURNS_ON_INVESTMENT(ExcelTemplateType.FINANCIAL_PROJECTION_RETURNS_ON_INVESTMENT);

	private ExcelTemplateType templateType;

	private FinancialProjectionReportType(ExcelTemplateType templateType) {

		this.templateType = templateType;
	}

	public ExcelTemplateType getTemplateType() {

		return templateType;
	}

	public void setTemplateType(ExcelTemplateType templateType) {

		this.templateType = templateType;
	}
}
