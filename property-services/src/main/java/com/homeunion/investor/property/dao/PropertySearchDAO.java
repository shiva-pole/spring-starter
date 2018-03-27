
package com.homeunion.investor.property.dao;

import java.util.List;

import com.homeunion.investor.common.domain.FinancingType;
import com.homeunion.investor.common.domain.InvestmentGoal;
import com.homeunion.investor.common.domain.SortDirection;
import com.homeunion.investor.property.domain.PropertySummary;
import com.homeunion.investor.property.domain.search.PropertySearchSortOption;

public interface PropertySearchDAO {

	List<PropertySummary> searchProperties(int investmentAmount,
	                                       List<Integer> assetClassIds,
	                                       List<String> nir,
	                                       int minPrice,
	                                       InvestmentGoal investmentGoal,
	                                       FinancingType financingType,
	                                       PropertySearchSortOption sortColumn,
	                                       SortDirection sortDirection,
	                                       int limitFrom,
	                                       int limitTo,
	                                       int minTotalReturn,
	                                       int maxTotalReturn);

	int getPropertyCount(int investmentAmount,
	                     List<Integer> assetClassIds,
	                     List<String> nir,
	                     int minPrice,
	                     FinancingType financingType,
	                     int minTotalReturn,
	                     int maxTotalReturn);
}
