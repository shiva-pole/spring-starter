
package com.homeunion.investor.property.domain.comps;

import java.util.List;

public class CompsAggregatedInfo {

	private String mlsName;
	private String mlsNumber;
	private List<String> priceCompsList;
	private String soldCompsPath;
	private Double compsPrice;
	private Double avgCompPricePerSqft;
	private Double minPrice;
	private Double maxPrice;
	private List<String> rentCompsList;
	private String rentCompsPath;
	private Double compsRent;
	private Double avgComprentPerSqft;
	private Double minRent;
	private Double maxRent;

	public String getMlsName() {

		return mlsName;
	}

	public void setMlsName(String mlsName) {

		this.mlsName = mlsName;
	}

	public String getMlsNumber() {

		return mlsNumber;
	}

	public void setMlsNumber(String mlsNumber) {

		this.mlsNumber = mlsNumber;
	}

	public List<String> getPriceCompsList() {

		return priceCompsList;
	}

	public void setPriceCompsList(List<String> priceCompsList) {

		this.priceCompsList = priceCompsList;
	}

	public String getSoldCompsPath() {

		return soldCompsPath;
	}

	public void setSoldCompsPath(String soldCompsPath) {

		this.soldCompsPath = soldCompsPath;
	}

	public Double getCompsPrice() {

		return compsPrice;
	}

	public void setCompsPrice(Double compsPrice) {

		this.compsPrice = compsPrice;
	}

	public Double getAvgCompPricePerSqft() {

		return avgCompPricePerSqft;
	}

	public void setAvgCompPricePerSqft(Double avgCompPricePerSqft) {

		this.avgCompPricePerSqft = avgCompPricePerSqft;
	}

	public Double getMinPrice() {

		return minPrice;
	}

	public void setMinPrice(Double minPrice) {

		this.minPrice = minPrice;
	}

	public Double getMaxPrice() {

		return maxPrice;
	}

	public void setMaxPrice(Double maxPrice) {

		this.maxPrice = maxPrice;
	}

	public List<String> getRentCompsList() {

		return rentCompsList;
	}

	public void setRentCompsList(List<String> rentCompsList) {

		this.rentCompsList = rentCompsList;
	}

	public String getRentCompsPath() {

		return rentCompsPath;
	}

	public void setRentCompsPath(String rentCompsPath) {

		this.rentCompsPath = rentCompsPath;
	}

	public Double getCompsRent() {

		return compsRent;
	}

	public void setCompsRent(Double compsRent) {

		this.compsRent = compsRent;
	}

	public Double getAvgComprentPerSqft() {

		return avgComprentPerSqft;
	}

	public void setAvgComprentPerSqft(Double avgComprentPerSqft) {

		this.avgComprentPerSqft = avgComprentPerSqft;
	}

	public Double getMinRent() {

		return minRent;
	}

	public void setMinRent(Double minRent) {

		this.minRent = minRent;
	}

	public Double getMaxRent() {

		return maxRent;
	}

	public void setMaxRent(Double maxRent) {

		this.maxRent = maxRent;
	}
}
