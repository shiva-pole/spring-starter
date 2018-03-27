
package com.homeunion.investor.test.property.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.homeunion.investor.assetclass.domain.AssetClassDetails;
import com.homeunion.investor.assetclass.domain.MlsInfo;
import com.homeunion.investor.assetclass.service.AssetClassService;
import com.homeunion.investor.assetclass.service.MlsService;
import com.homeunion.investor.property.dao.PropertyDAO;
import com.homeunion.investor.property.domain.PropertyListing;
import com.homeunion.investor.property.domain.PropertyListingInfo;
import com.homeunion.investor.property.domain.PropertySaleHistory;
import com.homeunion.investor.property.domain.PropertySummary;
import com.homeunion.investor.property.domain.comps.CompsAggregatedInfo;
import com.homeunion.investor.property.domain.comps.CompsPropertyInfo;
import com.homeunion.investor.property.domain.comps.PropertyComps;
import com.homeunion.investor.property.domain.media.PhotoDetail;
import com.homeunion.investor.property.domain.media.PropertyMedia;
import com.homeunion.investor.property.service.impl.PropertyServiceImpl;
import com.homeunion.investor.test.common.TestUtils;

@RunWith(MockitoJUnitRunner.class)
public class PropertyServiceImplTest extends TestUtils {

	@Mock
	private PropertyDAO propertyDAO;
	@Mock
	private AssetClassService assetClassService;
	@Mock
	private MlsService mlsService;
	@InjectMocks
	private PropertyServiceImpl propertyServiceImpl;

	@Test
	public void testGetPropertySummary() {

		PropertySummary propSummary = new PropertySummary();
		String propertyId = "propId";
		int classId = 22;
		//create assetClassList
		List<AssetClassDetails> assetClassList = new ArrayList<AssetClassDetails>();
		AssetClassDetails democlass = new AssetClassDetails();
		democlass.setAssetClassId(classId);
		democlass.setAssetClassName("demoClass");
		democlass.setIsEnabled(true);
		assetClassList.add(democlass);
		Mockito.when(assetClassService.getAssetClassList()).thenReturn(assetClassList);
		//create property summary
		PropertySummary propertySummary = new PropertySummary();
		propertySummary.setPropertyId(propertyId);
		propertySummary.setPropertyDescription("demoPropertyDescription");
		propertySummary.setAssetClassId(classId);
		Mockito.when(propertyDAO.getPropertySummary(propertyId)).thenReturn(propertySummary);
		//call the test method
		propSummary = propertyServiceImpl.getPropertySummary(propertyId);
		//Assertion
		Assert.assertNotNull(propSummary);
		Assert.assertEquals(propertyId, propSummary.getPropertyId());
	}

	@Test
	/**
	 * 
	 * getPropertyListing - When assignedQBR is null 
	 *
	 **/
	public void testGetPropertyListingSuccessCase1() {

		PropertyListing listing = new PropertyListing();
		String propertyId = "propId";
		String mlsName = "demoMls";
		String assignedQBR = null;
		//create listing info first
		PropertyListingInfo listingInfo = new PropertyListingInfo();
		listingInfo.setMlsName(mlsName);
		listingInfo.setAssignedQBR(assignedQBR);
		Mockito.when(propertyDAO.getPropertyListing(propertyId)).thenReturn(listingInfo);
		//create list of mls info
		List<MlsInfo> mlsInfoList = new ArrayList<MlsInfo>();
		MlsInfo mlsInfo = new MlsInfo();
		mlsInfo.setMlsName(mlsName);
		mlsInfo.setIlmName(assignedQBR);
		mlsInfoList.add(mlsInfo);
		//
		Mockito.when(mlsService.getMlsInfoList()).thenReturn(mlsInfoList);
		//call the test method
		listing = propertyServiceImpl.getPropertyListing(propertyId);
		//Assertion
		Assert.assertNotNull(listing);
		Assert.assertNotNull(listing.getMlsInfo());
		Assert.assertEquals(mlsName, listing.getMlsInfo().getMlsName());
	}

	@Test
	/**
	 * 
	 * getPropertyListing - When mlsName is null
	 *
	 **/
	public void testGetPropertyListingSuccessCase2() {

		PropertyListing listing = new PropertyListing();
		String propertyId = "propId";
		String mlsName = null;
		String assignedQBR = "John Doe";
		//create listing info first
		PropertyListingInfo listingInfo = new PropertyListingInfo();
		listingInfo.setMlsName(mlsName);
		listingInfo.setAssignedQBR(assignedQBR);
		Mockito.when(propertyDAO.getPropertyListing(propertyId)).thenReturn(listingInfo);
		//create list of mls info
		List<MlsInfo> mlsInfoList = new ArrayList<MlsInfo>();
		MlsInfo mlsInfo = new MlsInfo();
		mlsInfo.setMlsName(mlsName);
		mlsInfo.setIlmName(assignedQBR);
		mlsInfoList.add(mlsInfo);
		//
		Mockito.when(mlsService.getMlsInfoList()).thenReturn(mlsInfoList);
		//call the test method
		listing = propertyServiceImpl.getPropertyListing(propertyId);
		//Assertion
		Assert.assertNotNull(listing);
		Assert.assertNotNull(listing.getMlsInfo());
		Assert.assertEquals(assignedQBR, listing.getMlsInfo().getIlmName());
	}

	@Test
	/**
	 * 
	 * getPropertyListing - When mlsName and assignedQBR are not null
	 *
	 **/
	public void testGetPropertyListingSuccessCase3() {

		PropertyListing listing = new PropertyListing();
		String propertyId = "propId";
		String mlsName = "demoMls";
		String assignedQBR = "John Doe";
		//create listing info first
		PropertyListingInfo listingInfo = new PropertyListingInfo();
		listingInfo.setMlsName(mlsName);
		listingInfo.setAssignedQBR(assignedQBR);
		Mockito.when(propertyDAO.getPropertyListing(propertyId)).thenReturn(listingInfo);
		//create list of mls info
		List<MlsInfo> mlsInfoList = new ArrayList<MlsInfo>();
		MlsInfo mlsInfo = new MlsInfo();
		mlsInfo.setMlsName(mlsName);
		mlsInfo.setIlmName(assignedQBR);
		mlsInfoList.add(mlsInfo);
		//
		Mockito.when(mlsService.getMlsInfoList()).thenReturn(mlsInfoList);
		//call the test method
		listing = propertyServiceImpl.getPropertyListing(propertyId);
		//Assertion
		Assert.assertNotNull(listing);
		Assert.assertNotNull(listing.getMlsInfo());
		Assert.assertEquals(mlsName, listing.getMlsInfo().getMlsName());
		Assert.assertEquals(assignedQBR, listing.getMlsInfo().getIlmName());
	}

	@Test
	/**
	 * 
	 * getPropertyListing - When mlsInfo is null
	 *
	 **/
	public void testGetPropertyListingSuccessCase4() {

		PropertyListing listing = new PropertyListing();
		String propertyId = "propId";
		String mlsName = null;
		String assignedQBR = null;
		//create listing info first
		PropertyListingInfo listingInfo = new PropertyListingInfo();
		listingInfo.setMlsName(mlsName);
		listingInfo.setAssignedQBR(assignedQBR);
		Mockito.when(propertyDAO.getPropertyListing(propertyId)).thenReturn(listingInfo);
		//create list of mls info
		List<MlsInfo> mlsInfoList = null;
		//
		Mockito.when(mlsService.getMlsInfoList()).thenReturn(mlsInfoList);
		//call the test method
		listing = propertyServiceImpl.getPropertyListing(propertyId);
		//Assertion
		Assert.assertNotNull(listing);
		Assert.assertNull(listing.getMlsInfo());
	}

	@Test
	public void testGetPropertyMedia() {

		String propertyId = "propId";
		List<PhotoDetail> photos = new ArrayList<PhotoDetail>();
		PropertyMedia propMedia = new PropertyMedia();
		propMedia.setPhotos(photos);
		Mockito.when(propertyDAO.getPropertyMedia(propertyId)).thenReturn(propMedia);
		PropertyMedia result = propertyServiceImpl.getPropertyMedia(propertyId);
		Assert.assertNotNull(result);
	}

	@Test
	public void getPropertyCompsSuccess() {

		PropertyComps propComps = new PropertyComps();
		Double minPrice = 100000.00;
		Double maxPrice = 100200.00;
		Double minRent = 920.00;
		Double maxRent = 1000.00;
		//create the property comps
		CompsPropertyInfo activeProperty = new CompsPropertyInfo();
		activeProperty.setPrice(minPrice);
		activeProperty.setRent(maxRent);
		propComps.setActiveProperty(activeProperty);
		//create price comps
		List<CompsPropertyInfo> priceComps = new ArrayList<CompsPropertyInfo>();
		//priceComp1
		CompsPropertyInfo priceComp1 = new CompsPropertyInfo();
		priceComp1.setPrice(100100.00);
		priceComps.add(priceComp1);
		//priceComp2
		CompsPropertyInfo priceComp2 = new CompsPropertyInfo();
		priceComp2.setPrice(maxPrice);
		priceComps.add(priceComp2);
		//create rent comps
		List<CompsPropertyInfo> rentComps = new ArrayList<CompsPropertyInfo>();
		//rentComp1
		CompsPropertyInfo rentComp1 = new CompsPropertyInfo();
		rentComp1.setRent(minRent);
		rentComps.add(rentComp1);
		//rentComp2
		CompsPropertyInfo rentComp2 = new CompsPropertyInfo();
		rentComp2.setRent(980.00);
		rentComps.add(rentComp2);
		//set comps
		propComps.setPriceComps(priceComps);
		propComps.setRentComps(rentComps);
		CompsAggregatedInfo compsAggregatedInfo = new CompsAggregatedInfo();
		propComps.setCompsAggregatedInfo(compsAggregatedInfo);
		//Mock dao method
		Mockito.when(propertyDAO.getPropertyComps(Mockito.any(String.class), Mockito.any(String.class))).thenReturn(propComps);
		//call test method
		PropertyComps result = propertyServiceImpl.getPropertyComps(Mockito.any(String.class), Mockito.any(String.class));
		//Assertion
		Assert.assertNotNull(result);
		Assert.assertNotNull(result.getCompsAggregatedInfo());
		Assert.assertEquals(minPrice, result.getCompsAggregatedInfo().getMinPrice());
		Assert.assertEquals(maxPrice, result.getCompsAggregatedInfo().getMaxPrice());
		Assert.assertEquals(minRent, result.getCompsAggregatedInfo().getMinRent());
		Assert.assertEquals(maxRent, result.getCompsAggregatedInfo().getMaxRent());
	}

	@Test
	public void getPropertyCompsNoResults() {

		Mockito.when(propertyDAO.getPropertyComps(Mockito.any(String.class), Mockito.any(String.class))).thenReturn(null);
		PropertyComps result = propertyServiceImpl.getPropertyComps(Mockito.any(String.class), Mockito.any(String.class));
		//Assertion
		Assert.assertNull(result);
	}

	@Test
	public void getPropertySaleHistory() {

		String propertyId = "propId";
		PropertySaleHistory propertySaleHistory = new PropertySaleHistory();
		propertySaleHistory.setPropertyId(propertyId);
		Mockito.when(propertyDAO.getPropertySaleHistory(propertyId)).thenReturn(propertySaleHistory);
		PropertySaleHistory result = propertyServiceImpl.getPropertySaleHistory(propertyId);
		Assert.assertNotNull(result);
		Assert.assertEquals(propertyId, result.getPropertyId());
	}

	@Test
	public void getAssetClassProperties() {

		int assetClassId = 2;
		String assetClassNameUri = "class-name";
		String propertyId = "propId";
		//create dummy asset class
		AssetClassDetails assetClass = new AssetClassDetails();
		assetClass.setAssetClassId(assetClassId);
		assetClass.setAssetClassNameUri(assetClassNameUri);
		assetClass.setIsEnabled(true);
		//create dummy prop list
		List<PropertySummary> daoProperties = new ArrayList<PropertySummary>();
		PropertySummary prop = new PropertySummary();
		prop.setAssetClassId(assetClassId);
		prop.setPropertyId(propertyId);
		daoProperties.add(prop);
		//mock external methods
		Mockito.when(assetClassService.getAssetClassDetails(assetClassNameUri)).thenReturn(assetClass);
		Mockito.when(propertyDAO.getAssetClassProperties(assetClass.getAssetClassId())).thenReturn(daoProperties);
		List<PropertySummary> result = propertyServiceImpl.getAssetClassProperties(assetClassNameUri);
		//Assertion
		Assert.assertNotNull(result);
		Assert.assertNotNull(result.get(0));
		Assert.assertEquals(propertyId, result.get(0).getPropertyId());
	}
}
