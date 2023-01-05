package com.sparc.lams_service.entity;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;


import javax.persistence.Table;



@Entity
@Table(name = "LeasecaseVillageLink")
public class LeaseCaseVillageLink {
	@Id
	@Column(name = "leaseCaseno",length = 80)
	private String leaseCaseno;
	
	@Column(name = "landClass",length = 50)
	private String landClass;
	

	
	@Column(name = "vilCode")
	private int vilCode;
	

	@Column(name = "curStage",length = 50)
	private String curStage;
	
	@Column(name = "curPhase",length = 50)
	private String curPhase;
	
	@Column(name = "startDate")
	private String startDate;
	
	@Column(name = "docRef",length = 500)
	private String docRef;
	
	@Column(name = "lastUpdated")
	private String lastUpdated;
	
	public LeaseCaseVillageLink() {
		
	}
	
	public LeaseCaseVillageLink(String leaseCaseno,String landClass,int vilCode,String curStage,String curPhase,String startDate,String docRef,String lastUpdated) {
		super();
		
		this.leaseCaseno = leaseCaseno;
		this.landClass = landClass;
		this.vilCode = vilCode;
		this.curStage = curStage;
		this.curPhase = curPhase;
		this.startDate = startDate;
		this.docRef = docRef;
		this.lastUpdated = lastUpdated;
	}
	public String getleaseCaseno() {
		return leaseCaseno;
	}
	public void setleaseCaseno(String leaseCaseno) {
		this.leaseCaseno = leaseCaseno;
	}
	public String getlandClass() {
		return landClass;
	}
	public void setlandClass(String landClass) {
		this.landClass = landClass;
	}
	public int getVilCode() {
		return vilCode;
	}
	public void setVilCode(int vilCode) {
		this.vilCode = vilCode;
	}
	public String getcurStage() {
		return curStage;
	}
	public void setcurStage(String curStage) {
		this.curStage = curStage;
	}
	public String getcurPhase() {
		return curPhase;
	}
	public void setcurPhase(String curPhase) {
		this.curPhase = curPhase;
	}
	public String getstartDate() {
		return startDate;
	}
	public void setstartDate(String startDate) {
		this.startDate =startDate;
	}
	public String getdocRef() {
		return docRef;
	}
	public void setdocRef(String docRef) {
		this.docRef = docRef;
	}
	public String getlastUpdated() {
		return lastUpdated;
	}
	public void setlastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
}
