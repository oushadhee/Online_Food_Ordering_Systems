package com.admin.model;

public class Person {
	
	private int id;
	private String userName;
    private String password;
    private String address;
    
    
	public Person(int id, String userName, String password, String address) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.address = address;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
    
    
    
}
