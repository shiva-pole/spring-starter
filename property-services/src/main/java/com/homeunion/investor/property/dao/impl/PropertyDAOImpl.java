
package com.homeunion.investor.property.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.stereotype.Component;

import com.homeunion.investor.common.dao.BaseDAO;
import com.homeunion.investor.property.dao.PropertyDAO;
import com.homeunion.investor.property.dao.mapper.EmployersInfoMapper;
import com.homeunion.investor.property.dao.mapper.PropertyCompsExtractor;
import com.homeunion.investor.property.dao.mapper.PropertyListingInfoMapper;
import com.homeunion.investor.property.dao.mapper.PropertyMediaExtractor;
import com.homeunion.investor.property.dao.mapper.PropertySaleHistoryMapper;
import com.homeunion.investor.property.dao.mapper.PropertySummaryMapper;
import com.homeunion.investor.property.dao.sql.QueryConstants;
import com.homeunion.investor.property.domain.EmployersInfo;
import com.homeunion.investor.property.domain.PropertyListingInfo;
import com.homeunion.investor.property.domain.PropertySaleHistory;
import com.homeunion.investor.property.domain.PropertySummary;
import com.homeunion.investor.property.domain.comps.PropertyComps;
import com.homeunion.investor.property.domain.media.PropertyMedia;
import com.homeunion.investor.property.exception.PropertyNotFoundException;

@Component
public class PropertyDAOImpl extends BaseDAO implements PropertyDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(PropertyDAOImpl.class);
	@Autowired
	private PropertySummaryMapper propertySummaryMapper;
	@Autowired
	private PropertyListingInfoMapper propertyListingInfoMapper;
	@Autowired
	private PropertyMediaExtractor propertyMediaExtractor;
	@Autowired
	private PropertyCompsExtractor propertyCompsExtractor;
	@Autowired
	private PropertySaleHistoryMapper propertySaleHistoryMapper;
	@Autowired
	private EmployersInfoMapper employersInfoMapper;

	@Override
	public PropertySummary getPropertySummary(String propertyId) {

		LOGGER.debug("Entered getPropertySummary('{}')", propertyId);
		PropertySummary propertySummary = null;
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("propertyId", propertyId);
		try {
			final long start = System.currentTimeMillis();
			propertySummary = jdbcRO().queryForObject(QueryConstants.QUERY_GET_PROPERTY_SUMMARY, parameters, propertySummaryMapper);
			final long end = System.currentTimeMillis();
			LOGGER.info("Property Summary fetched for id {}, Time: {}ms", propertyId, end - start);
		} catch (IncorrectResultSizeDataAccessException e) {
			LOGGER.debug("Could not find Property for id '{}'", propertyId, e);
			throw new PropertyNotFoundException(propertyId);
		} catch (Exception e) {
			LOGGER.error("Exception occurred while fetching property summary using query {} with params {}.",
			             QueryConstants.QUERY_GET_PROPERTY_SUMMARY,
			             parameters,
			             e);
			throw e;
		}
		return propertySummary;
	}

	@Override
	public PropertyListingInfo getPropertyListing(String propertyId) {

		LOGGER.debug("Entered getPropertyListing('{}')", propertyId);
		PropertyListingInfo propertyListing = null;
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("propertyId", propertyId);
		try {
			final long start = System.currentTimeMillis();
			propertyListing = jdbcRO().queryForObject(QueryConstants.QUERY_GET_PROPERTY_LISTING, parameters, propertyListingInfoMapper);
			final long end = System.currentTimeMillis();
			LOGGER.info("Property Listing fetched for id {}, Time: {}ms", propertyId, end - start);
		} catch (IncorrectResultSizeDataAccessException e) {
			LOGGER.debug("Could not find Property for id '{}'", propertyId, e);
			throw new PropertyNotFoundException(propertyId);
		} catch (Exception e) {
			LOGGER.error("Exception occurred while fetching property listing using query {} with params {}. Exception: {}",
			             QueryConstants.QUERY_GET_PROPERTY_LISTING,
			             parameters,
			             e);
			throw e;
		}
		return propertyListing;
	}

	@Override
	public PropertyMedia getPropertyMedia(String propertyId) {

		LOGGER.debug("Entered getPropertyMedia('{}')", propertyId);
		PropertyMedia propertyMedia = null;
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("propertyId", propertyId);
		try {
			final long start = System.currentTimeMillis();
			propertyMedia = jdbcRO().query(QueryConstants.QUERY_GET_PROPERTY_MEDIA, parameters, propertyMediaExtractor);
			final long end = System.currentTimeMillis();
			LOGGER.info("Property Media fetched for id {}, Time: {}ms", propertyId, end - start);
		} catch (Exception e) {
			LOGGER.error("Exception occurred while fetching property media using query {} with params {}. Exception: {}",
			             QueryConstants.QUERY_GET_PROPERTY_MEDIA,
			             parameters,
			             e);
			throw e;
		}
		return propertyMedia;
	}

	@Override
	public PropertyComps getPropertyComps(String mlsName, String mlsNumber) {

		LOGGER.debug("Entered getPropertyComps('{}', '{}')", mlsName, mlsNumber);
		PropertyComps propertyComps = null;
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("mlsName", mlsName);
		parameters.put("mlsNumber", mlsNumber);
		try {
			final long start = System.currentTimeMillis();
			propertyComps = jdbcRO().query(QueryConstants.QUERY_GET_PROPERTY_COMPS, parameters, propertyCompsExtractor);
			final long end = System.currentTimeMillis();
			LOGGER.info("Property Comps fetched for mls name, number {}, {}, Time: {}ms", mlsName, mlsNumber, end - start);
		} catch (Exception e) {
			LOGGER.error("Exception occurred while fetching property comps using query {} with params {}. Exception: {}",
			             QueryConstants.QUERY_GET_PROPERTY_COMPS,
			             parameters,
			             e);
			throw e;
		}
		return propertyComps;
	}

	@Override
	public PropertySaleHistory getPropertySaleHistory(String propertyId) {

		LOGGER.debug("Entered getPropertySaleHistory('{}')", propertyId);
		PropertySaleHistory propertySaleHistory = null;
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("propertyId", propertyId);
		try {
			final long start = System.currentTimeMillis();
			propertySaleHistory = jdbcRO().queryForObject(QueryConstants.QUERY_GET_PROPERTY_SALE_HISTORY, parameters, propertySaleHistoryMapper);
			final long end = System.currentTimeMillis();
			LOGGER.info("Property Sale History fetched for propertyId {}, Time: {}ms", propertyId, end - start);
		} catch (IncorrectResultSizeDataAccessException e) {
			LOGGER.debug("Could not find sales history for Property for id '{}'", propertyId, e);
			return new PropertySaleHistory();
		} catch (Exception e) {
			LOGGER.error("Exception occurred while fetching property sale history using query {} with params {}. Exception: {}",
			             QueryConstants.QUERY_GET_PROPERTY_SALE_HISTORY,
			             parameters,
			             e);
			throw e;
		}
		return propertySaleHistory;
	}

	@Override
	public List<PropertySummary> getAssetClassProperties(Integer assetClassId) {

		LOGGER.debug("Entered getAssetClassProperties('{}')", assetClassId);
		List<PropertySummary> properties = null;
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("assetClassId", assetClassId);
		try {
			final long start = System.currentTimeMillis();
			properties = jdbcRO().query(QueryConstants.QUERY_GET_ASSET_CLASS_PROPERTIES, parameters, propertySummaryMapper);
			final long end = System.currentTimeMillis();
			LOGGER.info("Asset class properties fetched for id {}, Time: {}ms", assetClassId, end - start);
		} catch (Exception e) {
			LOGGER.error("Exception occurred while fetching Asset class properties using query {} with params {}.",
			             QueryConstants.QUERY_GET_ASSET_CLASS_PROPERTIES,
			             parameters,
			             e);
			throw e;
		}
		return properties;
	}

	@Override
	public List<EmployersInfo> getEmployersInfo(String latitude, String longitude, String radius) {

		LOGGER.info("Entered getEmployersInfo('{}', '{}', '{}')", latitude, longitude, radius);
		List<EmployersInfo> employersInfo = null;
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("latitude", latitude);
		parameters.put("longitude", longitude);
		parameters.put("radius", radius);
		try {
			final long start = System.currentTimeMillis();
			employersInfo = jdbcRO().query(QueryConstants.QUERY_GET_EMPLOYERS_INFO, parameters, employersInfoMapper);
			final long end = System.currentTimeMillis();
			LOGGER.info("Employers info fetched for latitude-'{}', longitude-'{}', radius-'{}' Time: {}ms", latitude, longitude, radius, end - start);
		} catch (Exception e) {
			LOGGER.error("Exception occured while fetching Employers Info unsing query {} with params {}.",
			             QueryConstants.QUERY_GET_EMPLOYERS_INFO,
			             parameters,
			             e);
			throw e;
		}
		return employersInfo;
	}
}
