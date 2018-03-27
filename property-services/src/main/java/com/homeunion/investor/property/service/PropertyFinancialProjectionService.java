
package com.homeunion.investor.property.service;

import java.io.IOException;

import com.homeunion.investor.common.domain.FileInfo;
import com.homeunion.investor.property.domain.financial.FinancialProjectionInput;
import com.homeunion.investor.property.domain.financial.excel.FinancialProjectionReportType;

public interface PropertyFinancialProjectionService {

	FileInfo getFinancialProjectionJS(String hil, String zip);

	FileInfo getDetailedCalculationAsExcel(boolean leveraged, FinancialProjectionReportType type, FinancialProjectionInput projection) throws IOException;
}
