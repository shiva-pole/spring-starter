
package com.homeunion.investor.property.service.impl;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.homeunion.investor.assetclass.domain.AssetClassDetails;
import com.homeunion.investor.assetclass.domain.MlsInfo;
import com.homeunion.investor.assetclass.service.AssetClassService;
import com.homeunion.investor.assetclass.service.MlsService;
import com.homeunion.investor.common.domain.FinancingType;
import com.homeunion.investor.common.domain.InvestmentGoal;
import com.homeunion.investor.common.domain.SortDirection;
import com.homeunion.investor.common.search.CriteriaBuilder;
import com.homeunion.investor.common.search.criterion.Operation;
import com.homeunion.investor.property.domain.search.PropertySearchCriteria;
import com.homeunion.investor.property.domain.search.PropertySearchResult;
import com.homeunion.investor.property.domain.search.PropertySearchSortOption;
import com.homeunion.investor.property.service.PropertySearchService;
import com.homeunion.investor.property.util.PropertyUtil;

public abstract class BasePropertySearchServiceImpl implements PropertySearchService, InitializingBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(BasePropertySearchServiceImpl.class);
	@Autowired
	private Environment env;
	@Autowired
	protected AssetClassService assetClassService;
	@Autowired
	private MlsService mlsService;
	protected InvestmentGoal defaultInvestmentGoal;
	protected FinancingType defaultFinancingType;
	protected PropertySearchSortOption defaultSortOption;
	protected SortDirection defaultSortDirection;
	protected int defaultInvestmentAmount;
	protected int minPriceFinanced;
	protected int minPriceAllCash;
	protected int defaultMinTotalReturn;
	protected int defaultMaxTotalReturn;
	protected List<String> defaultNir;
	protected int pageSize;

	@Override
	final public PropertySearchResult searchProperties(PropertySearchCriteria inputSearchCriteria) {

		LOGGER.info("Entered Search Properties for criteria {}", inputSearchCriteria);
		PropertySearchResult result = new PropertySearchResult();
		//step 0 - sanitize search criteria
		PropertySearchCriteria searchCriteria = setDefaults(inputSearchCriteria);
		int minPrice = FinancingType.ALLCASH == searchCriteria.getFinancingType() ? minPriceAllCash : minPriceFinanced;
		int limitTo = searchCriteria.getPageSize();
		int limitFrom = searchCriteria.getPageSize() * (searchCriteria.getPageNum() - 1);
		//step 1 - get the valid asset class ids for hil groups
		List<AssetClassDetails> assetClassList = assetClassService.getAssetClassList();
		List<Integer> assetClassIds = getFilteredAssetClassIds(assetClassList, searchCriteria);
		if (CollectionUtils.isEmpty(assetClassIds)) {
			LOGGER.warn("Property Search criteria did not match any asset class ids. returning 0 properties");
			return result;
		}
		//step 2 - search properties and get property count
		result = getSearchResult(searchCriteria, assetClassIds, minPrice, limitFrom, limitTo);
		//step 3 - populate asset class details from cached list
		PropertyUtil.injectAssetClassAttributes(result.getProperties(), assetClassList);
		//fetch list of mls info from cache
		List<MlsInfo> mlsInfoList = mlsService.getMlsInfoList();
		//inject mlsinfo
		PropertyUtil.injectMlsInfo(result.getProperties(), mlsInfoList);
		//step 4 - set and return!
		LOGGER.info("Property Search results: totalPropertyCount {}, pageProperties {}", result.getTotalPropertyCount(), result.getProperties().size());
		return result;
	}

	public abstract PropertySearchResult getSearchResult(PropertySearchCriteria searchCriteria,
	                                                     List<Integer> assetClassIds,
	                                                     int minPrice,
	                                                     int limitFrom,
	                                                     int limitTo);

	protected PropertySearchCriteria setDefaults(PropertySearchCriteria searchCriteria) {

		if (searchCriteria.getFinancingType() == null) {
			searchCriteria.setFinancingType(defaultFinancingType);
		}
		if (searchCriteria.getSortOption() == null) {
			searchCriteria.setSortOption(defaultSortOption);
		}
		if (searchCriteria.getSortDirection() == null) {
			searchCriteria.setSortDirection(defaultSortDirection);
		}
		if (searchCriteria.getInvestmentAmount() <= 0) {
			searchCriteria.setInvestmentAmount(defaultInvestmentAmount);
		}
		if (searchCriteria.getPageSize() <= 0) {
			searchCriteria.setPageSize(pageSize);
		}
		if (searchCriteria.getPageNum() <= 0) {
			searchCriteria.setPageNum(1);
		}
		if (searchCriteria.getMinTotalReturn() <= 0) {
			searchCriteria.setMinTotalReturn(defaultMinTotalReturn);
		}
		if (searchCriteria.getMaxTotalReturn() <= 0) {
			searchCriteria.setMaxTotalReturn(defaultMaxTotalReturn);
		}
		if (CollectionUtils.isEmpty(searchCriteria.getNir())) {
			searchCriteria.setNir(defaultNir);
		}
		LOGGER.debug("Search Properties criteria with defaults set to {}", searchCriteria);
		return searchCriteria;
	}

	private String getCaseInsensitiveRegexPattern(String key) {

		return "(?i:.*" + key + ".*)";
	}

	protected List<Integer> getFilteredAssetClassIds(List<AssetClassDetails> assetClassList, PropertySearchCriteria searchCriteria) {

		CriteriaBuilder criteriaBuilder = new CriteriaBuilder().where("isEnabled", Operation.EQUALS, Boolean.TRUE);
		if (searchCriteria.getInvestmentGoal() != null) {
			criteriaBuilder.and("investmentGoal", Operation.EQUALS, searchCriteria.getInvestmentGoal().toString());
		}
		if ( !StringUtils.isEmpty(searchCriteria.getState())) {
			criteriaBuilder.and("hilGroupState", Operation.EQUALS, searchCriteria.getState());
		}
		if ( !StringUtils.isEmpty(searchCriteria.getCity())) {
			criteriaBuilder.and("hilGroupName", Operation.LIKE, getCaseInsensitiveRegexPattern(searchCriteria.getCity()));
		}
		if ( !CollectionUtils.isEmpty(searchCriteria.getHilGroups())) {
			criteriaBuilder.and("hilGroupId", Operation.IN, searchCriteria.getHilGroups());
		}
		List<Integer> assetClassIds = criteriaBuilder.build().applyAndExtract(assetClassList, "assetClassId", Integer.class);
		LOGGER.debug("Property Search criteria filtered asset class ids: {}", assetClassIds);
		return assetClassIds;
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		defaultInvestmentGoal = InvestmentGoal.fromValue(env.getProperty("property-search.default-investment-goal"));
		defaultFinancingType = FinancingType.fromValue(env.getProperty("property-search.default-financing-type"));
		defaultSortOption = PropertySearchSortOption.fromValue(env.getProperty("property-search.default-sort-option"));
		defaultSortDirection = SortDirection.fromValue(env.getProperty("property-search.default-sort-direction"));
		defaultInvestmentAmount = Integer.parseInt(env.getProperty("property-search.default-investment-amount"));
		minPriceFinanced = Integer.parseInt(env.getProperty("property-search.min-price-financed"));
		minPriceAllCash = Integer.parseInt(env.getProperty("property-search.min-price-allcash"));
		defaultMinTotalReturn = Integer.parseInt(env.getProperty("property-search.min-total-return"));
		defaultMaxTotalReturn = Integer.parseInt(env.getProperty("property-search.max-total-return"));
		defaultNir = Arrays.asList(env.getProperty("property-search.default-nir").split(","));
		pageSize = Integer.parseInt(env.getProperty("property-search.page-size"));
		LOGGER.info("Configured Property Search Config as {}, {}, {}, {}, {}, {}, {}, {}, {}, {}",
		            defaultInvestmentGoal,
		            defaultFinancingType,
		            defaultSortOption,
		            defaultSortDirection,
		            defaultInvestmentAmount,
		            minPriceFinanced,
		            minPriceAllCash,
		            defaultMinTotalReturn,
		            defaultMaxTotalReturn,
		            pageSize);
	}
}
