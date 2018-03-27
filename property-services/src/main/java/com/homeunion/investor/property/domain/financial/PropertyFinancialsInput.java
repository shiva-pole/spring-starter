
package com.homeunion.investor.property.domain.financial;

import java.util.Date;

public class PropertyFinancialsInput {

	private String hil;
	private String source;
	private String propertyType;
	private int propertyTypeCode;
	private double price;
	private double rehabCost;
	private double rent;
	private double tax;
	private double insuranceOccupied;
	private double insuranceVacant;
	private double hoa;
	private double zillowAppreciation;
	private Date calculationFreezeDate;
	private String zip;
	private String nir;

	public String getHil() {

		return hil;
	}

	public void setHil(String hil) {

		this.hil = hil;
	}

	public String getSource() {

		return source;
	}

	public void setSource(String source) {

		this.source = source;
	}

	public String getPropertyType() {

		return propertyType;
	}

	public void setPropertyType(String propertyType) {

		this.propertyType = propertyType;
	}

	public int getPropertyTypeCode() {

		return propertyTypeCode;
	}

	public void setPropertyTypeCode(int propertyTypeCode) {

		this.propertyTypeCode = propertyTypeCode;
	}

	public double getPrice() {

		return price;
	}

	public void setPrice(double price) {

		this.price = price;
	}

	public double getRehabCost() {

		return rehabCost;
	}

	public void setRehabCost(double rehabCost) {

		this.rehabCost = rehabCost;
	}

	public double getRent() {

		return rent;
	}

	public void setRent(double rent) {

		this.rent = rent;
	}

	public double getTax() {

		return tax;
	}

	public void setTax(double tax) {

		this.tax = tax;
	}

	public double getInsuranceOccupied() {

		return insuranceOccupied;
	}

	public void setInsuranceOccupied(double insuranceOccupied) {

		this.insuranceOccupied = insuranceOccupied;
	}

	public double getInsuranceVacant() {

		return insuranceVacant;
	}

	public void setInsuranceVacant(double insuranceVacant) {

		this.insuranceVacant = insuranceVacant;
	}

	public double getHoa() {

		return hoa;
	}

	public void setHoa(double hoa) {

		this.hoa = hoa;
	}

	public double getZillowAppreciation() {

		return zillowAppreciation;
	}

	public void setZillowAppreciation(double zillowAppreciation) {

		this.zillowAppreciation = zillowAppreciation;
	}

	public Date getCalculationFreezeDate() {

		return calculationFreezeDate;
	}

	public void setCalculationFreezeDate(Date calculationFreezeDate) {

		this.calculationFreezeDate = calculationFreezeDate;
	}

	public String getZip() {

		return zip;
	}

	public void setZip(String zip) {

		this.zip = zip;
	}

	public String getNir() {

		return nir;
	}

	public void setNir(String nir) {

		this.nir = nir;
	}
}
