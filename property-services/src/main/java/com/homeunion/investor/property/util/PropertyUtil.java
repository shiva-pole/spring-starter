
package com.homeunion.investor.property.util;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.homeunion.investor.assetclass.domain.AssetClassDetails;
import com.homeunion.investor.assetclass.domain.MlsInfo;
import com.homeunion.investor.common.search.CriteriaBuilder;
import com.homeunion.investor.common.search.criterion.Operation;
import com.homeunion.investor.property.domain.PropertySummary;
import com.homeunion.investor.property.service.impl.PropertySearchServiceImpl;

public class PropertyUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(PropertySearchServiceImpl.class);

	public static <T extends PropertySummary> List<T> injectAssetClassAttributes(List<T> properties, List<AssetClassDetails> assetClassList) {

		for (PropertySummary property : properties) {
			AssetClassDetails assetClassDetails = new CriteriaBuilder().where("isEnabled", Operation.EQUALS, Boolean.TRUE)
			                                                           .and("assetClassId", Operation.EQUALS, property.getAssetClassId())
			                                                           .build()
			                                                           .applyAndExtractOne(assetClassList);
			if (assetClassDetails != null) {
				//set asset class name and uri
				property.setAssetClassName(assetClassDetails.getAssetClassName());
				property.setAssetClassNameUri(assetClassDetails.getAssetClassNameUri());
				property.setInvestmentGoal(assetClassDetails.getInvestmentGoal());
				property.setHilGroupName(assetClassDetails.getHilGroupName());
			}
		}
		LOGGER.info("Injected Asset Class Attributes in property summary object");
		return properties;
	}

	public static <T extends PropertySummary> List<T> injectMlsInfo(List<T> properties, List<MlsInfo> mlsInfoList) {

		for (PropertySummary property : properties) {
			if (property.getPropertyListing() == null) {
				continue;
			}
			MlsInfo mlsInfo = null;
			if ( !StringUtils.isEmpty(property.getPropertyListing().getMlsName())) {
				LOGGER.debug("Property {} has Mls Name {}", property.getPropertyId(), property.getPropertyListing().getMlsName());
				mlsInfo = new CriteriaBuilder().where("mlsName", Operation.EQUALS, property.getPropertyListing().getMlsName())
				                               .build()
				                               .applyAndExtractOne(mlsInfoList);
			} else if ( !StringUtils.isEmpty(property.getPropertyListing().getAssignedQBR())) {
				LOGGER.debug("Property {} has Assigned QBR {}", property.getPropertyId(), property.getPropertyListing().getAssignedQBR());
				mlsInfo = new CriteriaBuilder().where("ilmName", Operation.EQUALS, property.getPropertyListing().getAssignedQBR())
				                               .build()
				                               .applyAndExtractOne(mlsInfoList);
			}
			if (mlsInfo == null) {
				LOGGER.debug("Could not find Mls Info for property {}", property.getPropertyId());
			} else if (StringUtils.isEmpty(property.getPropertyListing().getMlsName()) && !StringUtils.isEmpty(mlsInfo.getMlsName())) {
				property.getPropertyListing().setMlsName(mlsInfo.getMlsName());
			}
			property.setMlsInfo(mlsInfo);
		}
		LOGGER.info("Injected Mls Info in property summary objects");
		return properties;
	}

	public static <T extends PropertySummary> T injectAssetClassAttributes(T property, List<AssetClassDetails> assetClassList) {

		return injectAssetClassAttributes(Arrays.asList(property), assetClassList).get(0);
	}

	public static <T extends PropertySummary> T injectMlsInfo(T property, List<MlsInfo> mlsInfoList) {

		return injectMlsInfo(Arrays.asList(property), mlsInfoList).get(0);
	}

	public static String capitalize(String sentence) {

		if (StringUtils.isEmpty(sentence)) {
			return "";
		}
		String capitalized = "";
		String[] words = sentence.split(" ");
		for (int i = 0; i < words.length; i++) {
			capitalized += StringUtils.capitalize(words[i].toLowerCase());
			if (i < words.length - 1) {
				capitalized += " ";
			}
		}
		return capitalized;
	}

	private PropertyUtil() {

		//Private constructor to hide instantiation
	}
}
