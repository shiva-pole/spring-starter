
package com.homeunion.investor.property.service;

import com.homeunion.investor.property.domain.search.PropertySearchCriteria;
import com.homeunion.investor.property.domain.search.PropertySearchResult;

public interface PropertySearchService {

	PropertySearchResult searchProperties(PropertySearchCriteria searchCriteria);
}
