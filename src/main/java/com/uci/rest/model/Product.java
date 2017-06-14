package com.uci.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

public class Product {
	private int id;
	private String productname;
	private String productprice;
	private String productpicture;
	private String brand;
	private String color;
	private String framematerial;
	private String lensmaterial;
	private String fit;
	private String style;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productname;
	}
	public void setProductName(String productname) {
		this.productname = productname;
	}
	public String getProductPrice() {
		return productprice;
	}
	public void setProductPrice(String productprice) {
		this.productprice = productprice;
	}
	public String getProductPicture() {
		return productpicture;
	}
	public void setProductPicture(String productpicture) {
		this.productpicture = productpicture;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getFrameMaterial() {
		return framematerial;
	}
	public void setFrameMaterial(String framematerial) {
		this.framematerial = framematerial;
	}
	public String getLensMaterial() {
		return lensmaterial;
	}
	public void setLensMaterial(String lensmaterial) {
		this.lensmaterial = lensmaterial;
	}
	public String getFit() {
		return fit;
	}
	public void setFit(String fit) {
		this.fit = fit;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}


	
	
}
