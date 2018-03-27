/**
 * 
 */

package com.analytics.scatterfit.config.persistence;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;

/**
 * The Spring Configuration for DataSource to connect to the DB accessed by the
 * application.
 * 
 * @author RohanS
 */
@Configuration
public class DataSourceConfig {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceConfig.class);
	/** The env. */
	@Autowired
	private Environment env;

	/**
	 * read write data source for dev environment. DB configuration is loaded
	 * from env-dev properties.
	 *
	 * @return the data source
	 */
	@Profile("dev")
	@Primary
	@Bean(name = "appDataSource", autowire = Autowire.BY_NAME)
	public DataSource appDataSourceDev() {

		LOGGER.info("Loading Read Write Data Source for Dev Environment");
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("scatterfit.datasource.driverClassName"));
		dataSource.setUrl(env.getProperty("scatterfit.datasource.url"));
		dataSource.setUsername(env.getProperty("scatterfit.datasource.username"));
		dataSource.setPassword(env.getProperty("scatterfit.datasource.password"));
		dataSource.setTestOnBorrow(true);
		dataSource.setValidationQuery("SELECT 1");
		LOGGER.info("Successfully loaded Read Write Data Source for Dev Environment");
		return dataSource;
	}

	/**
	 * Investor read write data source for production environment. DB is sourced
	 * from JNDI lookup.
	 *
	 * @return the Investor data source
	 */
	@Profile({ "integration", "staging", "production" })
	@Primary
	@Bean(name = "appDataSource", autowire = Autowire.BY_NAME)
	public DataSource appDataSourceProd() {

		LOGGER.info("Loading Read Write Data Source for Integration/Production Environment");
		JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		DataSource dataSource = dataSourceLookup.getDataSource(env.getProperty("scatterfit.datasource.jndi"));
		LOGGER.info("Successfully loaded Read Write Data Source for Integration/Production Environment");
		return dataSource;
	}
}
