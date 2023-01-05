package com.sparc.lams_service.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name = "LeaseCaseHistory")
@Data
public class LeaseCaseHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "vilCode")
	private int vilCode;
	
	@Column(name = "landClass",length = 50)
	private String landClass;
	
	@Column(name = "leaseCase",length = 50)
	private String leaseCase;
	
	@Column(name = "acqStage",length = 50)
	private String acqStage;
	
	@Column(name = "acqPhase",length = 50)
	private String acqPhase;
	
	@Column(name = "updatedAt")
	private Date updatedAt;
	
	@Column(name = "updatedBy")
	private int updatedBy;
	
	@Column(name = "remarks",length = 500)
	private String remarks;
	
	@Column(name = "docRef",length = 500)
	private String docRef;
	
	@Column(name = "descrption",length = 500)
	private String descrption;
}
