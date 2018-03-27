
package com.homeunion.investor.property.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.homeunion.investor.property.dao.PropertySearchDAO;
import com.homeunion.investor.property.domain.PropertySummary;
import com.homeunion.investor.property.domain.search.PropertySearchCriteria;
import com.homeunion.investor.property.domain.search.PropertySearchResult;

@Primary
@Component(value = "jdbcpropertysearch")
public class PropertySearchServiceImpl extends BasePropertySearchServiceImpl {

	private static final Logger LOGGER = LoggerFactory.getLogger(PropertySearchServiceImpl.class);
	@Autowired
	private PropertySearchDAO propertySearchDAO;

	@Override
	public PropertySearchResult getSearchResult(PropertySearchCriteria searchCriteria, List<Integer> assetClassIds, int minPrice, int limitFrom, int limitTo) {

		LOGGER.info("Entered getSearchResult() of PropertySearchServiceImpl");
		PropertySearchResult propertySearchResult = new PropertySearchResult();
		// get property count
		int propertyCount = propertySearchDAO.getPropertyCount(searchCriteria.getInvestmentAmount(),
		                                                       assetClassIds,
		                                                       searchCriteria.getNir(),
		                                                       minPrice,
		                                                       searchCriteria.getFinancingType(),
		                                                       searchCriteria.getMinTotalReturn(),
		                                                       searchCriteria.getMaxTotalReturn());
		// search properties
		List<PropertySummary> properties = propertySearchDAO.searchProperties(searchCriteria.getInvestmentAmount(),
		                                                                      assetClassIds,
		                                                                      searchCriteria.getNir(),
		                                                                      minPrice,
		                                                                      searchCriteria.getInvestmentGoal(),
		                                                                      searchCriteria.getFinancingType(),
		                                                                      searchCriteria.getSortOption(),
		                                                                      searchCriteria.getSortDirection(),
		                                                                      searchCriteria.getMinTotalReturn(),
		                                                                      searchCriteria.getMaxTotalReturn(),
		                                                                      limitFrom,
		                                                                      limitTo);
		propertySearchResult.setTotalPropertyCount(propertyCount);
		propertySearchResult.setProperties(properties);
		return propertySearchResult;
	}
}
