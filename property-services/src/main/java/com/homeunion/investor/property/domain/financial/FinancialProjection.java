
package com.homeunion.investor.property.domain.financial;

public class FinancialProjection {

	private int projectionTerm;
	private double price;
	private double rent;
	private int reinvestCashflow;
	private double lengthOfStay;
	private double rehabCost;
	private double closingCostPercent;
	private double closingCost;
	private double downpaymentPercent;
	private double recommendedDownPaymentPercent;
	private double downpaymentAmount;
	private double minLoanAmount;
	private double loanAmount;
	private double monthlyInstallment;
	private int loanTerm;
	private double loanFeePercent;
	private double loanFee;
	private double acquisitionFeePercent;
	private double acquisitionFeeMax;
	private double acquisitionFee;
	private double repairAndMaintenanceReserve;
	private double investment;
	private int stabilizationPeriod;
	private MarketNirAssumptions marketNirAssumptions;
	private double rentalGrowthRate;
	private double rentalGrowthRate6YearPlus;
	private MultiYearValue rentalIncome;
	private double vacancyPercent;
	private MultiYearValue vacancyLoss;
	private double timeToRent;
	private double plannedVacancyPercent;
	private MultiYearValue netRentalIncome;
	private double expenseInflationRate;
	private MultiYearValue propertyTax;
	private double insuranceOccupied;
	private double insuranceVacant;
	private MultiYearValue propertyInsurance;
	private MultiYearValue hoa;
	private double leasingFeePercentNewTenant;
	private double leasingFeeTenantRenewal;
	private MultiYearValue leasingFee;
	private double assetFeePercent;
	private double assetFeeMin;
	private MultiYearValue assetManagementFee;
	private double repairAndMaintenanceFeePercent;
	private MultiYearValue repairAndMaintenanceFee;
	private double monthlyUtilitiesCost;
	private MultiYearValue utilitiesLandscape;
	private MultiYearValue operatingExpenses;
	private MultiYearValue netOperatingIncome;
	private double interestRate;
	private MultiMonthValue loanPayment;
	private MultiMonthValue loanInterest;
	private MultiMonthValue loanPrincipal;
	private MultiMonthValue loanOutstanding;
	private MultiMonthValue loanEquity;
	private MultiMonthValue loanExtraPayment;
	private MultiYearValue cashflow;
	private MultiYearValue netIncome;
	private MultiYearValue yield;
	private MultiYearValue cashOnCashReturn;
	private MultiYearValue capRate;
	private double targetDSCR;
	private MultiYearValue debtServiceCoverageRatio;
	private int loanPaidOffYear;
	private double extraPaymentLoanSaved;
	private double extraPaymentMonthsSaved;
	private double prepayTaxAndInsurance;
	private double otherCosts;
	private boolean isLeasingYear[];
	private double priceRentRatio;
	private double rentPriceRatio;
	private MultiYearValue totalExpenses;
	private MultiYearValue netCashFlow;
	private MultiYearValue accumulatedCashflow;
	private String investmentGoal;
	private double appreciationRate;
	private double appreciationRate6YearPlus;
	private MultiYearValue appreciationValue;
	private MultiYearValue cumulativePrincipal;
	private MultiYearValue projectedPrice;
	private MultiYearValue cagr;
	private MultiYearValue totalEquity;
	private MultiYearValue totalWealth;
	private double sellingCostPercent;
	private MultiYearValue sellingCost;
	private MultiYearValue grossSalesProceeds;
	private MultiYearValue netSalesProceeds;
	private MultiYearValue annualizedYield;
	private MultiYearValue annualizedCashOnCash;
	private MultiYearValue cashflowOverInvestmentPeriod;
	private MultiYearValue totalReturn;
	private MultiYearValue totalAnnualizedReturn;
	private MultiYearValue accumulatedLoanInterest;
	private MultiYearValue accumulatedLoanPayment;
	private MultiYearValue accumulatedNetOperatingIncome;
	private MultiYearValue irr;
	private SdiraData sdiraData;
	private StabilizationPeriodData stabilizationData;
	private MonthlyIncomeStatement monthlyStatement;

	public double getRentPriceRatio() {

		return rentPriceRatio;
	}

	public void setRentPriceRatio(double rentPriceRatio) {

		this.rentPriceRatio = rentPriceRatio;
	}

	public MultiYearValue getAccumulatedLoanPayment() {

		return accumulatedLoanPayment;
	}

	public void setAccumulatedLoanPayment(MultiYearValue accumulatedLoanPayment) {

		this.accumulatedLoanPayment = accumulatedLoanPayment;
	}

	public double getAppreciationRate6YearPlus() {

		return appreciationRate6YearPlus;
	}

	public void setAppreciationRate6YearPlus(double appreciationRate6YearPlus) {

		this.appreciationRate6YearPlus = appreciationRate6YearPlus;
	}

	public MultiYearValue getAccumulatedLoanInterest() {

		return accumulatedLoanInterest;
	}

	public void setAccumulatedLoanInterest(MultiYearValue accumulatedLoanInterest) {

		this.accumulatedLoanInterest = accumulatedLoanInterest;
	}

	public MultiYearValue getAccumulatedNetOperatingIncome() {

		return accumulatedNetOperatingIncome;
	}

	public void setAccumulatedNetOperatingIncome(MultiYearValue accumulatedNetOperatingIncome) {

		this.accumulatedNetOperatingIncome = accumulatedNetOperatingIncome;
	}

	public double getRentalGrowthRate6YearPlus() {

		return rentalGrowthRate6YearPlus;
	}

	public void setRentalGrowthRate6YearPlus(double rentalGrowthRate6YearPlus) {

		this.rentalGrowthRate6YearPlus = rentalGrowthRate6YearPlus;
	}

	public int getProjectionTerm() {

		return projectionTerm;
	}

	public void setProjectionTerm(int projectionTerm) {

		this.projectionTerm = projectionTerm;
	}

	public double getPrice() {

		return price;
	}

	public void setPrice(double price) {

		this.price = price;
	}

	public double getRent() {

		return rent;
	}

	public void setRent(double rent) {

		this.rent = rent;
	}

	public int getReinvestCashflow() {

		return reinvestCashflow;
	}

	public void setReinvestCashflow(int reinvestCashflow) {

		this.reinvestCashflow = reinvestCashflow;
	}

	public double getLengthOfStay() {

		return lengthOfStay;
	}

	public void setLengthOfStay(double lengthOfStay) {

		this.lengthOfStay = lengthOfStay;
	}

	public double getRehabCost() {

		return rehabCost;
	}

	public void setRehabCost(double rehabCost) {

		this.rehabCost = rehabCost;
	}

	public double getClosingCostPercent() {

		return closingCostPercent;
	}

	public void setClosingCostPercent(double closingCostPercent) {

		this.closingCostPercent = closingCostPercent;
	}

	public double getClosingCost() {

		return closingCost;
	}

	public void setClosingCost(double closingCost) {

		this.closingCost = closingCost;
	}

	public double getDownpaymentPercent() {

		return downpaymentPercent;
	}

	public void setDownpaymentPercent(double downpaymentPercent) {

		this.downpaymentPercent = downpaymentPercent;
	}

	public double getRecommendedDownPaymentPercent() {

		return recommendedDownPaymentPercent;
	}

	public void setRecommendedDownPaymentPercent(double recommendedDownPaymentPercent) {

		this.recommendedDownPaymentPercent = recommendedDownPaymentPercent;
	}

	public double getDownpaymentAmount() {

		return downpaymentAmount;
	}

	public void setDownpaymentAmount(double downpaymentAmount) {

		this.downpaymentAmount = downpaymentAmount;
	}

	public double getMinLoanAmount() {

		return minLoanAmount;
	}

	public void setMinLoanAmount(double minLoanAmount) {

		this.minLoanAmount = minLoanAmount;
	}

	public double getLoanAmount() {

		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {

		this.loanAmount = loanAmount;
	}

	public double getMonthlyInstallment() {

		return monthlyInstallment;
	}

	public void setMonthlyInstallment(double monthlyInstallment) {

		this.monthlyInstallment = monthlyInstallment;
	}

	public int getLoanTerm() {

		return loanTerm;
	}

	public void setLoanTerm(int loanTerm) {

		this.loanTerm = loanTerm;
	}

	public double getLoanFeePercent() {

		return loanFeePercent;
	}

	public void setLoanFeePercent(double loanFeePercent) {

		this.loanFeePercent = loanFeePercent;
	}

	public double getLoanFee() {

		return loanFee;
	}

	public void setLoanFee(double loanFee) {

		this.loanFee = loanFee;
	}

	public double getAcquisitionFeePercent() {

		return acquisitionFeePercent;
	}

	public void setAcquisitionFeePercent(double acquisitionFeePercent) {

		this.acquisitionFeePercent = acquisitionFeePercent;
	}

	public double getAcquisitionFeeMax() {

		return acquisitionFeeMax;
	}

	public void setAcquisitionFeeMax(double acquisitionFeeMax) {

		this.acquisitionFeeMax = acquisitionFeeMax;
	}

	public double getAcquisitionFee() {

		return acquisitionFee;
	}

	public void setAcquisitionFee(double acquisitionFee) {

		this.acquisitionFee = acquisitionFee;
	}

	public double getRepairAndMaintenanceReserve() {

		return repairAndMaintenanceReserve;
	}

	public void setRepairAndMaintenanceReserve(double repairAndMaintenanceReserve) {

		this.repairAndMaintenanceReserve = repairAndMaintenanceReserve;
	}

	public double getInvestment() {

		return investment;
	}

	public void setInvestment(double investment) {

		this.investment = investment;
	}

	public int getStabilizationPeriod() {

		return stabilizationPeriod;
	}

	public void setStabilizationPeriod(int stabilizationPeriod) {

		this.stabilizationPeriod = stabilizationPeriod;
	}

	public double getRentalGrowthRate() {

		return rentalGrowthRate;
	}

	public void setRentalGrowthRate(double rentalGrowthRate) {

		this.rentalGrowthRate = rentalGrowthRate;
	}

	public MultiYearValue getRentalIncome() {

		return rentalIncome;
	}

	public void setRentalIncome(MultiYearValue rentalIncome) {

		this.rentalIncome = rentalIncome;
	}

	public double getVacancyPercent() {

		return vacancyPercent;
	}

	public void setVacancyPercent(double vacancyPercent) {

		this.vacancyPercent = vacancyPercent;
	}

	public MultiYearValue getVacancyLoss() {

		return vacancyLoss;
	}

	public void setVacancyLoss(MultiYearValue vacancyLoss) {

		this.vacancyLoss = vacancyLoss;
	}

	public double getTimeToRent() {

		return timeToRent;
	}

	public void setTimeToRent(double timeToRent) {

		this.timeToRent = timeToRent;
	}

	public double getPlannedVacancyPercent() {

		return plannedVacancyPercent;
	}

	public void setPlannedVacancyPercent(double plannedVacancyPercent) {

		this.plannedVacancyPercent = plannedVacancyPercent;
	}

	public MultiYearValue getNetRentalIncome() {

		return netRentalIncome;
	}

	public void setNetRentalIncome(MultiYearValue netRentalIncome) {

		this.netRentalIncome = netRentalIncome;
	}

	public double getExpenseInflationRate() {

		return expenseInflationRate;
	}

	public void setExpenseInflationRate(double expenseInflationRate) {

		this.expenseInflationRate = expenseInflationRate;
	}

	public MultiYearValue getPropertyTax() {

		return propertyTax;
	}

	public void setPropertyTax(MultiYearValue propertyTax) {

		this.propertyTax = propertyTax;
	}

	public double getInsuranceOccupied() {

		return insuranceOccupied;
	}

	public void setInsuranceOccupied(double insuranceOccupied) {

		this.insuranceOccupied = insuranceOccupied;
	}

	public double getInsuranceVacant() {

		return insuranceVacant;
	}

	public void setInsuranceVacant(double insuranceVacant) {

		this.insuranceVacant = insuranceVacant;
	}

	public MultiYearValue getPropertyInsurance() {

		return propertyInsurance;
	}

	public void setPropertyInsurance(MultiYearValue propertyInsurance) {

		this.propertyInsurance = propertyInsurance;
	}

	public MultiYearValue getHoa() {

		return hoa;
	}

	public void setHoa(MultiYearValue hoa) {

		this.hoa = hoa;
	}

	public double getLeasingFeePercentNewTenant() {

		return leasingFeePercentNewTenant;
	}

	public void setLeasingFeePercentNewTenant(double leasingFeePercentNewTenant) {

		this.leasingFeePercentNewTenant = leasingFeePercentNewTenant;
	}

	public double getLeasingFeeTenantRenewal() {

		return leasingFeeTenantRenewal;
	}

	public void setLeasingFeeTenantRenewal(double leasingFeeTenantRenewal) {

		this.leasingFeeTenantRenewal = leasingFeeTenantRenewal;
	}

	public MultiYearValue getLeasingFee() {

		return leasingFee;
	}

	public void setLeasingFee(MultiYearValue leasingFee) {

		this.leasingFee = leasingFee;
	}

	public double getAssetFeePercent() {

		return assetFeePercent;
	}

	public void setAssetFeePercent(double assetFeePercent) {

		this.assetFeePercent = assetFeePercent;
	}

	public double getAssetFeeMin() {

		return assetFeeMin;
	}

	public void setAssetFeeMin(double assetFeeMin) {

		this.assetFeeMin = assetFeeMin;
	}

	public MultiYearValue getAssetManagementFee() {

		return assetManagementFee;
	}

	public void setAssetManagementFee(MultiYearValue assetManagementFee) {

		this.assetManagementFee = assetManagementFee;
	}

	public double getRepairAndMaintenanceFeePercent() {

		return repairAndMaintenanceFeePercent;
	}

	public void setRepairAndMaintenanceFeePercent(double repairAndMaintenanceFeePercent) {

		this.repairAndMaintenanceFeePercent = repairAndMaintenanceFeePercent;
	}

	public MultiYearValue getRepairAndMaintenanceFee() {

		return repairAndMaintenanceFee;
	}

	public void setRepairAndMaintenanceFee(MultiYearValue repairAndMaintenanceFee) {

		this.repairAndMaintenanceFee = repairAndMaintenanceFee;
	}

	public double getMonthlyUtilitiesCost() {

		return monthlyUtilitiesCost;
	}

	public void setMonthlyUtilitiesCost(double monthlyUtilitiesCost) {

		this.monthlyUtilitiesCost = monthlyUtilitiesCost;
	}

	public MultiYearValue getUtilitiesLandscape() {

		return utilitiesLandscape;
	}

	public void setUtilitiesLandscape(MultiYearValue utilitiesLandscape) {

		this.utilitiesLandscape = utilitiesLandscape;
	}

	public MultiYearValue getOperatingExpenses() {

		return operatingExpenses;
	}

	public void setOperatingExpenses(MultiYearValue operatingExpenses) {

		this.operatingExpenses = operatingExpenses;
	}

	public MultiYearValue getNetOperatingIncome() {

		return netOperatingIncome;
	}

	public void setNetOperatingIncome(MultiYearValue netOperatingIncome) {

		this.netOperatingIncome = netOperatingIncome;
	}

	public double getInterestRate() {

		return interestRate;
	}

	public void setInterestRate(double interestRate) {

		this.interestRate = interestRate;
	}

	public MultiMonthValue getLoanPayment() {

		return loanPayment;
	}

	public void setLoanPayment(MultiMonthValue loanPayment) {

		this.loanPayment = loanPayment;
	}

	public MultiMonthValue getLoanInterest() {

		return loanInterest;
	}

	public void setLoanInterest(MultiMonthValue loanInterest) {

		this.loanInterest = loanInterest;
	}

	public MultiMonthValue getLoanPrincipal() {

		return loanPrincipal;
	}

	public void setLoanPrincipal(MultiMonthValue loanPrincipal) {

		this.loanPrincipal = loanPrincipal;
	}

	public MultiMonthValue getLoanOutstanding() {

		return loanOutstanding;
	}

	public void setLoanOutstanding(MultiMonthValue loanOutstanding) {

		this.loanOutstanding = loanOutstanding;
	}

	public MultiMonthValue getLoanEquity() {

		return loanEquity;
	}

	public void setLoanEquity(MultiMonthValue loanEquity) {

		this.loanEquity = loanEquity;
	}

	public MultiMonthValue getLoanExtraPayment() {

		return loanExtraPayment;
	}

	public void setLoanExtraPayment(MultiMonthValue loanExtraPayment) {

		this.loanExtraPayment = loanExtraPayment;
	}

	public MultiYearValue getCashflow() {

		return cashflow;
	}

	public void setCashflow(MultiYearValue cashflow) {

		this.cashflow = cashflow;
	}

	public MultiYearValue getNetIncome() {

		return netIncome;
	}

	public void setNetIncome(MultiYearValue netIncome) {

		this.netIncome = netIncome;
	}

	public MultiYearValue getYield() {

		return yield;
	}

	public void setYield(MultiYearValue yield) {

		this.yield = yield;
	}

	public MultiYearValue getCashOnCashReturn() {

		return cashOnCashReturn;
	}

	public void setCashOnCashReturn(MultiYearValue cashOnCashReturn) {

		this.cashOnCashReturn = cashOnCashReturn;
	}

	public MultiYearValue getCapRate() {

		return capRate;
	}

	public void setCapRate(MultiYearValue capRate) {

		this.capRate = capRate;
	}

	public double getTargetDSCR() {

		return targetDSCR;
	}

	public void setTargetDSCR(double targetDSCR) {

		this.targetDSCR = targetDSCR;
	}

	public MultiYearValue getDebtServiceCoverageRatio() {

		return debtServiceCoverageRatio;
	}

	public void setDebtServiceCoverageRatio(MultiYearValue debtServiceCoverageRatio) {

		this.debtServiceCoverageRatio = debtServiceCoverageRatio;
	}

	public int getLoanPaidOffYear() {

		return loanPaidOffYear;
	}

	public void setLoanPaidOffYear(int loanPaidOffYear) {

		this.loanPaidOffYear = loanPaidOffYear;
	}

	public double getExtraPaymentLoanSaved() {

		return extraPaymentLoanSaved;
	}

	public void setExtraPaymentLoanSaved(double extraPaymentLoanSaved) {

		this.extraPaymentLoanSaved = extraPaymentLoanSaved;
	}

	public double getExtraPaymentMonthsSaved() {

		return extraPaymentMonthsSaved;
	}

	public void setExtraPaymentMonthsSaved(double extraPaymentMonthsSaved) {

		this.extraPaymentMonthsSaved = extraPaymentMonthsSaved;
	}

	public double getPrepayTaxAndInsurance() {

		return prepayTaxAndInsurance;
	}

	public void setPrepayTaxAndInsurance(double prepayTaxAndInsurance) {

		this.prepayTaxAndInsurance = prepayTaxAndInsurance;
	}

	public double getOtherCosts() {

		return otherCosts;
	}

	public void setOtherCosts(double otherCosts) {

		this.otherCosts = otherCosts;
	}

	public boolean[] getIsLeasingYear() {

		return isLeasingYear;
	}

	public void setIsLeasingYear(boolean[] isLeasingYear) {

		this.isLeasingYear = isLeasingYear;
	}

	public double getPriceRentRatio() {

		return priceRentRatio;
	}

	public void setPriceRentRatio(double priceRentRatio) {

		this.priceRentRatio = priceRentRatio;
	}

	public MultiYearValue getTotalExpenses() {

		return totalExpenses;
	}

	public void setTotalExpenses(MultiYearValue totalExpenses) {

		this.totalExpenses = totalExpenses;
	}

	public MultiYearValue getNetCashFlow() {

		return netCashFlow;
	}

	public void setNetCashFlow(MultiYearValue netCashFlow) {

		this.netCashFlow = netCashFlow;
	}

	public MultiYearValue getAccumulatedCashflow() {

		return accumulatedCashflow;
	}

	public void setAccumulatedCashflow(MultiYearValue accumulatedCashflow) {

		this.accumulatedCashflow = accumulatedCashflow;
	}

	public String getInvestmentGoal() {

		return investmentGoal;
	}

	public void setInvestmentGoal(String investmentGoal) {

		this.investmentGoal = investmentGoal;
	}

	public double getAppreciationRate() {

		return appreciationRate;
	}

	public void setAppreciationRate(double appreciationRate) {

		this.appreciationRate = appreciationRate;
	}

	public MultiYearValue getAppreciationValue() {

		return appreciationValue;
	}

	public void setAppreciationValue(MultiYearValue appreciationValue) {

		this.appreciationValue = appreciationValue;
	}

	public MultiYearValue getCumulativePrincipal() {

		return cumulativePrincipal;
	}

	public void setCumulativePrincipal(MultiYearValue cumulativePrincipal) {

		this.cumulativePrincipal = cumulativePrincipal;
	}

	public MultiYearValue getProjectedPrice() {

		return projectedPrice;
	}

	public void setProjectedPrice(MultiYearValue projectedPrice) {

		this.projectedPrice = projectedPrice;
	}

	public MultiYearValue getCagr() {

		return cagr;
	}

	public void setCagr(MultiYearValue cagr) {

		this.cagr = cagr;
	}

	public MultiYearValue getTotalEquity() {

		return totalEquity;
	}

	public void setTotalEquity(MultiYearValue totalEquity) {

		this.totalEquity = totalEquity;
	}

	public MultiYearValue getTotalWealth() {

		return totalWealth;
	}

	public void setTotalWealth(MultiYearValue totalWealth) {

		this.totalWealth = totalWealth;
	}

	public double getSellingCostPercent() {

		return sellingCostPercent;
	}

	public void setSellingCostPercent(double sellingCostPercent) {

		this.sellingCostPercent = sellingCostPercent;
	}

	public MultiYearValue getSellingCost() {

		return sellingCost;
	}

	public void setSellingCost(MultiYearValue sellingCost) {

		this.sellingCost = sellingCost;
	}

	public MultiYearValue getGrossSalesProceeds() {

		return grossSalesProceeds;
	}

	public void setGrossSalesProceeds(MultiYearValue grossSalesProceeds) {

		this.grossSalesProceeds = grossSalesProceeds;
	}

	public MultiYearValue getNetSalesProceeds() {

		return netSalesProceeds;
	}

	public void setNetSalesProceeds(MultiYearValue netSalesProceeds) {

		this.netSalesProceeds = netSalesProceeds;
	}

	public MultiYearValue getAnnualizedYield() {

		return annualizedYield;
	}

	public void setAnnualizedYield(MultiYearValue annualizedYield) {

		this.annualizedYield = annualizedYield;
	}

	public MultiYearValue getAnnualizedCashOnCash() {

		return annualizedCashOnCash;
	}

	public void setAnnualizedCashOnCash(MultiYearValue annualizedCashOnCash) {

		this.annualizedCashOnCash = annualizedCashOnCash;
	}

	public MultiYearValue getCashflowOverInvestmentPeriod() {

		return cashflowOverInvestmentPeriod;
	}

	public void setCashflowOverInvestmentPeriod(MultiYearValue cashflowOverInvestmentPeriod) {

		this.cashflowOverInvestmentPeriod = cashflowOverInvestmentPeriod;
	}

	public MultiYearValue getTotalReturn() {

		return totalReturn;
	}

	public void setTotalReturn(MultiYearValue totalReturn) {

		this.totalReturn = totalReturn;
	}

	public MultiYearValue getTotalAnnualizedReturn() {

		return totalAnnualizedReturn;
	}

	public void setTotalAnnualizedReturn(MultiYearValue totalAnnualizedReturn) {

		this.totalAnnualizedReturn = totalAnnualizedReturn;
	}

	public MultiYearValue getIrr() {

		return irr;
	}

	public void setIrr(MultiYearValue irr) {

		this.irr = irr;
	}

	public SdiraData getSdiraData() {

		return sdiraData;
	}

	public void setSdiraData(SdiraData sdiraData) {

		this.sdiraData = sdiraData;
	}

	public StabilizationPeriodData getStabilizationData() {

		return stabilizationData;
	}

	public void setStabilizationData(StabilizationPeriodData stabilizationData) {

		this.stabilizationData = stabilizationData;
	}

	public MonthlyIncomeStatement getMonthlyStatement() {

		return monthlyStatement;
	}

	public void setMonthlyStatement(MonthlyIncomeStatement monthlyStatement) {

		this.monthlyStatement = monthlyStatement;
	}

	public MarketNirAssumptions getMarketNirAssumptions() {

		return marketNirAssumptions;
	}

	public void setMarketNirAssumptions(MarketNirAssumptions marketNirAssumptions) {

		this.marketNirAssumptions = marketNirAssumptions;
	}
}
