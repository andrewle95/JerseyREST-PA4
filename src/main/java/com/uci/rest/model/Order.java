package com.uci.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

public class Order {
	private String firstname;
    private String lastname;
    private String phonenumber;
    private String streetaddress;
    private String city;
    private String state;
    private String zipcode;
    private String creditcardnumber;
    private String items;
    private String shippingmethod;
    private int id;
    
	public String getFirstName() {
		return firstname;
	}
	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	public String getLastName() {
		return lastname;
	}
	public void setLastName(String lastname) {
		this.lastname = lastname;
	}
	public String getPhoneNumber() {
		return phonenumber;
	}
	public void setPhoneNumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getStreetAddress() {
		return streetaddress;
	}
	public void setStreetAddress(String streetaddress) {
		this.streetaddress = streetaddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipcode;
	}
	public void setZipCode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCreditCardNumber() {
		return creditcardnumber;
	}
	public void setCreditCardNumber(String creditcardnumber) {
		this.creditcardnumber = creditcardnumber;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public String getShippingMethod() {
		return shippingmethod;
	}
	public void setShippingMethod(String shippingmethod) {
		this.shippingmethod = shippingmethod;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
