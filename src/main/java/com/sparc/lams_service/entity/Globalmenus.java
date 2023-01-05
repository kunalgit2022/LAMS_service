package com.sparc.lams_service.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "Global_Link")
public class Globalmenus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "gName",length = 30)
	private String gName;
	
	@Column(name = "gIcon",length = 50)
	private String gIcon;
	
	@Column(name = "seq")
	private int sequence;

	public Globalmenus() {
		
	}
	
	public Globalmenus(String gName,String gIcon,int seq) {
		super();
		this.gName = gName;
		this.gIcon = gIcon;
		this.sequence=seq;
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public String getgIcon() {
		return gName;
	}
	public void setgIcon(String gIcon) {
		this.gIcon = gIcon;
	}
	public int getseq() {
		return sequence;
	}
	public void setseq(int sequence) {
		this.sequence = sequence;
	}
}
