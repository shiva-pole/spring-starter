
package com.homeunion.investor.property.dao;

import java.util.List;

import com.homeunion.investor.common.domain.FinancingType;
import com.homeunion.investor.common.domain.InvestmentGoal;
import com.homeunion.investor.common.domain.SortDirection;
import com.homeunion.investor.property.domain.search.PropertySearchResult;
import com.homeunion.investor.property.domain.search.PropertySearchSortOption;

public interface PropertySearchSolrDAO {

	public PropertySearchResult searchProperties(int investmentAmount,
	                                             List<Integer> assetClassIds,
	                                             int minPrice,
	                                             InvestmentGoal investmentGoal,
	                                             FinancingType financingType,
	                                             PropertySearchSortOption sortColumn,
	                                             SortDirection sortDirection,
	                                             int limitFrom,
	                                             int limitTo);
}
