
package com.homeunion.investor.property.dao.impl;

import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.homeunion.investor.common.constants.CommonConstants;
import com.homeunion.investor.common.domain.FinancingType;
import com.homeunion.investor.common.domain.InvestmentGoal;
import com.homeunion.investor.common.domain.SortDirection;
import com.homeunion.investor.common.solr.dao.SolrDAO;
import com.homeunion.investor.common.solr.dao.query.SolrQueryBuilder;
import com.homeunion.investor.property.dao.PropertySearchSolrDAO;
import com.homeunion.investor.property.dao.sql.QueryBuilder;
import com.homeunion.investor.property.dao.sql.QueryConstants;
import com.homeunion.investor.property.domain.PropertySummary;
import com.homeunion.investor.property.domain.search.PropertySearchResult;
import com.homeunion.investor.property.domain.search.PropertySearchSortOption;

@Component
public class PropertySearchSolrDAOImpl extends SolrDAO implements PropertySearchSolrDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(PropertySearchSolrDAOImpl.class);

	@Override
	public PropertySearchResult searchProperties(int investmentAmount,
	                                             List<Integer> assetClassIds,
	                                             int minPrice,
	                                             InvestmentGoal investmentGoal,
	                                             FinancingType financingType,
	                                             PropertySearchSortOption sortColumn,
	                                             SortDirection sortDirection,
	                                             int limitFrom,
	                                             int limitTo) {

		LOGGER.debug("Entered searchProperties()");
		PropertySearchResult propertySearchResult = new PropertySearchResult();
		SolrQuery query = constructSolrQuery(investmentAmount,
		                                     assetClassIds,
		                                     minPrice,
		                                     investmentGoal,
		                                     financingType,
		                                     sortColumn,
		                                     sortDirection,
		                                     limitFrom,
		                                     limitTo);
		try {
			final long start = System.currentTimeMillis();
			QueryResponse response = solrSearch(query);
			int rowCount = getResultCount(response);
			propertySearchResult.setProperties(getBeans(response, PropertySummary.class));
			propertySearchResult.setTotalPropertyCount(rowCount);
			final long end = System.currentTimeMillis();
			LOGGER.info("Property Search total results: {} Time: {}", rowCount, end - start);
		} catch (SolrServerException e) {
			LOGGER.error("Exception in Solr Search, query: {}", query, e);
			throw new RuntimeException(e);
		}
		return propertySearchResult;
	}

	private SolrQuery constructSolrQuery(int investmentAmount,
	                                     List<Integer> assetClassIds,
	                                     int minPrice,
	                                     InvestmentGoal investmentGoal,
	                                     FinancingType financingType,
	                                     PropertySearchSortOption sortColumn,
	                                     SortDirection sortDirection,
	                                     int limitFrom,
	                                     int limitTo) {

		String sortColumnName = getSortColumnName(sortColumn, financingType, investmentGoal);
		String investmentType = null;
		if (FinancingType.ALLCASH == financingType) {
			investmentType = QueryConstants.ALLCASH_INVESTMENT;
		} else {
			investmentType = QueryConstants.FINANCED_INVESTMENT;
		}
		SolrQuery solrQuery = new SolrQueryBuilder().queryRange(investmentType, CommonConstants.ANY, investmentAmount)
		                                            .filterRange(QueryConstants.ASKING_PRICE, minPrice, CommonConstants.ANY)
		                                            .filter(QueryConstants.ASSET_CLASS_ID, assetClassIds)
		                                            .sort(sortColumnName, sortDirection)
		                                            .limit(limitFrom, limitTo)
		                                            .build();
		return solrQuery;
	}

	private String getSortColumnName(PropertySearchSortOption sortColumn, FinancingType financingType, InvestmentGoal investmentGoal) {

		String sortColumnName = QueryBuilder.getSortColumnName(sortColumn, investmentGoal, financingType);
		if (sortColumnName.contains(".")) {
			sortColumnName = sortColumnName.substring(sortColumnName.indexOf(".") + 1);
		}
		return sortColumnName;
	}
}
