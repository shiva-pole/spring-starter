
package com.homeunion.investor.property.domain.comps;

import java.util.List;

public class PropertyComps {

	private CompsAggregatedInfo compsAggregatedInfo;
	private CompsPropertyInfo activeProperty;
	private List<CompsPropertyInfo> priceComps;
	private List<CompsPropertyInfo> rentComps;

	public CompsAggregatedInfo getCompsAggregatedInfo() {

		return compsAggregatedInfo;
	}

	public void setCompsAggregatedInfo(CompsAggregatedInfo compsAggregatedInfo) {

		this.compsAggregatedInfo = compsAggregatedInfo;
	}

	public CompsPropertyInfo getActiveProperty() {

		return activeProperty;
	}

	public void setActiveProperty(CompsPropertyInfo activeProperty) {

		this.activeProperty = activeProperty;
	}

	public List<CompsPropertyInfo> getPriceComps() {

		return priceComps;
	}

	public void setPriceComps(List<CompsPropertyInfo> priceComps) {

		this.priceComps = priceComps;
	}

	public List<CompsPropertyInfo> getRentComps() {

		return rentComps;
	}

	public void setRentComps(List<CompsPropertyInfo> rentComps) {

		this.rentComps = rentComps;
	}
}
