package com.sparc.lams_service.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name = "Master_Village")
public class Village {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "district",length = 50)
	private String district;
	
	@Column(name = "tehsil",length = 50)
	private String tehsil;
	
	@Column(name = "village",length = 50)
	private String village;
	
	@Column(name = "ric",length = 50)
	private String ric;
	
	@Column(name = "thanaNo")
	private int thanaNo;
	
	@Column(name = "thanaName",length = 50)
	private String thanaName;
	
	@Column(name = "phase",length = 50)
	private String phase;
	
	public Village() {
		
	}
	
	public Village(String district,String tehsil,String village,String ric,int thanaNo,String thanaName,String phase) {
		super();
		this.district = district;
		this.tehsil = tehsil;
		this.village = village;
		this.ric = ric;
		this.thanaNo = thanaNo;
		this.thanaName = thanaName;
		this.phase = phase;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getTehsil() {
		return tehsil;
	}
	public void setTehsil(String tehsil) {
		this.tehsil = tehsil;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getric() {
		return ric;
	}
	public void setric(String ric) {
		this.ric = ric;
	}
	public int getthanaNo() {
		return thanaNo;
	}
	public void setthanaNo(int thanaNo) {
		this.thanaNo = thanaNo;
	}
	public String getthanaName() {
		return thanaName;
	}
	public void setthanaName(String thanaName) {
		this.thanaName = thanaName;
	}
	public String getphase() {
		return phase;
	}
	public void setphase(String phase) {
		this.phase = phase;
	}
}
