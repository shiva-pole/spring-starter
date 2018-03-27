
package com.homeunion.investor.property.domain.financial;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MarketNirAssumptions", description = "The market place x nir assumptions for rental growth rate, appreciation rate and vacancy percent")
public class MarketNirAssumptions {

	@ApiModelProperty(value = "The zip of property.")
	private String zip;
	@ApiModelProperty(value = "The HU Market Place of the property")
	private String huMarketPlace;
	@ApiModelProperty(value = "The neighborhood investment rating the property's neighborhood")
	private String nir;
	@ApiModelProperty(value = "The year-on-year rental growth rate for 1-5 years")
	private Double rentalGrowthRate;
	@ApiModelProperty(value = "The year-on-year appreciation in property's price for 1-5 years")
	private Double appreciationRate;
	@ApiModelProperty(value = "The yearly vacancy as a percent of rental income")
	private Double vacancyPercent;

	public String getZip() {

		return zip;
	}

	public void setZip(String zip) {

		this.zip = zip;
	}

	public String getHuMarketPlace() {

		return huMarketPlace;
	}

	public void setHuMarketPlace(String huMarketPlace) {

		this.huMarketPlace = huMarketPlace;
	}

	public String getNir() {

		return nir;
	}

	public void setNir(String nir) {

		this.nir = nir;
	}

	public Double getRentalGrowthRate() {

		return rentalGrowthRate;
	}

	public void setRentalGrowthRate(Double rentalGrowthRate) {

		this.rentalGrowthRate = rentalGrowthRate;
	}

	public Double getAppreciationRate() {

		return appreciationRate;
	}

	public void setAppreciationRate(Double appreciationRate) {

		this.appreciationRate = appreciationRate;
	}

	public Double getVacancyPercent() {

		return vacancyPercent;
	}

	public void setVacancyPercent(Double vacancyPercent) {

		this.vacancyPercent = vacancyPercent;
	}
}
