
package com.homeunion.investor.property.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.homeunion.investor.property.domain.PropertyListingInfo;

@Component
public class PropertyListingInfoMapper implements RowMapper<PropertyListingInfo> {

	private static final Logger LOGGER = LoggerFactory.getLogger(PropertyListingInfoMapper.class);

	@Override
	public PropertyListingInfo mapRow(ResultSet rs, int rowNum) throws SQLException {

		LOGGER.debug("Mapping ResultSet row {} to MlsInfo object", rowNum);
		PropertyListingInfo listingInfo = new PropertyListingInfo();
		listingInfo.setMlsName(rs.getString("mls_name"));
		listingInfo.setMlsNumber(rs.getString("mls_number"));
		listingInfo.setListingAgentName(rs.getString("listing_agentname"));
		listingInfo.setListingAgentPhone(rs.getString("listing_agentphone"));
		listingInfo.setAssignedQBR(rs.getString("assigned_QBR"));
		listingInfo.setRealtorCompanyName(rs.getString("realtor_companyname"));
		listingInfo.setDaysOnMarket(rs.getString("DOM"));
		listingInfo.setListingBrokerName(rs.getString("listing_broker_companyname"));
		listingInfo.setListingBrokerPhone(rs.getString("listing_broker_companyphone"));
		return listingInfo;
	}
}
