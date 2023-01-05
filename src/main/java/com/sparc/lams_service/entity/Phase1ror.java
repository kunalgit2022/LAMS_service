package com.sparc.lams_service.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Data;

@Entity
@Table(name = "amns_phase1_4578_ror_final")
@Data
public class Phase1ror {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gid")
	private long gid;
	
	@Column(name = "remark",length = 500)
	private String remark;
	
	@Column(name = "reqareaac")
	private double reqareaac;
	
	@Column(name = "sheet_no",length = 10)
	private String sheetNo;
	
	@Column(name = "plot_no",length =20)
	private String plotNo;
	
	@Column(name = "khata_no",length =20)
	private String khataNo;
	
	@Column(name = "rorarea_ac")
	private double rorArea;
	
	@Column(name = "kissam",length =50)
	private String kissam;
	
	@Column(name = "owner",length =254)
	private String owner;
	
	@Column(name = "dist",length =30)
	private String dist;
	
	@Column(name = "tahasil",length =30)
	private String tahasil;
	
	@Column(name = "village",length =30)
	private String village;
	
	@Column(name = "thana_name",length =30)
	private String thananame;
	
	@Column(name = "thana_no",length =30)
	private String thanano;
	
	@Column(name = "publ_year",length =30)
	private String publYear;
	
	@Column(name = "land_class",length =50)
	private String landclass;
	
	@Column(name = "dlc_sts",length =20)
	private String dlcSts;

	@Column(name = "patch",length =20)
	private String patch;
	
	@Column(name = "remarks",length =500)
	private String remarks;
	
	@Column(name = "sabik_sts",length =254)
	private String sabikSts;
	
	@Column(name = "plot")
	private int plot;
	
//	@Column(name = "geom",columnDefinition="geography")
//	private Point geom;
//	
	@Column(name = "acq_phase",length =30)
	private String acqPhase;
	
	@Column(name = "acq_stage",length =30)
	private String acqStage;
	
	@Column(name = "dept_ownership",length =30)
	private String deptOwnership;
	
	@Column(name = "proj_phase",length =30)
	private String projPhase;
	
	@Column(name = "lc_no",length =30)
	private String leaseCase;
}
