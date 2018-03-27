
package com.homeunion.investor.property.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.homeunion.investor.assetclass.domain.AssetClassDetails;
import com.homeunion.investor.assetclass.domain.MlsInfo;
import com.homeunion.investor.assetclass.service.AssetClassService;
import com.homeunion.investor.assetclass.service.MlsService;
import com.homeunion.investor.common.search.CriteriaBuilder;
import com.homeunion.investor.common.search.Filter;
import com.homeunion.investor.common.search.criterion.Operation;
import com.homeunion.investor.property.dao.PropertyDAO;
import com.homeunion.investor.property.domain.EmployersInfo;
import com.homeunion.investor.property.domain.PropertyListing;
import com.homeunion.investor.property.domain.PropertyListingInfo;
import com.homeunion.investor.property.domain.PropertySaleHistory;
import com.homeunion.investor.property.domain.PropertySummary;
import com.homeunion.investor.property.domain.comps.CompsPropertyInfo;
import com.homeunion.investor.property.domain.comps.PropertyComps;
import com.homeunion.investor.property.domain.media.PropertyMedia;
import com.homeunion.investor.property.service.PropertyService;
import com.homeunion.investor.property.util.PropertyUtil;

@Component
public class PropertyServiceImpl implements PropertyService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PropertyServiceImpl.class);
	@Autowired
	private AssetClassService assetClassService;
	@Autowired
	private MlsService mlsService;
	@Autowired
	private PropertyDAO propertyDAO;

	@Override
	public PropertySummary getPropertySummary(String propertyId) {

		LOGGER.info("Entered getPropertySummary('{}')", propertyId);
		//get the asset classes from cache
		List<AssetClassDetails> assetClassList = assetClassService.getAssetClassList();
		//get the property summary
		PropertySummary propertySummary = propertyDAO.getPropertySummary(propertyId);
		//populate asset class details from cached list
		propertySummary = PropertyUtil.injectAssetClassAttributes(propertySummary, assetClassList);
		//fetch list of mls info from cache
		List<MlsInfo> mlsInfoList = mlsService.getMlsInfoList();
		//inject mlsinfo
		propertySummary = PropertyUtil.injectMlsInfo(propertySummary, mlsInfoList);
		//return!
		return propertySummary;
	}

	@Override
	public PropertyListing getPropertyListing(String propertyId) {

		LOGGER.info("Entered getPropertyListing('{}')", propertyId);
		//fetch listing info first
		PropertyListingInfo listingInfo = propertyDAO.getPropertyListing(propertyId);
		//fetch list of mls info from cache
		List<MlsInfo> mlsInfoList = mlsService.getMlsInfoList();
		MlsInfo mlsInfo = null;
		if ( !StringUtils.isEmpty(listingInfo.getMlsName())) {
			LOGGER.info("Property {} has Mls Name {}", propertyId, listingInfo.getMlsName());
			mlsInfo = new CriteriaBuilder().where("mlsName", Operation.EQUALS, listingInfo.getMlsName()).build().applyAndExtractOne(mlsInfoList);
		} else if ( !StringUtils.isEmpty(listingInfo.getAssignedQBR())) {
			LOGGER.info("Property {} has Assigned QBR {}", propertyId, listingInfo.getAssignedQBR());
			mlsInfo = new CriteriaBuilder().where("ilmName", Operation.EQUALS, listingInfo.getAssignedQBR()).build().applyAndExtractOne(mlsInfoList);
		}
		if (mlsInfo == null) {
			LOGGER.warn("Could not find Mls Info for property {}", propertyId);
		}
		//set and return!
		PropertyListing propertyListing = new PropertyListing();
		propertyListing.setListingInfo(listingInfo);
		propertyListing.setMlsInfo(mlsInfo);
		return propertyListing;
	}

	@Override
	public PropertyMedia getPropertyMedia(String propertyId) {

		LOGGER.info("Entered getPropertyMedia('{}')", propertyId);
		return propertyDAO.getPropertyMedia(propertyId);
	}

	@Override
	public PropertyComps getPropertyComps(String mlsName, String mlsNumber) {

		LOGGER.info("Entered getPropertyComps('{}', '{}')", mlsName, mlsNumber);
		//fetch the property comps
		PropertyComps propertyComps = propertyDAO.getPropertyComps(mlsName, mlsNumber);
		if (propertyComps != null) {
			LOGGER.info("Property Comps for mls name, number {}, {} has comps properties", mlsName, mlsNumber);
			//calculate and inject aggregate values
			Filter searchFilter = new CriteriaBuilder().build();
			List<CompsPropertyInfo> properties = new ArrayList<>();
			//price comps aggregates
			properties.add(propertyComps.getActiveProperty());
			properties.addAll(propertyComps.getPriceComps());
			propertyComps.getCompsAggregatedInfo().setMinPrice(searchFilter.min(properties, "price", Double.class));
			propertyComps.getCompsAggregatedInfo().setMaxPrice(searchFilter.max(properties, "price", Double.class));
			//rent comps aggregates
			properties.clear();
			properties.add(propertyComps.getActiveProperty());
			properties.addAll(propertyComps.getRentComps());
			propertyComps.getCompsAggregatedInfo().setMinRent(searchFilter.min(properties, "rent", Double.class));
			propertyComps.getCompsAggregatedInfo().setMaxRent(searchFilter.max(properties, "rent", Double.class));
		} else {
			LOGGER.info("Property Comps for mls name, number {}, {} does not have properties", mlsName, mlsNumber);
		}
		return propertyComps;
	}

	@Override
	public PropertySaleHistory getPropertySaleHistory(String propertyId) {

		LOGGER.info("Entered getPropertySaleHistory('{}')", propertyId);
		//fetch sale History info first
		return propertyDAO.getPropertySaleHistory(propertyId);
	}

	@Override
	public List<PropertySummary> getAssetClassProperties(String assetClassNameUri) {

		LOGGER.debug("Entered getAssetClassProperties('{}')", assetClassNameUri);
		//fetch the asset class first
		AssetClassDetails assetClass = assetClassService.getAssetClassDetails(assetClassNameUri);
		//fetch asset class properties first
		List<PropertySummary> properties = propertyDAO.getAssetClassProperties(assetClass.getAssetClassId());
		//inject asset class attributes
		PropertyUtil.injectAssetClassAttributes(properties, Arrays.asList(new AssetClassDetails[] { assetClass }));
		//fetch list of mls info from cache
		List<MlsInfo> mlsInfoList = mlsService.getMlsInfoList();
		//inject mlsinfo
		properties = PropertyUtil.injectMlsInfo(properties, mlsInfoList);
		LOGGER.info("Count of properties for asset class '{}' is {}", assetClassNameUri, properties.size());
		return properties;
	}

	@Override
	public List<EmployersInfo> getEmployersInfo(String latitude, String longitude, String radius) {

		LOGGER.debug("Entered getEmployersInfo('{}', '{}', '{}'", latitude, longitude, radius);
		List<EmployersInfo> employersInfo = propertyDAO.getEmployersInfo(latitude, longitude, radius);
		LOGGER.info("Employers info list for latitude {} and longitude {}. Size : {}", latitude, longitude, employersInfo.size());
		return employersInfo;
	}
}
