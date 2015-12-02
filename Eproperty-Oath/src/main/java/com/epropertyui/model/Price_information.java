package com.epropertyui.model;


public class Price_information {
	private String auction;

	private String price;

	private String deposit;

	private String rent_frequency;

	private String administration_fee;

	private String price_per_unit_area;

	private String tenure_unexpired_years;

	private String tenure_type;

	private String price_qualifier;

	public String getAuction() {
		return auction;
	}

	public void setAuction(String auction) {
		this.auction = auction;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public String getRent_frequency() {
		return rent_frequency;
	}

	public void setRent_frequency(String rent_frequency) {
		this.rent_frequency = rent_frequency;
	}

	public String getAdministration_fee() {
		return administration_fee;
	}

	public void setAdministration_fee(String administration_fee) {
		this.administration_fee = administration_fee;
	}

	public String getPrice_per_unit_area() {
		return price_per_unit_area;
	}

	public void setPrice_per_unit_area(String price_per_unit_area) {
		this.price_per_unit_area = price_per_unit_area;
	}

	public String getTenure_unexpired_years() {
		return tenure_unexpired_years;
	}

	public void setTenure_unexpired_years(String tenure_unexpired_years) {
		this.tenure_unexpired_years = tenure_unexpired_years;
	}

	public String getTenure_type() {
		return tenure_type;
	}

	public void setTenure_type(String tenure_type) {
		this.tenure_type = tenure_type;
	}

	public String getPrice_qualifier() {
		return price_qualifier;
	}

	public void setPrice_qualifier(String price_qualifier) {
		this.price_qualifier = price_qualifier;
	}

	@Override
	public String toString() {
		return "ClassPojo [auction = " + auction + ", price = " + price
				+ ", deposit = " + deposit + ", rent_frequency = "
				+ rent_frequency + ", administration_fee = "
				+ administration_fee + ", price_per_unit_area = "
				+ price_per_unit_area + ", tenure_unexpired_years = "
				+ tenure_unexpired_years + ", tenure_type = " + tenure_type
				+ ", price_qualifier = " + price_qualifier + "]";
	}
}