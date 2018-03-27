
package com.homeunion.investor.property.domain.search;

import java.util.List;

import com.homeunion.investor.property.domain.PropertySummary;

public class PropertySearchResult {

	private int totalPropertyCount;
	private List<PropertySummary> properties;

	public int getTotalPropertyCount() {

		return totalPropertyCount;
	}

	public void setTotalPropertyCount(int totalPropertyCount) {

		this.totalPropertyCount = totalPropertyCount;
	}

	public List<PropertySummary> getProperties() {

		return properties;
	}

	public void setProperties(List<PropertySummary> properties) {

		this.properties = properties;
	}
}
