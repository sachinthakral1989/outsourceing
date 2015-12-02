package com.epropertyui.model;


public class BrokerRequest {

	private Branch branch;
	private Property property;
	private Network network;
	
	public class Property {
		private String minimum_term;
		private String status;
		private String let_type;
		private String date_available;
		private String property_type;
		/*private Principal principal;
		private Details details;*/
		private String create_date;
		/*private Address1 address1;*/
		private String new_home;
		private String agent_ref;
		private String update_date;
		private Price_information price_information;
		private String published;
		private String contract_months;
		/*private Media[] media;*/
		private String student_property;

		public String getMinimum_term() {
			return minimum_term;
		}

		public void setMinimum_term(String minimum_term) {
			this.minimum_term = minimum_term;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getLet_type() {
			return let_type;
		}

		public void setLet_type(String let_type) {
			this.let_type = let_type;
		}

		public String getDate_available() {
			return date_available;
		}

		public void setDate_available(String date_available) {
			this.date_available = date_available;
		}

		public String getProperty_type() {
			return property_type;
		}

		public void setProperty_type(String property_type) {
			this.property_type = property_type;
		}

		/*public Principal getPrincipal() {
			return principal;
		}

		public void setPrincipal(Principal principal) {
			this.principal = principal;
		}

		public Details getDetails() {
			return details;
		}

		public void setDetails(Details details) {
			this.details = details;
		}*/

		public String getCreate_date() {
			return create_date;
		}

		public void setCreate_date(String create_date) {
			this.create_date = create_date;
		}

		/*public Address1 getAddress1() {
			return address1;
		}

		public void setAddress1(Address1 address1) {
			this.address1 = address1;
		}*/

		public String getNew_home() {
			return new_home;
		}

		public void setNew_home(String new_home) {
			this.new_home = new_home;
		}

		public String getAgent_ref() {
			return agent_ref;
		}

		public void setAgent_ref(String agent_ref) {
			this.agent_ref = agent_ref;
		}

		public String getUpdate_date() {
			return update_date;
		}

		public void setUpdate_date(String update_date) {
			this.update_date = update_date;
		}

		/*public Price_information getPrice_information() {
			return price_information;
		}

		public void setPrice_information(Price_information price_information) {
			this.price_information = price_information;
		}*/

		public String getPublished() {
			return published;
		}

		public void setPublished(String published) {
			this.published = published;
		}

		public String getContract_months() {
			return contract_months;
		}

		public void setContract_months(String contract_months) {
			this.contract_months = contract_months;
		}

		/*public Media[] getMedia() {
			return media;
		}

		public void setMedia(Media[] media) {
			this.media = media;
		}*/

		public String getStudent_property() {
			return student_property;
		}

		public void setStudent_property(String student_property) {
			this.student_property = student_property;
		}

		/*@Override
		public String toString() {
			return "ClassPojo [minimum_term = " + minimum_term + ", status = "
					+ status + ", let_type = " + let_type
					+ ", date_available = " + date_available
					+ ", property_type = " + property_type + ", principal = "
					+ principal + ", details = " + details + ", create_date = "
					+ create_date + ", address1 = " + address1 + ", new_home = "
					+ new_home + ", agent_ref = " + agent_ref
					+ ", update_date = " + update_date
					+ ", price_information = " + price_information
					+ ", published = " + published + ", contract_months = "
					+ contract_months + ", media = " + media
					+ ", student_property = " + student_property + "]";
		}*/
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public Network getNetwork() {
		return network;
	}

	public void setNetwork(Network network) {
		this.network = network;
	}

	@Override
	public String toString() {
		return "ClassPojo [branch = " + branch + ", property = " + property
				+ ", network = " + network + "]";
	}

	

	public class Branch {
		private String overseas;
		private String channel;
		private String branch_id;

		public String getOverseas() {
			return overseas;
		}

		public void setOverseas(String overseas) {
			this.overseas = overseas;
		}

		public String getChannel() {
			return channel;
		}

		public void setChannel(String channel) {
			this.channel = channel;
		}

		public String getBranch_id() {
			return branch_id;
		}

		public void setBranch_id(String branch_id) {
			this.branch_id = branch_id;
		}

		@Override
		public String toString() {
			return "ClassPojo [overseas = " + overseas + ", channel = "
					+ channel + ", branch_id = " + branch_id + "]";
		}
	}

	public class Principal {

		private String principal_email_address;
		private String auto_email_when_live;
		private String auto_email_updates;

		public String getPrincipal_email_address() {
			return principal_email_address;
		}

		public void setPrincipal_email_address(String principal_email_address) {
			this.principal_email_address = principal_email_address;
		}

		public String getAuto_email_when_live() {
			return auto_email_when_live;
		}

		public void setAuto_email_when_live(String auto_email_when_live) {
			this.auto_email_when_live = auto_email_when_live;
		}

		public String getAuto_email_updates() {
			return auto_email_updates;
		}

		public void setAuto_email_updates(String auto_email_updates) {
			this.auto_email_updates = auto_email_updates;
		}

		@Override
		public String toString() {
			return "ClassPojo [principal_email_address = "
					+ principal_email_address + ", auto_email_when_live = "
					+ auto_email_when_live + ", auto_email_updates = "
					+ auto_email_updates + "]";
		}
	}

	public class Details {
		private String summary;

		private String[] parking;

		private String[] comm_use_class;

		private String bathrooms;

		private String furnished_type;

		private String pets_allowed;

		private String all_bills_inc;

		private String internal_area;

		private String water_bill_inc;

		private String electricity_bill_inc;

		private String floors;

		private String description;

		private String reception_rooms;

		private String[] features;

		private String tv_licence_inc;

		private String smokers_considered;

		private String dishwasher;

		private String entrance_floor;

		private Rooms[] rooms;

		private String[] accessibility;

		private String year_built;

		private String condition;

		private String land_area;

		private String land_area_unit;

		private String bedrooms;

		private String sat_cable_tv_bill_inc;

		private String internal_area_unit;

		private String internet_bill_inc;

		private String[] outside_space;

		private String housing_benefit_considered;

		private String[] heating;

		private String gas_bill_inc;

		private String business_for_sale;

		private String burglar_alarm;

		private String sharers_considered;

		private String washing_machine;

		public String getSummary() {
			return summary;
		}

		public void setSummary(String summary) {
			this.summary = summary;
		}

		public String[] getParking() {
			return parking;
		}

		public void setParking(String[] parking) {
			this.parking = parking;
		}

		public String[] getComm_use_class() {
			return comm_use_class;
		}

		public void setComm_use_class(String[] comm_use_class) {
			this.comm_use_class = comm_use_class;
		}

		public String getBathrooms() {
			return bathrooms;
		}

		public void setBathrooms(String bathrooms) {
			this.bathrooms = bathrooms;
		}

		public String getFurnished_type() {
			return furnished_type;
		}

		public void setFurnished_type(String furnished_type) {
			this.furnished_type = furnished_type;
		}

		public String getPets_allowed() {
			return pets_allowed;
		}

		public void setPets_allowed(String pets_allowed) {
			this.pets_allowed = pets_allowed;
		}

		public String getAll_bills_inc() {
			return all_bills_inc;
		}

		public void setAll_bills_inc(String all_bills_inc) {
			this.all_bills_inc = all_bills_inc;
		}

		public String getInternal_area() {
			return internal_area;
		}

		public void setInternal_area(String internal_area) {
			this.internal_area = internal_area;
		}

		public String getWater_bill_inc() {
			return water_bill_inc;
		}

		public void setWater_bill_inc(String water_bill_inc) {
			this.water_bill_inc = water_bill_inc;
		}

		public String getElectricity_bill_inc() {
			return electricity_bill_inc;
		}

		public void setElectricity_bill_inc(String electricity_bill_inc) {
			this.electricity_bill_inc = electricity_bill_inc;
		}

		public String getFloors() {
			return floors;
		}

		public void setFloors(String floors) {
			this.floors = floors;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getReception_rooms() {
			return reception_rooms;
		}

		public void setReception_rooms(String reception_rooms) {
			this.reception_rooms = reception_rooms;
		}

		public String[] getFeatures() {
			return features;
		}

		public void setFeatures(String[] features) {
			this.features = features;
		}

		public String getTv_licence_inc() {
			return tv_licence_inc;
		}

		public void setTv_licence_inc(String tv_licence_inc) {
			this.tv_licence_inc = tv_licence_inc;
		}

		public String getSmokers_considered() {
			return smokers_considered;
		}

		public void setSmokers_considered(String smokers_considered) {
			this.smokers_considered = smokers_considered;
		}

		public String getDishwasher() {
			return dishwasher;
		}

		public void setDishwasher(String dishwasher) {
			this.dishwasher = dishwasher;
		}

		public String getEntrance_floor() {
			return entrance_floor;
		}

		public void setEntrance_floor(String entrance_floor) {
			this.entrance_floor = entrance_floor;
		}

		public Rooms[] getRooms() {
			return rooms;
		}

		public void setRooms(Rooms[] rooms) {
			this.rooms = rooms;
		}

		public String[] getAccessibility() {
			return accessibility;
		}

		public void setAccessibility(String[] accessibility) {
			this.accessibility = accessibility;
		}

		public String getYear_built() {
			return year_built;
		}

		public void setYear_built(String year_built) {
			this.year_built = year_built;
		}

		public String getCondition() {
			return condition;
		}

		public void setCondition(String condition) {
			this.condition = condition;
		}

		public String getLand_area() {
			return land_area;
		}

		public void setLand_area(String land_area) {
			this.land_area = land_area;
		}

		public String getLand_area_unit() {
			return land_area_unit;
		}

		public void setLand_area_unit(String land_area_unit) {
			this.land_area_unit = land_area_unit;
		}

		public String getBedrooms() {
			return bedrooms;
		}

		public void setBedrooms(String bedrooms) {
			this.bedrooms = bedrooms;
		}

		public String getSat_cable_tv_bill_inc() {
			return sat_cable_tv_bill_inc;
		}

		public void setSat_cable_tv_bill_inc(String sat_cable_tv_bill_inc) {
			this.sat_cable_tv_bill_inc = sat_cable_tv_bill_inc;
		}

		public String getInternal_area_unit() {
			return internal_area_unit;
		}

		public void setInternal_area_unit(String internal_area_unit) {
			this.internal_area_unit = internal_area_unit;
		}

		public String getInternet_bill_inc() {
			return internet_bill_inc;
		}

		public void setInternet_bill_inc(String internet_bill_inc) {
			this.internet_bill_inc = internet_bill_inc;
		}

		public String[] getOutside_space() {
			return outside_space;
		}

		public void setOutside_space(String[] outside_space) {
			this.outside_space = outside_space;
		}

		public String getHousing_benefit_considered() {
			return housing_benefit_considered;
		}

		public void setHousing_benefit_considered(
				String housing_benefit_considered) {
			this.housing_benefit_considered = housing_benefit_considered;
		}

		public String[] getHeating() {
			return heating;
		}

		public void setHeating(String[] heating) {
			this.heating = heating;
		}

		public String getGas_bill_inc() {
			return gas_bill_inc;
		}

		public void setGas_bill_inc(String gas_bill_inc) {
			this.gas_bill_inc = gas_bill_inc;
		}

		public String getBusiness_for_sale() {
			return business_for_sale;
		}

		public void setBusiness_for_sale(String business_for_sale) {
			this.business_for_sale = business_for_sale;
		}

		public String getBurglar_alarm() {
			return burglar_alarm;
		}

		public void setBurglar_alarm(String burglar_alarm) {
			this.burglar_alarm = burglar_alarm;
		}

		public String getSharers_considered() {
			return sharers_considered;
		}

		public void setSharers_considered(String sharers_considered) {
			this.sharers_considered = sharers_considered;
		}

		public String getWashing_machine() {
			return washing_machine;
		}

		public void setWashing_machine(String washing_machine) {
			this.washing_machine = washing_machine;
		}

		@Override
		public String toString() {
			return "ClassPojo [summary = " + summary + ", parking = " + parking
					+ ", comm_use_class = " + comm_use_class + ", bathrooms = "
					+ bathrooms + ", furnished_type = " + furnished_type
					+ ", pets_allowed = " + pets_allowed + ", all_bills_inc = "
					+ all_bills_inc + ", internal_area = " + internal_area
					+ ", water_bill_inc = " + water_bill_inc
					+ ", electricity_bill_inc = " + electricity_bill_inc
					+ ", floors = " + floors + ", description = " + description
					+ ", reception_rooms = " + reception_rooms
					+ ", features = " + features + ", tv_licence_inc = "
					+ tv_licence_inc + ", smokers_considered = "
					+ smokers_considered + ", dishwasher = " + dishwasher
					+ ", entrance_floor = " + entrance_floor + ", rooms = "
					+ rooms + ", accessibility = " + accessibility
					+ ", year_built = " + year_built + ", condition = "
					+ condition + ", land_area = " + land_area
					+ ", land_area_unit = " + land_area_unit + ", bedrooms = "
					+ bedrooms + ", sat_cable_tv_bill_inc = "
					+ sat_cable_tv_bill_inc + ", internal_area_unit = "
					+ internal_area_unit + ", internet_bill_inc = "
					+ internet_bill_inc + ", outside_space = " + outside_space
					+ ", housing_benefit_considered = "
					+ housing_benefit_considered + ", heating = " + heating
					+ ", gas_bill_inc = " + gas_bill_inc
					+ ", business_for_sale = " + business_for_sale
					+ ", burglar_alarm = " + burglar_alarm
					+ ", sharers_considered = " + sharers_considered
					+ ", washing_machine = " + washing_machine + "]";
		}
	}

	public class Address1 {
		private String postcode_2;

		private String postcode_1;

		private String address_3;

		private String address_4;

		private String pov_heading;

		private String pov_latitude;

		private String house_name_number;

		private String address_2;

		private String pov_pitch;

		private String pov_longitude;

		private String display_address;

		private String pov_zoom;

		private String longitude;

		private String town;

		private String latitude;

		public String getPostcode_2() {
			return postcode_2;
		}

		public void setPostcode_2(String postcode_2) {
			this.postcode_2 = postcode_2;
		}

		public String getPostcode_1() {
			return postcode_1;
		}

		public void setPostcode_1(String postcode_1) {
			this.postcode_1 = postcode_1;
		}

		public String getAddress_3() {
			return address_3;
		}

		public void setAddress_3(String address_3) {
			this.address_3 = address_3;
		}

		public String getAddress_4() {
			return address_4;
		}

		public void setAddress_4(String address_4) {
			this.address_4 = address_4;
		}

		public String getPov_heading() {
			return pov_heading;
		}

		public void setPov_heading(String pov_heading) {
			this.pov_heading = pov_heading;
		}

		public String getPov_latitude() {
			return pov_latitude;
		}

		public void setPov_latitude(String pov_latitude) {
			this.pov_latitude = pov_latitude;
		}

		public String getHouse_name_number() {
			return house_name_number;
		}

		public void setHouse_name_number(String house_name_number) {
			this.house_name_number = house_name_number;
		}

		public String getAddress_2() {
			return address_2;
		}

		public void setAddress_2(String address_2) {
			this.address_2 = address_2;
		}

		public String getPov_pitch() {
			return pov_pitch;
		}

		public void setPov_pitch(String pov_pitch) {
			this.pov_pitch = pov_pitch;
		}

		public String getPov_longitude() {
			return pov_longitude;
		}

		public void setPov_longitude(String pov_longitude) {
			this.pov_longitude = pov_longitude;
		}

		public String getDisplay_address() {
			return display_address;
		}

		public void setDisplay_address(String display_address) {
			this.display_address = display_address;
		}

		public String getPov_zoom() {
			return pov_zoom;
		}

		public void setPov_zoom(String pov_zoom) {
			this.pov_zoom = pov_zoom;
		}

		public String getLongitude() {
			return longitude;
		}

		public void setLongitude(String longitude) {
			this.longitude = longitude;
		}

		public String getTown() {
			return town;
		}

		public void setTown(String town) {
			this.town = town;
		}

		public String getLatitude() {
			return latitude;
		}

		public void setLatitude(String latitude) {
			this.latitude = latitude;
		}

		@Override
		public String toString() {
			return "ClassPojo [postcode_2 = " + postcode_2 + ", postcode_1 = "
					+ postcode_1 + ", address_3 = " + address_3
					+ ", address_4 = " + address_4 + ", pov_heading = "
					+ pov_heading + ", pov_latitude = " + pov_latitude
					+ ", house_name_number = " + house_name_number
					+ ", address_2 = " + address_2 + ", pov_pitch = "
					+ pov_pitch + ", pov_longitude = " + pov_longitude
					+ ", display_address = " + display_address
					+ ", pov_zoom = " + pov_zoom + ", longitude = " + longitude
					+ ", town = " + town + ", latitude = " + latitude + "]";
		}
	}

	public class Rooms {
		private String room_description;

		private String room_name;

		private String room_length;

		private String[] room_photo_urls;

		private String room_dimension_unit;

		private String room_width;

		public String getRoom_description() {
			return room_description;
		}

		public void setRoom_description(String room_description) {
			this.room_description = room_description;
		}

		public String getRoom_name() {
			return room_name;
		}

		public void setRoom_name(String room_name) {
			this.room_name = room_name;
		}

		public String getRoom_length() {
			return room_length;
		}

		public void setRoom_length(String room_length) {
			this.room_length = room_length;
		}

		public String[] getRoom_photo_urls() {
			return room_photo_urls;
		}

		public void setRoom_photo_urls(String[] room_photo_urls) {
			this.room_photo_urls = room_photo_urls;
		}

		public String getRoom_dimension_unit() {
			return room_dimension_unit;
		}

		public void setRoom_dimension_unit(String room_dimension_unit) {
			this.room_dimension_unit = room_dimension_unit;
		}

		public String getRoom_width() {
			return room_width;
		}

		public void setRoom_width(String room_width) {
			this.room_width = room_width;
		}

		@Override
		public String toString() {
			return "ClassPojo [room_description = " + room_description
					+ ", room_name = " + room_name + ", room_length = "
					+ room_length + ", room_photo_urls = " + room_photo_urls
					+ ", room_dimension_unit = " + room_dimension_unit
					+ ", room_width = " + room_width + "]";
		}
	}

	

	public class Media {
		private String media_update_date;

		private String media_type;

		private String media_url;

		private String caption;

		private String sort_order;

		public String getMedia_update_date() {
			return media_update_date;
		}

		public void setMedia_update_date(String media_update_date) {
			this.media_update_date = media_update_date;
		}

		public String getMedia_type() {
			return media_type;
		}

		public void setMedia_type(String media_type) {
			this.media_type = media_type;
		}

		public String getMedia_url() {
			return media_url;
		}

		public void setMedia_url(String media_url) {
			this.media_url = media_url;
		}

		public String getCaption() {
			return caption;
		}

		public void setCaption(String caption) {
			this.caption = caption;
		}

		public String getSort_order() {
			return sort_order;
		}

		public void setSort_order(String sort_order) {
			this.sort_order = sort_order;
		}

		@Override
		public String toString() {
			return "ClassPojo [media_update_date = " + media_update_date
					+ ", media_type = " + media_type + ", media_url = "
					+ media_url + ", caption = " + caption + ", sort_order = "
					+ sort_order + "]";
		}
	}

	public class Network {
		private String network_id;

		public String getNetwork_id() {
			return network_id;
		}

		public void setNetwork_id(String network_id) {
			this.network_id = network_id;
		}

		@Override
		public String toString() {
			return "ClassPojo [network_id = " + network_id + "]";
		}
	}
}