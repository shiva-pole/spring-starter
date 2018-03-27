
package com.homeunion.investor.property.domain;

import org.apache.solr.client.solrj.beans.Field;

import com.homeunion.investor.assetclass.domain.MlsInfo;

public class PropertySummary extends PropertyBasicInfo {

	@Field("asking_price")
	private Double askingPrice;
	@Field("allcash_investment")
	private Double allCashInvestment;
	@Field("financed_investment")
	private Double financedInvestment;
	@Field("annual_noi")
	private Double allCashCashFlow;
	@Field("financed_annual_cashflow_netof_interest")
	private Double financedCashFlow;
	@Field("allcash_net_cash_flow_over_investment_period")
	private Double allCashNetCashFlowOverIP;
	@Field("financed_net_cash_flow_over_investment_period")
	private Double financedNetCashFlowOverIP;
	@Field("annual_net_cashflow")
	private Double allCashAnnualCashFlow;
	@Field("annual_net_cashflow")
	private Double financedAnnualCashFlow;
	@Field("allcash_oncash_return")
	private Double allCashCashOnCashReturn;
	@Field("financed_cash_oncash_return")
	private Double financedCashOnCashReturn;
	@Field("allcash_oncash_return")
	private Double allCashReturn;
	@Field("financed_return")
	private Double financedReturn;
	@Field("allcash_total_annualized_return")
	private Double allCashTotalReturn;
	@Field("financed_total_annualized_return")
	private Double financedTotalReturn;
	@Field("projected_appreciation_rate")
	private Double projectedAppreciationRate;
	@Field("appreciation_rate")
	private Double appreciationRate;
	@Field("leased_rent")
	private Double leasedRent;
	@Field("down_payment_percentage")
	private Double downPaymentPercentage;
	@Field("rehab_estimate")
	private Double rehabEstimate;
	@Field("property_management_fee_annual")
	private Double propertyManagementFeeAnnual;
	@Field("property_taxes_annual")
	private Double propertyTaxesAnnual;
	@Field("property_taxes_monthly")
	private Double propertyTaxesMonthly;
	@Field("property_insurance_annual")
	private Double propertyInsuranceAnnual;
	@Field("property_insurance_monthly")
	private Double propertyInsuranceMonthly;
	@Field("hoa_fee_annual")
	private Double hoaFeeAnnual;
	@Field("hoa_fee_monthly")
	private Double hoaFeeMonthly;
	@Field("annual_leasing_fee")
	private Double annualLeasingFee;
	@Field("propertyassetclassid")
	private Integer assetClassId;
	private String assetClassName;
	private String assetClassNameUri;
	private String investmentGoal;
	private String hilGroupName;
	@Field("huselect")
	private Boolean huSelect;
	/* TO DO ADD MLSNAME IN SOLR QUERY AND ADD FIELD ANNOTATION*/
	private PropertyListingInfo propertyListing;
	private MlsInfo mlsInfo;

	public String getHilGroupName() {

		return hilGroupName;
	}

	public void setHilGroupName(String hilGroupName) {

		this.hilGroupName = hilGroupName;
	}

	public Double getAskingPrice() {

		return askingPrice;
	}

	public void setAskingPrice(Double askingPrice) {

		this.askingPrice = askingPrice;
	}

	public Double getAllCashInvestment() {

		return allCashInvestment;
	}

	public void setAllCashInvestment(Double allCashInvestment) {

		this.allCashInvestment = allCashInvestment;
	}

	public Double getFinancedInvestment() {

		return financedInvestment;
	}

	public void setFinancedInvestment(Double financedInvestment) {

		this.financedInvestment = financedInvestment;
	}

	public Double getAllCashCashFlow() {

		return allCashCashFlow;
	}

	public void setAllCashCashFlow(Double allCashCashFlow) {

		this.allCashCashFlow = allCashCashFlow;
	}

	public Double getFinancedCashFlow() {

		return financedCashFlow;
	}

	public void setFinancedCashFlow(Double financedCashFlow) {

		this.financedCashFlow = financedCashFlow;
	}

	public Double getAllCashNetCashFlowOverIP() {

		return allCashNetCashFlowOverIP;
	}

	public void setAllCashNetCashFlowOverIP(Double allCashNetCashFlowOverIP) {

		this.allCashNetCashFlowOverIP = allCashNetCashFlowOverIP;
	}

	public Double getFinancedNetCashFlowOverIP() {

		return financedNetCashFlowOverIP;
	}

	public void setFinancedNetCashFlowOverIP(Double financedNetCashFlowOverIP) {

		this.financedNetCashFlowOverIP = financedNetCashFlowOverIP;
	}

	public Double getAllCashAnnualCashFlow() {

		return allCashAnnualCashFlow;
	}

	public void setAllCashAnnualCashFlow(Double allCashAnnualCashFlow) {

		this.allCashAnnualCashFlow = allCashAnnualCashFlow;
	}

	public Double getFinancedAnnualCashFlow() {

		return financedAnnualCashFlow;
	}

	public void setFinancedAnnualCashFlow(Double financedAnnualCashFlow) {

		this.financedAnnualCashFlow = financedAnnualCashFlow;
	}

	public Double getAllCashCashOnCashReturn() {

		return allCashCashOnCashReturn;
	}

	public void setAllCashCashOnCashReturn(Double allCashCashOnCashReturn) {

		this.allCashCashOnCashReturn = allCashCashOnCashReturn;
	}

	public Double getFinancedCashOnCashReturn() {

		return financedCashOnCashReturn;
	}

	public void setFinancedCashOnCashReturn(Double financedCashOnCashReturn) {

		this.financedCashOnCashReturn = financedCashOnCashReturn;
	}

	public Double getAllCashReturn() {

		return allCashReturn;
	}

	public void setAllCashReturn(Double allCashReturn) {

		this.allCashReturn = allCashReturn;
	}

	public Double getFinancedReturn() {

		return financedReturn;
	}

	public void setFinancedReturn(Double financedReturn) {

		this.financedReturn = financedReturn;
	}

	public Double getAllCashTotalReturn() {

		return allCashTotalReturn;
	}

	public void setAllCashTotalReturn(Double allCashTotalReturn) {

		this.allCashTotalReturn = allCashTotalReturn;
	}

	public Double getFinancedTotalReturn() {

		return financedTotalReturn;
	}

	public void setFinancedTotalReturn(Double financedTotalReturn) {

		this.financedTotalReturn = financedTotalReturn;
	}

	public Double getProjectedAppreciationRate() {

		return projectedAppreciationRate;
	}

	public void setProjectedAppreciationRate(Double projectedAppreciationRate) {

		this.projectedAppreciationRate = projectedAppreciationRate;
	}

	public Double getAppreciationRate() {

		return appreciationRate;
	}

	public void setAppreciationRate(Double appreciationRate) {

		this.appreciationRate = appreciationRate;
	}

	public Double getLeasedRent() {

		return leasedRent;
	}

	public void setLeasedRent(Double leasedRent) {

		this.leasedRent = leasedRent;
	}

	public Double getDownPaymentPercentage() {

		return downPaymentPercentage;
	}

	public void setDownPaymentPercentage(Double downPaymentPercentage) {

		this.downPaymentPercentage = downPaymentPercentage;
	}

	public Double getRehabEstimate() {

		return rehabEstimate;
	}

	public void setRehabEstimate(Double rehabEstimate) {

		this.rehabEstimate = rehabEstimate;
	}

	public Double getPropertyManagementFeeAnnual() {

		return propertyManagementFeeAnnual;
	}

	public void setPropertyManagementFeeAnnual(Double propertyManagementFeeAnnual) {

		this.propertyManagementFeeAnnual = propertyManagementFeeAnnual;
	}

	public Double getPropertyTaxesAnnual() {

		return propertyTaxesAnnual;
	}

	public void setPropertyTaxesAnnual(Double propertyTaxesAnnual) {

		this.propertyTaxesAnnual = propertyTaxesAnnual;
	}

	public Double getPropertyTaxesMonthly() {

		return propertyTaxesMonthly;
	}

	public void setPropertyTaxesMonthly(Double propertyTaxesMonthly) {

		this.propertyTaxesMonthly = propertyTaxesMonthly;
	}

	public Double getPropertyInsuranceAnnual() {

		return propertyInsuranceAnnual;
	}

	public void setPropertyInsuranceAnnual(Double propertyInsuranceAnnual) {

		this.propertyInsuranceAnnual = propertyInsuranceAnnual;
	}

	public Double getPropertyInsuranceMonthly() {

		return propertyInsuranceMonthly;
	}

	public void setPropertyInsuranceMonthly(Double propertyInsuranceMonthly) {

		this.propertyInsuranceMonthly = propertyInsuranceMonthly;
	}

	public Double getHoaFeeAnnual() {

		return hoaFeeAnnual;
	}

	public void setHoaFeeAnnual(Double hoaFeeAnnual) {

		this.hoaFeeAnnual = hoaFeeAnnual;
	}

	public Double getHoaFeeMonthly() {

		return hoaFeeMonthly;
	}

	public void setHoaFeeMonthly(Double hoaFeeMonthly) {

		this.hoaFeeMonthly = hoaFeeMonthly;
	}

	public Double getAnnualLeasingFee() {

		return annualLeasingFee;
	}

	public void setAnnualLeasingFee(Double annualLeasingFee) {

		this.annualLeasingFee = annualLeasingFee;
	}

	public Integer getAssetClassId() {

		return assetClassId;
	}

	public void setAssetClassId(Integer assetClassId) {

		this.assetClassId = assetClassId;
	}

	public String getAssetClassName() {

		return assetClassName;
	}

	public void setAssetClassName(String assetClassName) {

		this.assetClassName = assetClassName;
	}

	public String getAssetClassNameUri() {

		return assetClassNameUri;
	}

	public void setAssetClassNameUri(String assetClassNameUri) {

		this.assetClassNameUri = assetClassNameUri;
	}

	public String getInvestmentGoal() {

		return investmentGoal;
	}

	public void setInvestmentGoal(String investmentGoal) {

		this.investmentGoal = investmentGoal;
	}

	public Boolean getHuSelect() {

		return huSelect;
	}

	public void setHuSelect(Boolean huSelect) {

		this.huSelect = huSelect;
	}

	public PropertyListingInfo getPropertyListing() {

		return propertyListing;
	}

	public void setPropertyListing(PropertyListingInfo listingInfo) {

		this.propertyListing = listingInfo;
	}

	public MlsInfo getMlsInfo() {

		return mlsInfo;
	}

	public void setMlsInfo(MlsInfo mlsInfo) {

		this.mlsInfo = mlsInfo;
	}
}
