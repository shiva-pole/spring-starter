
package com.homeunion.investor.property.domain.search;

import java.util.List;

import com.homeunion.investor.common.domain.FinancingType;
import com.homeunion.investor.common.domain.InvestmentGoal;
import com.homeunion.investor.common.domain.SortDirection;

public class PropertySearchCriteria {

	private int investmentAmount;
	private String state;
	private String city;
	private List<String> hilGroups;
	private FinancingType financingType;
	private InvestmentGoal investmentGoal;
	private PropertySearchSortOption sortOption;
	private SortDirection sortDirection;
	private int pageSize;
	private int pageNum;
	private int minTotalReturn;
	private int maxTotalReturn;
	private List<String> nir;

	public List<String> getNir() {

		return nir;
	}

	public void setNir(List<String> nir) {

		this.nir = nir;
	}

	public int getMinTotalReturn() {

		return minTotalReturn;
	}

	public void setMinTotalReturn(int minTotalReturn) {

		this.minTotalReturn = minTotalReturn;
	}

	public int getMaxTotalReturn() {

		return maxTotalReturn;
	}

	public void setMaxTotalReturn(int maxTotalReturn) {

		this.maxTotalReturn = maxTotalReturn;
	}

	public int getInvestmentAmount() {

		return investmentAmount;
	}

	public void setInvestmentAmount(int investmentAmount) {

		this.investmentAmount = investmentAmount;
	}

	public String getState() {

		return state;
	}

	public void setState(String state) {

		this.state = state;
	}

	public String getCity() {

		return city;
	}

	public void setCity(String city) {

		this.city = city;
	}

	public List<String> getHilGroups() {

		return hilGroups;
	}

	public void setHilGroups(List<String> hilGroups) {

		this.hilGroups = hilGroups;
	}

	public FinancingType getFinancingType() {

		return financingType;
	}

	public void setFinancingType(FinancingType financingType) {

		this.financingType = financingType;
	}

	public InvestmentGoal getInvestmentGoal() {

		return investmentGoal;
	}

	public void setInvestmentGoal(InvestmentGoal investmentGoal) {

		this.investmentGoal = investmentGoal;
	}

	public PropertySearchSortOption getSortOption() {

		return sortOption;
	}

	public void setSortOption(PropertySearchSortOption sortOption) {

		this.sortOption = sortOption;
	}

	public SortDirection getSortDirection() {

		return sortDirection;
	}

	public void setSortDirection(SortDirection sortDirection) {

		this.sortDirection = sortDirection;
	}

	public int getPageSize() {

		return pageSize;
	}

	public void setPageSize(int pageSize) {

		this.pageSize = pageSize;
	}

	public int getPageNum() {

		return pageNum;
	}

	public void setPageNum(int pageNum) {

		this.pageNum = pageNum;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append("PropertySearchCriteria [investmentAmount=");
		builder.append(investmentAmount);
		builder.append(", state=");
		builder.append(state);
		builder.append(", hilGroups=");
		builder.append(hilGroups);
		builder.append(", financingType=");
		builder.append(financingType);
		builder.append(", investmentGoal=");
		builder.append(investmentGoal);
		builder.append(", nir=");
		builder.append(nir);
		builder.append(", sortOption=");
		builder.append(sortOption);
		builder.append(", sortDirection=");
		builder.append(sortDirection);
		builder.append(", pageSize=");
		builder.append(pageSize);
		builder.append(", pageNum=");
		builder.append(pageNum);
		builder.append("]");
		return builder.toString();
	}
}
