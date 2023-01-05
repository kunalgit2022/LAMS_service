package com.sparc.lams_service.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "Master_LandClass")
public class Landclass {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "landClass",length = 50)
	private String landClass;
	
	@Column(name = "ownership",length = 50)
	private String ownership;

	public Landclass() {
		
	}
	
	public Landclass(String landClass,String ownership) {
		super();
		this.landClass = landClass;
		this.ownership = ownership;
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getlandClass() {
		return landClass;
	}
	public void setlandClass(String landClass) {
		this.landClass = landClass;
	}
	public String getownership() {
		return ownership;
	}
	public void setownership(String ownership) {
		this.ownership = ownership;
	}
}
