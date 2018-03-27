
package com.homeunion.investor.property.domain;

import com.homeunion.investor.assetclass.domain.MlsInfo;

public class PropertyListing {

	private PropertyListingInfo listingInfo;
	private MlsInfo mlsInfo;

	public PropertyListingInfo getListingInfo() {

		return listingInfo;
	}

	public void setListingInfo(PropertyListingInfo listingInfo) {

		this.listingInfo = listingInfo;
	}

	public MlsInfo getMlsInfo() {

		return mlsInfo;
	}

	public void setMlsInfo(MlsInfo mlsInfo) {

		this.mlsInfo = mlsInfo;
	}
}
