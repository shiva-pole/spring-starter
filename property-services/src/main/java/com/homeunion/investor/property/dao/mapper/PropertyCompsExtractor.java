
package com.homeunion.investor.property.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.homeunion.investor.property.constants.PropertyConstants;
import com.homeunion.investor.property.domain.comps.CompsAggregatedInfo;
import com.homeunion.investor.property.domain.comps.CompsPropertyInfo;
import com.homeunion.investor.property.domain.comps.PropertyComps;

@Component
public class PropertyCompsExtractor implements ResultSetExtractor<PropertyComps> {

	private static final Logger LOGGER = LoggerFactory.getLogger(PropertyCompsExtractor.class);

	@Override
	public PropertyComps extractData(ResultSet rs) throws SQLException, DataAccessException {

		LOGGER.debug("Mapping result set to PropertyComps object");
		//initiliaze the objects
		PropertyComps propertyComps = null;
		CompsAggregatedInfo compsAggregatedInfo = null;
		CompsPropertyInfo activeProperty = null;
		List<CompsPropertyInfo> priceComps = new ArrayList<>();
		List<CompsPropertyInfo> rentComps = new ArrayList<>();
		while (rs.next()) {
			//first map the aggregated data
			if (propertyComps == null) {
				propertyComps = new PropertyComps();
				compsAggregatedInfo = mapAggregatedInfo(rs);
			}
			//map the property data
			CompsPropertyInfo propertyInfo = mapPropertyInfo(rs);
			String listingStatus = propertyInfo.getListingStatus();
			String mlsNumber = propertyInfo.getMlsNumber();
			if (PropertyConstants.COMPS_SOLD_STATUS.equalsIgnoreCase(listingStatus) && compsAggregatedInfo.getPriceCompsList().contains(mlsNumber)) {
				//if this is a approved price comps
				priceComps.add(propertyInfo);
			} else if (PropertyConstants.COMPS_LEASED_STATUS.equalsIgnoreCase(listingStatus) && compsAggregatedInfo.getRentCompsList().contains(mlsNumber)) {
				//if this is a approved rent comps
				rentComps.add(propertyInfo);
			} else if (PropertyConstants.COMPS_ACTIVE_STATUS.equalsIgnoreCase(listingStatus)) {
				activeProperty = propertyInfo;
			}
		}
		//set
		if (propertyComps != null) {
			propertyComps.setCompsAggregatedInfo(compsAggregatedInfo);
			propertyComps.setActiveProperty(activeProperty);
			propertyComps.setPriceComps(priceComps);
			propertyComps.setRentComps(rentComps);
		}
		return propertyComps;
	}

	private CompsAggregatedInfo mapAggregatedInfo(ResultSet rs) throws SQLException {

		LOGGER.debug("Mapping result set row to CompsAggregatedInfo object");
		CompsAggregatedInfo compsAggregatedInfo = new CompsAggregatedInfo();
		//active property
		compsAggregatedInfo.setMlsName(rs.getString("mlsname"));
		compsAggregatedInfo.setMlsNumber(rs.getString("active_prop_mlsnumber"));
		//sold comps
		List<String> priceCompsList = Collections.emptyList();
		boolean soldCompsApproved = rs.getBoolean("approved_sold_comps");
		if (soldCompsApproved) {
			//stored as comma separated
			String priceComps = rs.getString("sold_list");
			if ( !StringUtils.isEmpty(priceComps)) {
				priceCompsList = Arrays.asList(priceComps.split(","));
			}
			compsAggregatedInfo.setSoldCompsPath(rs.getString("sold_comp_path"));
			compsAggregatedInfo.setCompsPrice(rs.getDouble("comps_price"));
			compsAggregatedInfo.setAvgCompPricePerSqft(rs.getDouble("avgCompPricePerSqft"));
		}
		compsAggregatedInfo.setPriceCompsList(priceCompsList);
		//rent comps
		List<String> rentCompsList = Collections.emptyList();
		boolean rentCompsApproved = rs.getBoolean("approved_leased_comps");
		if (rentCompsApproved) {
			//stored as comma separated
			String rentComps = rs.getString("leased_list");
			if ( !StringUtils.isEmpty(rentComps)) {
				rentCompsList = Arrays.asList(rentComps.split(","));
			}
			compsAggregatedInfo.setRentCompsPath(rs.getString("leased_comp_path"));
			compsAggregatedInfo.setCompsRent(rs.getDouble("comps_rent"));
			compsAggregatedInfo.setAvgComprentPerSqft(rs.getDouble("avgCompsRentPerSqft"));
		}
		compsAggregatedInfo.setRentCompsList(rentCompsList);
		return compsAggregatedInfo;
	}

	private CompsPropertyInfo mapPropertyInfo(ResultSet rs) throws SQLException {

		LOGGER.debug("Mapping result set row to CompsPropertyInfo object");
		CompsPropertyInfo propertyInfo = new CompsPropertyInfo();
		propertyInfo.setMlsNumber(rs.getString("mlsnumber"));
		propertyInfo.setListingStatus(rs.getString("listingstatus"));
		propertyInfo.setAddress(rs.getString("address"));
		propertyInfo.setBedrooms(rs.getString("bed"));
		int fullBaths = rs.getInt("baths");
		int halfBaths = rs.getInt("half_bath");
		propertyInfo.setFullBathrooms(fullBaths);
		propertyInfo.setHalfBathrooms(halfBaths);
		int totalBathrooms = fullBaths + halfBaths;
		propertyInfo.setBathrooms(totalBathrooms);
		propertyInfo.setTotalSqft(rs.getString("sqft"));
		propertyInfo.setYearBuilt(rs.getString("yearBuilt"));
		propertyInfo.setLatitude(rs.getString("compLatitude"));
		propertyInfo.setLongitude(rs.getString("compLongitude"));
		propertyInfo.setPhotoLink(rs.getString("imgPath"));
		propertyInfo.setPrice(rs.getDouble("saleprice"));
		propertyInfo.setPricePerSqft(rs.getDouble("salePricePerSqft"));
		propertyInfo.setSoldDate(rs.getDate("soldDate"));
		propertyInfo.setRent(rs.getDouble("rent"));
		propertyInfo.setRentPerSqft(rs.getDouble("rentPerSqft"));
		propertyInfo.setLeasedDate(rs.getDate("leasedDate"));
		return propertyInfo;
	}
}
