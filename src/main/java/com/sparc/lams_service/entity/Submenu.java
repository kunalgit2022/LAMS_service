package com.sparc.lams_service.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Data;

@Entity
@Table(name = "submenu")
@Data
public class Submenu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sid")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "pid")
	private int pid;
	
	@Column(name = "sicon")
	private String sicon;
	
	@Column(name = "seq")
	private String seq;
}
