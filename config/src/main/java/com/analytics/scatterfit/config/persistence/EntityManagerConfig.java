
package com.analytics.scatterfit.config.persistence;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.StringUtils;

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = { "com.analytics.scatterfit" })
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager", basePackages = {
		"com.analytics.scatterfit" })
public class EntityManagerConfig {

	@Autowired
	private Environment env;
	@Autowired
	@Qualifier("appDataSource")
	private DataSource appDataSource;

	@Bean(name = "flyway")
	public Flyway getFlyway() {

		org.flywaydb.core.Flyway flyway = new Flyway();
		flyway.setDataSource(appDataSource);
		flyway.setInitOnMigrate(true);
		flyway.repair();
		flyway.migrate();
		return flyway;
	}

	@Primary
	@Bean(name = "entityManagerFactory")
	@DependsOn("flyway")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(appDataSource);
		factory.setJpaVendorAdapter(jpaVendorAdapter());
		factory.setPackagesToScan("com.analytics.scatterfit");
		factory.setJpaProperties(jpaProperties());
		factory.setPersistenceUnitName("appPersistenceUnit");
		factory.afterPropertiesSet();
		factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
		return factory;
	}

	@Primary
	@Bean(name = "transactionManager")
	public PlatformTransactionManager appTransactionManager(EntityManagerFactory factory) {

		return new JpaTransactionManager(factory);
	}

	private JpaVendorAdapter jpaVendorAdapter() {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(Boolean.FALSE);
		vendorAdapter.setShowSql(Boolean.FALSE);
		return vendorAdapter;
	}

	private Properties jpaProperties() {

		Properties jpaProperties = new Properties();
		jpaProperties.put("hibernate.connection.autoReconnect", true);
		jpaProperties.put("hibernate.connection.autoReconnectForPools", true);
		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		jpaProperties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		if (!StringUtils.isEmpty(env.getProperty("hibernate.hbm2ddl.auto"))) {
			jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		}
		return jpaProperties;
	}
}
