
package com.homeunion.investor.property.domain.comps;

import java.util.Date;

public class CompsPropertyInfo {

	private String mlsNumber;
	private String listingStatus;
	private String address;
	private String bedrooms;
	private int fullBathrooms;
	private int halfBathrooms;
	private int bathrooms;
	private String totalSqft;
	private String yearBuilt;
	private String latitude;
	private String longitude;
	private String photoLink;
	private Double price;
	private Double pricePerSqft;
	private Date soldDate;
	private Double rent;
	private Double rentPerSqft;
	private Date leasedDate;

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

	public String getMlsNumber() {

		return mlsNumber;
	}

	public void setMlsNumber(String mlsNumber) {

		this.mlsNumber = mlsNumber;
	}

	public String getListingStatus() {

		return listingStatus;
	}

	public void setListingStatus(String listingStatus) {

		this.listingStatus = listingStatus;
	}

	public String getAddress() {

		return address;
	}

	public void setAddress(String address) {

		this.address = address;
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

	public String getPhotoLink() {

		return photoLink;
	}

	public void setPhotoLink(String photoLink) {

		this.photoLink = photoLink;
	}

	public Double getPrice() {

		return price;
	}

	public void setPrice(Double price) {

		this.price = price;
	}

	public Double getPricePerSqft() {

		return pricePerSqft;
	}

	public void setPricePerSqft(Double pricePerSqft) {

		this.pricePerSqft = pricePerSqft;
	}

	public Date getSoldDate() {

		return soldDate;
	}

	public void setSoldDate(Date soldDate) {

		this.soldDate = soldDate;
	}

	public Double getRent() {

		return rent;
	}

	public void setRent(Double rent) {

		this.rent = rent;
	}

	public Double getRentPerSqft() {

		return rentPerSqft;
	}

	public void setRentPerSqft(Double rentPerSqft) {

		this.rentPerSqft = rentPerSqft;
	}

	public Date getLeasedDate() {

		return leasedDate;
	}

	public void setLeasedDate(Date leasedDate) {

		this.leasedDate = leasedDate;
	}
}
