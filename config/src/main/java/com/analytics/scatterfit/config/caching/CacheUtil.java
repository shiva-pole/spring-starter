
package com.analytics.scatterfit.config.caching;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import net.sf.ehcache.CacheManager;

@Component
public class CacheUtil {

	public void clear() {

		CacheManager.getInstance().clearAll();
	}

	public void clear(String cacheName) {

		CacheManager.getInstance().getCache(cacheName).removeAll();
	}

	public void clear(String cacheName, Serializable key) {

		CacheManager.getInstance().getCache(cacheName).remove(key);
	}
}
