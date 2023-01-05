package com.sparc.lams_service.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "primary_link")
@Data
public class Primarymenus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "p_icon",length = 100)
	private String picon;
	
	@Column(name = "p_name",length = 100)
	private String pname;
	
	@Column(name = "g_id")
	private long gid;
	
	@Column(name = "seq")
	private int seq;
}
