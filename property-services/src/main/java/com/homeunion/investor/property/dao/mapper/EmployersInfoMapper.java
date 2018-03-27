
package com.homeunion.investor.property.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.homeunion.investor.property.domain.EmployersInfo;

@Component
public class EmployersInfoMapper implements RowMapper<EmployersInfo> {

	@Override
	public EmployersInfo mapRow(ResultSet rs, int rowNum) throws SQLException {

		EmployersInfo result = new EmployersInfo();
		result.setEmployerId(rs.getString("employer_id"));
		result.setZipcode(rs.getString("zipcode"));
		result.setZipPlus4(rs.getString("zip_plus4"));
		result.setCompanyName(rs.getString("company_name"));
		result.setAddressLine1(rs.getString("address_line1"));
		result.setAddressLine2(rs.getString("address_line2"));
		result.setCity(rs.getString("city"));
		result.setState(rs.getString("state"));
		result.setCountyName(rs.getString("county_name"));
		result.setBusinessDescription(rs.getString("business_description"));
		result.setNoOfEmployeesRange(rs.getString("no_of_employees_range"));
		result.setSalesVolume(rs.getString("sales_volume"));
		result.setHeadquartersOrBranch(rs.getString("headquarters_or_branch"));
		result.setPhone(rs.getString("phone"));
		result.setLatitude(rs.getString("latitude"));
		result.setLongitude(rs.getString("longitude"));
		result.setCreatedBy(rs.getString("created_by"));
		result.setModifiedBy(rs.getString("modified_by"));
		result.setDateCreated(rs.getDate("date_created"));
		result.setDateModified(rs.getDate("date_modified"));
		result.setInstid(rs.getByte("instid"));
		return result;
	}
}
