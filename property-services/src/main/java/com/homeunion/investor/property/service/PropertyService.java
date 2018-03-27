
package com.homeunion.investor.property.service;

import java.util.List;

import com.homeunion.investor.property.domain.EmployersInfo;
import com.homeunion.investor.property.domain.PropertyListing;
import com.homeunion.investor.property.domain.PropertySaleHistory;
import com.homeunion.investor.property.domain.PropertySummary;
import com.homeunion.investor.property.domain.comps.PropertyComps;
import com.homeunion.investor.property.domain.media.PropertyMedia;

public interface PropertyService {

	PropertySummary getPropertySummary(String propertyId);

	PropertyListing getPropertyListing(String propertyId);

	PropertyMedia getPropertyMedia(String propertyId);

	PropertyComps getPropertyComps(String mlsName, String mlsNumber);

	PropertySaleHistory getPropertySaleHistory(String propertyId);

	List<PropertySummary> getAssetClassProperties(String assetClassName);

	List<EmployersInfo> getEmployersInfo(String latitude, String longitude, String radius);
}
