/**
 * 
 */

package com.analytics.scatterfit.common.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * The Base data access object to hold the data source and spring jdbc template
 */
public abstract class BaseDAO {

	/** The read write data source. */
	@Autowired
	@Qualifier("appDataSource")
	private DataSource appDataSource;
	/** The read write named parameter jdbc template. */
	private NamedParameterJdbcTemplate appJdbcTemplate;

	/**
	 * The named parameter jdbc template for Investor read write data source.
	 *
	 * @return the named parameter jdbc template
	 */
	protected NamedParameterJdbcTemplate jdbcRW() {

		if (appJdbcTemplate == null) {
			appJdbcTemplate = new NamedParameterJdbcTemplate(appDataSource);
		}
		return appJdbcTemplate;
	}

	/**
	 * Sets the read write named parameter jdbc template. Used in JUnit tests
	 * ONLY
	 * 
	 * @param appJdbcTemplate
	 */
	public void setappJdbcTemplate(NamedParameterJdbcTemplate appJdbcTemplate) {

		this.appJdbcTemplate = appJdbcTemplate;
	}
}
