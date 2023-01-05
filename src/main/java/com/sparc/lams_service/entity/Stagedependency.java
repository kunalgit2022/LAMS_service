package com.sparc.lams_service.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "Stage_Dependency")
public class Stagedependency {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "landClass",length = 50)
	private String landClass;
	
	@Column(name = "stageCode",length = 50)
	private String stageCode;
	
	@Column(name = "dependentCode",length = 50)
	private String dependentCode;
	
	public Stagedependency() {
		
	}
	
	public Stagedependency(String landClass,String stageCode,String dependentCode) {
		super();
		
		this.landClass = landClass;
		this.stageCode = stageCode;
		this.dependentCode = dependentCode;
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
	public String getstageCode() {
		return stageCode;
	}
	public void setstageCode(String stageCode) {
		this.stageCode = stageCode;
	}
	public String getdependentCode() {
		return dependentCode;
	}
	public void setdependentCode(String dependentCode) {
		this.dependentCode = dependentCode;
	}
}
