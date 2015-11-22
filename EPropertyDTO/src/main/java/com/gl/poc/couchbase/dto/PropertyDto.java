package com.gl.poc.couchbase.dto;

import java.util.List;
import java.util.Map;

public class PropertyDto {

	String agentRef;
	boolean published;
	int propertyType;
	boolean status;
	boolean newHome;
	boolean studentProperty;
	String createDate;
	String updateDate;
	String dateAvailable;
	int contractMonth;
	int minimumTerm;
	int letType;
	Address address;
	PriceInformation priceInformation;
	

	public String getAgentRef() {
		return agentRef;
	}

	public void setAgentRef(String agentRef) {
		this.agentRef = agentRef;
	}

	public int getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(int propertyType) {
		this.propertyType = propertyType;
	}

	public boolean isNewHome() {
		return newHome;
	}

	public void setNewHome(boolean newHome) {
		this.newHome = newHome;
	}

	public boolean isStudentProperty() {
		return studentProperty;
	}

	public void setStudentProperty(boolean studentProperty) {
		this.studentProperty = studentProperty;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getDateAvailable() {
		return dateAvailable;
	}

	public void setDateAvailable(String dateAvailable) {
		this.dateAvailable = dateAvailable;
	}

	public int getContractMonth() {
		return contractMonth;
	}

	public void setContractMonth(int contractMonth) {
		this.contractMonth = contractMonth;
	}

	public int getMinimumTerm() {
		return minimumTerm;
	}

	public void setMinimumTerm(int minimumTerm) {
		this.minimumTerm = minimumTerm;
	}

	public int getLetType() {
		return letType;
	}

	public void setLetType(int letType) {
		this.letType = letType;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}

 class Address {
	
	String houseNameNumber;
	String address_2;
	String address_3;
	String address_4;
	String town;
	String postcode_1;
	String postcode_2;
	String displayAddress;
	float latitude;
	float longitude;
	float pov_latitude;
	float pov_longitude;
	float pov_pitch;
	float pov_heading;
	float pov_zoom;

}

class PriceInformation {

	Long price;
	int price_qualifier;
	long deposit;
	long administration_fee;
	int rent_frequency;
	int tenure_type;
	boolean auction;
	long tenure_unexpired_years;
	long price_per_unit_area;
}
class Detail {

String summary; 
String description;
private Map<String List<String>> featureList;
int parking [];
 int outside_space [];
int year_built;
int internal_area;
int internal_area_unit; 
int land_area;
int land_area_unit; 
int floors; 
int entrance_floor;
int condition;
int accessibility[];
int heating [];
int furnished_type;
boolean pets_allowed;
boolean smokers_considered;
boolean housing_benefit_considered;
boolean sharers_considered;
boolean burglar_alarm;
boolean washing_machine;
boolean dishwasher;
boolean all_bills_inc;
boolean water_bill_inc;
boolean gas_bill_inc;
boolean electricity_bill_inc;
boolean tv_licence_inc;
boolean sat_cable_tv_bill_inc;
boolean internet_bill_inc;
boolean business_for_sale;
int comm_use_class[];
String Room;

}

class Media {
	int media_type1;
	String media_url;
	String caption;
	int sort_order1;
	String media_update_date;
}

class Principle {
	String principal_email_address;
	boolean auto_email_when_live;
	boolean auto_email_updates;
}








