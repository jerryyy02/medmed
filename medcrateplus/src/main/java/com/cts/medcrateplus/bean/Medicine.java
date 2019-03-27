package com.cts.medcrateplus.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Medicine")
@Table(name="Medicine")
public class Medicine {
	
	@Id
	@Column(name="medId")
	private String medId;
	private String medName;
	private String saltName;
	private String brand;
	private String status;
	private float price;
	public String getMedId() {
		return medId;
	}
	public void setMedId(String medId) {
		this.medId = medId;
	}
	public String getMedName() {
		return medName;
	}
	public void setMedName(String medName) {
		this.medName = medName;
	}
	public String getSaltName() {
		return saltName;
	}
	public void setSaltName(String saltName) {
		this.saltName = saltName;
	}
	
	public Medicine() {
		// TODO Auto-generated constructor stub
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Medicine [medId=" + medId + ", medName=" + medName + ", saltName=" + saltName + ", brand=" + brand
				+ ", status=" + status + ", price=" + price + "]";
	}
	

}
