
package com.homeunion.investor.property.dao.sql;

import com.homeunion.investor.common.domain.FinancingType;
import com.homeunion.investor.common.domain.InvestmentGoal;
import com.homeunion.investor.common.domain.SortDirection;
import com.homeunion.investor.property.domain.search.PropertySearchSortOption;

public class QueryBuilder {

	public static String propertySearchQuery(InvestmentGoal investmentGoal,
	                                         FinancingType financingType,
	                                         PropertySearchSortOption sortColumn,
	                                         SortDirection sortDirection) {

		if (financingType == null || sortColumn == null || sortDirection == null) {
			throw new IllegalArgumentException("FinancingType/PropertySearchSortColumn/SortDirection cannot be null");
		}
		String query = QueryConstants.QUERY_PROPERTY_SEARCH;
		String sortColumnName = getSortColumnName(sortColumn, investmentGoal, financingType);
		//replace the filter range column for total_return
		String replaceString = (investmentGoal != null) ? "_" + investmentGoal.toString().toLowerCase() : "";
		query = query.replaceAll(QueryConstants.INV_GOAL_TOKEN, replaceString);
		//replace sort column name for appropriate sorting
		query = query.replaceAll(QueryConstants.SORT_COL_TOKEN, sortColumnName.toString());
		//replace sort direction token for appropriate sort direction
		query = query.replaceAll(QueryConstants.SORT_DIR_TOKEN, sortDirection.toString().toLowerCase());
		//correct column name for appropriate financing type
		query = query.replaceAll(QueryConstants.FIN_TYPE_TOKEN, financingType.toString().toLowerCase());
		return query;
	}

	public static String getSortColumnName(PropertySearchSortOption sortColumn, InvestmentGoal investmentGoal, FinancingType financingType) {

		String sortColumnName = null;
		switch (sortColumn) {
			case APPRECIATION:
				sortColumnName = QueryConstants.SORT_APPRECIATION;
				break;
			case ASKING_PRICE:
				sortColumnName = QueryConstants.SORT_ASKING_PRICE;
				break;
			case COC_RETURN:
				sortColumnName = (FinancingType.ALLCASH == financingType) ? QueryConstants.SORT_ALLCASH_COC_RETURN : QueryConstants.SORT_FINANCED_COC_RETURN;
				break;
			case INVESTMENT:
				sortColumnName = QueryConstants.SORT_INVESTMENT;
				break;
			case RETURN:
				sortColumnName = (FinancingType.ALLCASH == financingType) ? QueryConstants.SORT_ALLCASH_RETURN : QueryConstants.SORT_FINANCED_RETURN;
				break;
			case TOTAL_RETURN:
				sortColumnName = QueryConstants.SORT_TOTAL_RETURN;
				break;
			case HU_SELECT:
				sortColumnName = QueryConstants.SORT_HU_SELECT;
				break;
			case YEAR_BUILT:
				sortColumnName = QueryConstants.SORT_YEAR_BUILT;
				break;
			default:
				break;
		}
		sortColumnName = sortColumnName.replaceAll(QueryConstants.FIN_TYPE_TOKEN, financingType.toString().toLowerCase());
		return sortColumnName;
	}

	public static String propertySearchCountQuery(FinancingType financingType) {

		if (financingType == null) {
			throw new IllegalArgumentException("FinancingType cannot be null");
		}
		String query = QueryConstants.QUERY_PROPERTY_SEARCH_COUNT;
		query = query.replaceAll(QueryConstants.INV_GOAL_TOKEN, "");
		//correct column name for appropriate financing type
		query = query.replaceAll(QueryConstants.FIN_TYPE_TOKEN, financingType.toString().toLowerCase());
		return query;
	}
}
