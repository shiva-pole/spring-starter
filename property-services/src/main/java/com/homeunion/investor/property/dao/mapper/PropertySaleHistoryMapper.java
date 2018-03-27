
package com.homeunion.investor.property.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.homeunion.investor.property.domain.PropertySaleHistory;

@Component
public class PropertySaleHistoryMapper implements RowMapper<PropertySaleHistory> {

	private static final Logger LOGGER = LoggerFactory.getLogger(PropertySaleHistoryMapper.class);

	@Override
	public PropertySaleHistory mapRow(ResultSet rs, int rowNum) throws SQLException {

		LOGGER.debug("Mapping ResultSet row {} to PropertySaleHistoryMapper object", rowNum);
		PropertySaleHistory propertySaleHistory = new PropertySaleHistory();
		propertySaleHistory.setAssetId(rs.getString("asset_id"));
		propertySaleHistory.setInvestmentId(rs.getString("investment_id"));
		propertySaleHistory.setLastPurchaseAmount(rs.getDouble("investment_amount"));
		propertySaleHistory.setLastPurchaseDate(rs.getDate("closingEndDate"));
		propertySaleHistory.setPropertyId(rs.getString("property_id"));
		propertySaleHistory.setUnitCount(rs.getInt("unitCount"));
		return propertySaleHistory;
	}
}
