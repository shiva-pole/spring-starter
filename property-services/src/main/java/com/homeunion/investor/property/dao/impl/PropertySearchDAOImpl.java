
package com.homeunion.investor.property.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.homeunion.investor.common.dao.BaseDAO;
import com.homeunion.investor.common.domain.FinancingType;
import com.homeunion.investor.common.domain.InvestmentGoal;
import com.homeunion.investor.common.domain.SortDirection;
import com.homeunion.investor.property.dao.PropertySearchDAO;
import com.homeunion.investor.property.dao.mapper.PropertySummaryMapper;
import com.homeunion.investor.property.dao.sql.QueryBuilder;
import com.homeunion.investor.property.domain.PropertySummary;
import com.homeunion.investor.property.domain.search.PropertySearchSortOption;

@Component
public class PropertySearchDAOImpl extends BaseDAO implements PropertySearchDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(PropertySearchDAOImpl.class);
	@Autowired
	private PropertySummaryMapper propertySummaryMapper;

	@Override
	public List<PropertySummary> searchProperties(int investmentAmount,
	                                              List<Integer> assetClassIds,
	                                              List<String> nir,
	                                              int minPrice,
	                                              InvestmentGoal investmentGoal,
	                                              FinancingType financingType,
	                                              PropertySearchSortOption sortColumn,
	                                              SortDirection sortDirection,
	                                              int minTotalReturn,
	                                              int maxTotalReturn,
	                                              int limitFrom,
	                                              int limitTo) {

		LOGGER.debug("Entered searchProperties()");
		List<PropertySummary> propertyList = null;
		String query = QueryBuilder.propertySearchQuery(investmentGoal, financingType, sortColumn, sortDirection);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("investmentAmount", investmentAmount);
		parameters.put("assetClassIds", assetClassIds);
		parameters.put("nir", nir);
		parameters.put("minPrice", minPrice);
		parameters.put("limitFrom", limitFrom);
		parameters.put("limitTo", limitTo);
		parameters.put("minTotalReturn", minTotalReturn);
		parameters.put("maxTotalReturn", maxTotalReturn);
		try {
			final long start = System.currentTimeMillis();
			propertyList = jdbcRO().query(query, parameters, propertySummaryMapper);
			final long end = System.currentTimeMillis();
			LOGGER.info("Property Search Results Size: {}, Time: {}ms", propertyList.size(), end - start);
		} catch (Exception e) {
			LOGGER.error("Exception occurred while searching properties using query {} with params {}.", query, parameters, e);
			throw e;
		}
		return propertyList;
	}

	@Override
	public int getPropertyCount(int investmentAmount,
	                            List<Integer> assetClassIds,
	                            List<String> nir,
	                            int minPrice,
	                            FinancingType financingType,
	                            int minTotalReturn,
	                            int maxTotalReturn) {

		LOGGER.debug("Entered getPropertyCount()");
		int propertyCount = 0;
		String query = QueryBuilder.propertySearchCountQuery(financingType);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("investmentAmount", investmentAmount);
		parameters.put("assetClassIds", assetClassIds);
		parameters.put("nir", nir);
		parameters.put("minPrice", minPrice);
		parameters.put("minTotalReturn", minTotalReturn);
		parameters.put("maxTotalReturn", maxTotalReturn);
		try {
			final long start = System.currentTimeMillis();
			propertyCount = jdbcRO().queryForObject(query, parameters, Integer.class);
			final long end = System.currentTimeMillis();
			LOGGER.info("Property Search Count: {}, Time: {}ms", propertyCount, end - start);
		} catch (Exception e) {
			LOGGER.error("Exception occurred while getting property count using query {} with params {}.", query, parameters, e);
			throw e;
		}
		return propertyCount;
	}
}
