package com.sparc.lams_service.entity;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "Master_Stage")
public class Stage {
	@Id
	@Column(name = "stageCode",length = 50)
	private String stageCode;
	
	@Column(name = "landClass",length = 50)
	private String landClass;
	
	@Column(name = "stageDesc",length = 1000)
	private String stageDesc;
	
	@Column(name = "duration")
	private int duration;
	
	@Column(name = "phase",length = 20)
	private String phase;
	
	@Column(name = "sequence")
	private int sequence;
	
	@Column(name = "remarks",length = 50)
	private String remarks;
	
	public Stage() {
		
	}
	
	public Stage(String stageCode,String landClass,String stageDesc,int duration,String phase,int sequence,String remarks) {
		super();
		this.stageCode = stageCode;
		this.landClass = landClass;
		this.stageDesc = stageDesc;
		this.duration = duration;
		this.phase = phase;
		this.sequence = sequence;
		this.remarks=remarks;
		
	}
	
	public String getStageCode() {
		return stageCode;
	}
	public void setStageCode(String stageCode) {
		this.stageCode = stageCode;
	}
	public String getlandClass() {
		return landClass;
	}
	public void setlandClass(String landClass) {
		this.landClass = landClass;
	}
	public String getstageDesc() {
		return stageDesc;
	}
	public void setstageDesc(String stageDesc) {
		this.stageDesc = stageDesc;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getphase() {
		return phase;
	}
	public void setphase(String phase) {
		this.phase = phase;
	}
	public int getsequence() {
		return sequence;
	}
	public void setsequence(int sequence) {
		this.sequence = sequence;
	}
	public String getremarks() {
		return remarks;
	}
	public void setremarks(String remarks) {
		this.remarks = remarks;
	}
}
