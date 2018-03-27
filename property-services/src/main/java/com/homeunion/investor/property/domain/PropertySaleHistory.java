
package com.homeunion.investor.property.domain;

import java.util.Date;

public class PropertySaleHistory {

	private String propertyId;
	private String investmentId;
	private String assetId;
	private int unitCount;
	private Date lastPurchaseDate;
	private Double lastPurchaseAmount;

	public String getPropertyId() {

		return propertyId;
	}

	public void setPropertyId(String propertyId) {

		this.propertyId = propertyId;
	}

	public String getInvestmentId() {

		return investmentId;
	}

	public void setInvestmentId(String investmentId) {

		this.investmentId = investmentId;
	}

	public String getAssetId() {

		return assetId;
	}

	public void setAssetId(String assetId) {

		this.assetId = assetId;
	}

	public int getUnitCount() {

		return unitCount;
	}

	public void setUnitCount(int unitCount) {

		this.unitCount = unitCount;
	}

	public Date getLastPurchaseDate() {

		return lastPurchaseDate;
	}

	public void setLastPurchaseDate(Date lastPurchaseDate) {

		this.lastPurchaseDate = lastPurchaseDate;
	}

	public Double getLastPurchaseAmount() {

		return lastPurchaseAmount;
	}

	public void setLastPurchaseAmount(Double lastPurchaseAmount) {

		this.lastPurchaseAmount = lastPurchaseAmount;
	}
}
