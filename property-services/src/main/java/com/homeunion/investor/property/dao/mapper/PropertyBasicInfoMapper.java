
package com.homeunion.investor.property.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.homeunion.investor.property.domain.PropertyBasicInfo;

public abstract class PropertyBasicInfoMapper {

	private static final Logger LOGGER = LoggerFactory.getLogger(PropertyBasicInfoMapper.class);
	private static final SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd");

	protected <T extends PropertyBasicInfo> T mapPropertyBasicInfoAttributes(T propertyBasicInfo, ResultSet rs) throws SQLException {

		propertyBasicInfo.setPropertyId(rs.getString("propertyid"));
		propertyBasicInfo.setAddress(rs.getString("address"));
		propertyBasicInfo.setUnitNumber(rs.getString("unit_number"));
		propertyBasicInfo.setCity(rs.getString("city"));
		propertyBasicInfo.setState(rs.getString("state"));
		propertyBasicInfo.setZip(rs.getString("zip"));
		propertyBasicInfo.setBedrooms(rs.getString("bed_rooms"));
		int fullBathrooms = 0;
		try {
			fullBathrooms = Integer.parseInt(rs.getString("bath_rooms"));
		} catch (Exception e) {
			LOGGER.debug("The number of full bathrooms is not an integer for propertyId: {}", rs.getString("propertyid"));
		}
		int halfBathrooms = rs.getInt("m_halfBathCount");
		int totalBathrooms = fullBathrooms + halfBathrooms;
		propertyBasicInfo.setFullBathrooms(fullBathrooms);
		propertyBasicInfo.setHalfBathrooms(halfBathrooms);
		propertyBasicInfo.setBathrooms(totalBathrooms);
		propertyBasicInfo.setTotalSqft(rs.getString("total_sqft"));
		propertyBasicInfo.setYearBuilt(rs.getString("year_built"));
		propertyBasicInfo.setPropertyStatus(rs.getString("property_status"));
		propertyBasicInfo.setHuStatus(rs.getInt("hu_status"));
		propertyBasicInfo.setLatitude(rs.getString("latitude"));
		propertyBasicInfo.setLongitude(rs.getString("longitude"));
		String onHUSince = rs.getString("on_homeunion_since_date");
		String mlsLastModifiedDate = rs.getString("date_mls_modified");
		try {
			if ( !StringUtils.isEmpty(onHUSince)) {
				propertyBasicInfo.setOnHUSince(dateTimeFormat.parse(onHUSince));
			}
			if ( !StringUtils.isEmpty(mlsLastModifiedDate)) {
				propertyBasicInfo.setDateMLSModified(dateTimeFormat.parse(mlsLastModifiedDate));
			}
		} catch (Exception e) {
			//silently kill this exception
			LOGGER.debug("Exception occurred while parsing on homeunion since date.", e);
			propertyBasicInfo.setOnHUSince(rs.getDate("on_homeunion_since_date"));
			propertyBasicInfo.setDateMLSModified(rs.getDate("on_homeunion_since_date"));
		}
		propertyBasicInfo.setPhotoCount(rs.getInt("num_photos"));
		propertyBasicInfo.setPhotoLink(rs.getString("thumbnail_link"));
		propertyBasicInfo.setPropertyDescription(rs.getString("prop_desc"));
		propertyBasicInfo.setPropertyTypeDesc(rs.getString("property_type_desc"));
		propertyBasicInfo.setHil(rs.getString("HIL"));
		propertyBasicInfo.setNir(rs.getString("nir"));
		if ("LUX".equals(propertyBasicInfo.getNir())) {
			propertyBasicInfo.setNir("A+");
		}
		propertyBasicInfo.setPropertySource(rs.getString("property_source"));
		propertyBasicInfo.setCalculationFreezeDate(rs.getDate("calculation_freeze_date"));
		return propertyBasicInfo;
	}
}
