
package com.homeunion.investor.property.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.homeunion.investor.property.domain.PropertySummary;

@Component
public class PropertySummaryMapper extends BasePropertySummaryMapper implements RowMapper<PropertySummary> {

	private static final Logger LOGGER = LoggerFactory.getLogger(PropertySummaryMapper.class);

	@Override
	public PropertySummary mapRow(ResultSet rs, int rowNum) throws SQLException {

		LOGGER.debug("Mapping ResultSet row {} to PropertySummaryMapper object", rowNum);
		PropertySummary propertySummary = new PropertySummary();
		//call the super class method to map the result set columns
		propertySummary = mapPropertySummaryAttributes(propertySummary, rs, rowNum);
		return propertySummary;
	}
}
