
package com.homeunion.investor.property.domain;

import java.util.Date;

import org.apache.solr.client.solrj.beans.Field;

public class PropertyBasicInfo {

	@Field("id")
	private String propertyId;
	@Field("address")
	private String address;
	@Field("unit_number")
	private String unitNumber;
	@Field("city")
	private String city;
	@Field("state")
	private String state;
	@Field("zip")
	private String zip;
	@Field("bed_rooms")
	private String bedrooms;
	@Field("bath_rooms")
	private int fullBathrooms;
	@Field("m_halfBathCount")
	private int halfBathrooms;
	private int bathrooms;
	@Field("total_sqft")
	private String totalSqft;
	@Field("year_built")
	private String yearBuilt;
	@Field("property_status")
	private String propertyStatus;
	@Field("hu_status")
	private int huStatus;
	@Field("latitude")
	private String latitude;
	@Field("longitude")
	private String longitude;
	@Field("on_homeunion_since_date")
	private Date onHUSince;
	@Field("num_photos")
	private int photoCount;
	@Field("thumbnail_link")
	private String photoLink;
	@Field("prop_desc")
	private String propertyDescription;
	@Field("property_type_desc")
	private String propertyTypeDesc;
	@Field("property_source")
	private String propertySource;
	@Field("HIL")
	private String hil;
	private String nir;
	@Field("calculation_freeze_date")
	private Date calculationFreezeDate;
	/*ADD FIELD ANNOTATION FOR MLS LAST MODIFIED AND UPDATE SOLR IMPORT QUERY*/
	private Date dateMLSModified;

	public int getFullBathrooms() {

		return fullBathrooms;
	}

	public void setFullBathrooms(int fullBathrooms) {

		this.fullBathrooms = fullBathrooms;
	}

	public int getHalfBathrooms() {

		return halfBathrooms;
	}

	public void setHalfBathrooms(int halfBathrooms) {

		this.halfBathrooms = halfBathrooms;
	}

	public int getHuStatus() {

		return huStatus;
	}

	public void setHuStatus(int huStatus) {

		this.huStatus = huStatus;
	}

	public String getPropertySource() {

		return propertySource;
	}

	public void setPropertySource(String propertySource) {

		this.propertySource = propertySource;
	}

	public String getPropertyId() {

		return propertyId;
	}

	public void setPropertyId(String propertyId) {

		this.propertyId = propertyId;
	}

	public String getAddress() {

		return address;
	}

	public void setAddress(String address) {

		this.address = address;
	}

	public String getUnitNumber() {

		return unitNumber;
	}

	public void setUnitNumber(String unitNumber) {

		this.unitNumber = unitNumber;
	}

	public String getCity() {

		return city;
	}

	public void setCity(String city) {

		this.city = city;
	}

	public String getState() {

		return state;
	}

	public void setState(String state) {

		this.state = state;
	}

	public String getZip() {

		return zip;
	}

	public void setZip(String zip) {

		this.zip = zip;
	}

	public String getBedrooms() {

		return bedrooms;
	}

	public void setBedrooms(String bedrooms) {

		this.bedrooms = bedrooms;
	}

	public int getBathrooms() {

		return bathrooms;
	}

	public void setBathrooms(int bathrooms) {

		this.bathrooms = bathrooms;
	}

	public String getTotalSqft() {

		return totalSqft;
	}

	public void setTotalSqft(String totalSqft) {

		this.totalSqft = totalSqft;
	}

	public String getYearBuilt() {

		return yearBuilt;
	}

	public void setYearBuilt(String yearBuilt) {

		this.yearBuilt = yearBuilt;
	}

	public String getPropertyStatus() {

		return propertyStatus;
	}

	public void setPropertyStatus(String propertyStatus) {

		this.propertyStatus = propertyStatus;
	}

	public String getLatitude() {

		return latitude;
	}

	public void setLatitude(String latitude) {

		this.latitude = latitude;
	}

	public String getLongitude() {

		return longitude;
	}

	public void setLongitude(String longitude) {

		this.longitude = longitude;
	}

	public Date getOnHUSince() {

		return onHUSince;
	}

	public void setOnHUSince(Date onHUSince) {

		this.onHUSince = onHUSince;
	}

	public int getPhotoCount() {

		return photoCount;
	}

	public void setPhotoCount(int photoCount) {

		this.photoCount = photoCount;
	}

	public String getPhotoLink() {

		return photoLink;
	}

	public void setPhotoLink(String photoLink) {

		this.photoLink = photoLink;
	}

	public String getPropertyDescription() {

		return propertyDescription;
	}

	public void setPropertyDescription(String propertyDescription) {

		this.propertyDescription = propertyDescription;
	}

	public String getPropertyTypeDesc() {

		return propertyTypeDesc;
	}

	public void setPropertyTypeDesc(String propertyTypeDesc) {

		this.propertyTypeDesc = propertyTypeDesc;
	}

	public String getHil() {

		return hil;
	}

	public void setHil(String hil) {

		this.hil = hil;
	}

	public String getNir() {

		return nir;
	}

	public void setNir(String nir) {

		this.nir = nir;
	}

	public Date getCalculationFreezeDate() {

		return calculationFreezeDate;
	}

	public void setCalculationFreezeDate(Date calculationFreezeDate) {

		this.calculationFreezeDate = calculationFreezeDate;
	}

	public Date getDateMLSModified() {

		return dateMLSModified;
	}

	public void setDateMLSModified(Date dateMLSModified) {

		this.dateMLSModified = dateMLSModified;
	}
}
