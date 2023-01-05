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
@Table(name = "Incident_History")
@Data
public class Incident {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "title",length = 200)
	private String title;
	
	@Column(name = "description",length = 5000)
	private String description;
	
	@Column(name = "refDoc1",length = 400)
	private String refDoc1;
	
	@Column(name = "refDoc2",length = 400)
	private String acqPhase;
	
	@Column(name = "leaseCase",length = 50)
	private String leaseCase;
	
	@Column(name = "raisedOn")
	private Date raisedOn;
	
	@Column(name = "resolvedOn")
	private int resolvedOn;
	
	@Column(name = "raisedBy")
	private int raisedBy;
}
