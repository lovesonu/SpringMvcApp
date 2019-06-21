package com.webmodule.springmvc.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "countryid")
	private int countryid;
	
	@OneToMany(mappedBy = "country")
	@JoinColumn (name = "StateId")
	
	@Column(name = "countryname")
	private String countryname;

	public int getCountryid() {
		return countryid;
	}

	public void setCountryid(int countryid) {
		this.countryid = countryid;
	}

	public String getCountryname() {
		return countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

}
