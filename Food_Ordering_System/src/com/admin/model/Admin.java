package com.admin.model;

public class Admin extends Person{

     private String hotelname;

	public Admin(int id, String userName, String password, String address, String hotelname) {
		super(id, userName, password, address);
		this.hotelname = hotelname;
	}

	public String getHotelname() {
		return hotelname;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	
}   
	