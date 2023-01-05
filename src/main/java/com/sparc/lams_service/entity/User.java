package com.sparc.lams_service.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "Master_User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "roleId")
	private int roleId;
	

	@Column(name = "deptId")
	private int deptId;
	
	@Column(name = "uName",length = 50)
	private String uName;
	
	@Column(name = "user_id",unique = true)
	private String userId;
	
	@Column(name = "mobile",length = 12)
	private String mobile;
	
	@Column(name = "email",length = 50)
	private String email;
	
	@Column(name = "password",length = 200)
	private String password;
	
	@Column(name = "desg",length = 50)
	private String desg;
	
	@Column(name = "createdAt")
	private Date createdAt;
	
	@Column(name = "updatedAt")
	private Date updatedAt;
	
	
	
	
	
}
