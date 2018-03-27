/**
 * 
 */

package com.analytics.scatterfit.config.caching;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.analytics.scatterfit.config.constants.ConfigConstants;

import net.sf.ehcache.config.CacheConfiguration;

/**
 * The Configuration of Cache used in the Application.
 */
@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport implements CachingConfigurer {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(CacheConfig.class);
	@Autowired
	private Environment env;

	/**
	 * Creates and returns an instance of EhCache Cache Manager
	 * 
	 * @see CachingConfigurerSupport#cacheManager()
	 */
	@Override
	public CacheManager cacheManager() {

		return new EhCacheCacheManager(ehCacheManager());
	}

	/**
	 * Creates and returns an instance of Simple Key Generator
	 * 
	 * @see CachingConfigurerSupport#keyGenerator()
	 */
	@Override
	public KeyGenerator keyGenerator() {

		return new SimpleKeyGenerator();
	}

	/**
	 * Creates and configures the Eh Cache Manager. It configures the following
	 * caches:<br>
	 * 1. Asset Class Cache - Store the entire list of valid active asset
	 * classes.<br>
	 * 
	 * @return the cache manager
	 */
	@Bean(destroyMethod = "shutdown")
	public net.sf.ehcache.CacheManager ehCacheManager() {

		LOGGER.info("Configuring Cache");
		net.sf.ehcache.config.Configuration ehCacheConfig = new net.sf.ehcache.config.Configuration();
		// ehCacheConfig.addCache(createCacheConfig(ConfigConstants.BCRYPT_CACHE,
		// 10000));
		LOGGER.info("Cache configured successfully");
		return net.sf.ehcache.CacheManager.create(ehCacheConfig);
	}

	/**
	 * Creates the cache configuration with the given name and max size.
	 * 
	 * @param name
	 *            the name
	 * @param size
	 *            the size
	 * @return the cache configuration
	 */
	private CacheConfiguration createCacheConfig(String name, long size) {

		LOGGER.info("Creating Cache for {} of size {}", name, size);
		CacheConfiguration cacheConfiguration = new CacheConfiguration();
		cacheConfiguration.setName(name);
		cacheConfiguration.setMemoryStoreEvictionPolicy(ConfigConstants.LRU);
		cacheConfiguration.setMaxEntriesLocalHeap(size);
		return cacheConfiguration;
	}
}
