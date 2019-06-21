package com.webmodule.springmvc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "admin")
public class Admin implements Serializable {
	
	private static final long serialVersionUID = 453693552059515150L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String phone;
	 @Column(unique = true)
	private String username;
	@Column
	private String password;
	@Column
	private String country;
	@Column
	private String state;
	@Column
	private String city;
	@Column
	private String area;
	@Column
	@Size(min=5, max=6)
	private long pincode;

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public Admin() {
		super();
	}

	public Admin(int id, String name, String email, String username, String password, String phone, String city,
			String state, String country, String area,long pincode) {
		super();
		System.out.println("Admin class from model ");
		this.id = id;
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.country = country;
		this.state = state;
		this.city = city;
		this.area = area;
		this.pincode = pincode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", username=" + username + ", password="
				+ password + ", phone=" + phone + ", city=" + city + ", state=" + state + ", country=" + country + " ]";
	}
}
