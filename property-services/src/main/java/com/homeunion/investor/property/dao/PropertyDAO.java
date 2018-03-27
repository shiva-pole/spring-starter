
package com.homeunion.investor.property.dao;

import java.util.List;

import com.homeunion.investor.property.domain.EmployersInfo;
import com.homeunion.investor.property.domain.PropertyListingInfo;
import com.homeunion.investor.property.domain.PropertySaleHistory;
import com.homeunion.investor.property.domain.PropertySummary;
import com.homeunion.investor.property.domain.comps.PropertyComps;
import com.homeunion.investor.property.domain.media.PropertyMedia;

public interface PropertyDAO {

	PropertySummary getPropertySummary(String propertyId);

	PropertyListingInfo getPropertyListing(String propertyId);

	PropertyMedia getPropertyMedia(String propertyId);

	PropertyComps getPropertyComps(String mlsName, String mlsNumber);

	PropertySaleHistory getPropertySaleHistory(String propertyId);

	List<PropertySummary> getAssetClassProperties(Integer assetClassId);

	List<EmployersInfo> getEmployersInfo(String latitude, String longitude, String radius);
}
