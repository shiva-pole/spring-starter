
package com.homeunion.investor.property.domain.search;

public enum PropertySearchSortOption {
	YEAR_BUILT, ASKING_PRICE, INVESTMENT, COC_RETURN, RETURN, APPRECIATION, TOTAL_RETURN, HU_SELECT;

	public static PropertySearchSortOption fromValue(String value) {

		for (PropertySearchSortOption sortOption : PropertySearchSortOption.values()) {
			if (sortOption.toString().equalsIgnoreCase(value)) {
				return sortOption;
			}
		}
		return null;
	}
}
