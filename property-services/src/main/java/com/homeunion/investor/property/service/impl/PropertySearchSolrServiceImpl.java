
package com.homeunion.investor.property.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.homeunion.investor.property.dao.PropertySearchSolrDAO;
import com.homeunion.investor.property.domain.search.PropertySearchCriteria;
import com.homeunion.investor.property.domain.search.PropertySearchResult;

@Component(value = "solrpropertysearch")
public class PropertySearchSolrServiceImpl extends BasePropertySearchServiceImpl {

	private static final Logger LOGGER = LoggerFactory.getLogger(PropertySearchSolrServiceImpl.class);
	@Autowired
	private PropertySearchSolrDAO propertySearchWithSolrDAO;

	@Override
	public PropertySearchResult getSearchResult(PropertySearchCriteria searchCriteria, List<Integer> assetClassIds, int minPrice, int limitFrom, int limitTo) {

		LOGGER.info("Entered getSearchResult() of PropertySearchServiceSolrImpl");
		return propertySearchWithSolrDAO.searchProperties(searchCriteria.getInvestmentAmount(),
		                                                  assetClassIds,
		                                                  minPrice,
		                                                  searchCriteria.getInvestmentGoal(),
		                                                  searchCriteria.getFinancingType(),
		                                                  searchCriteria.getSortOption(),
		                                                  searchCriteria.getSortDirection(),
		                                                  limitFrom,
		                                                  limitTo);
	}
}
