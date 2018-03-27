
package com.homeunion.investor.property.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.homeunion.investor.property.domain.PropertySummary;

public abstract class BasePropertySummaryMapper extends PropertyBasicInfoMapper {

	private PropertyListingInfoMapper propertyListingInfoMapper = new PropertyListingInfoMapper();

	protected <T extends PropertySummary> T mapPropertySummaryAttributes(T propertySummary, ResultSet rs, int rowNum) throws SQLException {

		//map basic info attributes
		mapPropertyBasicInfoAttributes(propertySummary, rs);
		//map other summary attributes
		propertySummary.setAskingPrice(rs.getDouble("asking_price"));
		propertySummary.setAllCashInvestment(rs.getDouble("allcash_investment"));
		propertySummary.setFinancedInvestment(rs.getDouble("financed_investment"));
		propertySummary.setAllCashCashFlow(rs.getDouble("annual_noi"));
		propertySummary.setFinancedCashFlow(rs.getDouble("financed_annual_cashflow_netof_interest"));
		propertySummary.setAllCashNetCashFlowOverIP(rs.getDouble("allcash_net_cash_flow_over_investment_period"));
		propertySummary.setFinancedNetCashFlowOverIP(rs.getDouble("financed_net_cash_flow_over_investment_period"));
		propertySummary.setAllCashAnnualCashFlow(rs.getDouble("annual_noi"));
		propertySummary.setFinancedAnnualCashFlow(rs.getDouble("annual_net_cashflow"));
		propertySummary.setAllCashCashOnCashReturn(rs.getDouble("allcash_oncash_return"));
		propertySummary.setFinancedCashOnCashReturn(rs.getDouble("financed_cash_oncash_return"));
		propertySummary.setAllCashReturn(rs.getDouble("allcash_oncash_return"));
		propertySummary.setFinancedReturn(rs.getDouble("financed_return"));
		propertySummary.setAllCashTotalReturn(rs.getDouble("allcash_total_annualized_return"));
		propertySummary.setFinancedTotalReturn(rs.getDouble("financed_total_annualized_return"));
		propertySummary.setProjectedAppreciationRate(rs.getDouble("projected_appreciation_rate"));
		propertySummary.setAppreciationRate(rs.getDouble("appreciation_rate"));
		propertySummary.setLeasedRent(rs.getDouble("leased_rent"));
		propertySummary.setDownPaymentPercentage(rs.getDouble("down_payment_percentage"));
		propertySummary.setRehabEstimate(rs.getDouble("rehab_estimate"));
		propertySummary.setPropertyManagementFeeAnnual(rs.getDouble("property_management_fee_annual"));
		propertySummary.setPropertyTaxesAnnual(rs.getDouble("property_taxes_annual"));
		propertySummary.setPropertyTaxesMonthly(rs.getDouble("property_taxes_monthly"));
		propertySummary.setPropertyInsuranceAnnual(rs.getDouble("property_insurance_annual"));
		propertySummary.setPropertyInsuranceMonthly(rs.getDouble("property_insurance_monthly"));
		propertySummary.setHoaFeeAnnual(rs.getDouble("hoa_fee_annual"));
		propertySummary.setHoaFeeMonthly(rs.getDouble("hoa_fee_monthly"));
		propertySummary.setAnnualLeasingFee(rs.getDouble("annual_leasing_fee"));
		propertySummary.setPhotoLink(rs.getString("thumbnail_link"));
		propertySummary.setAssetClassId(rs.getInt("propertyassetclassid"));
		propertySummary.setHuSelect(rs.getBoolean("huselect"));
		propertySummary.setPropertyListing(propertyListingInfoMapper.mapRow(rs, rowNum));
		return propertySummary;
	}
}
