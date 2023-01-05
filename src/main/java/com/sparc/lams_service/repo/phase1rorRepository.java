package com.sparc.lams_service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sparc.lams_service.entity.Phase1ror;

public interface phase1rorRepository extends JpaRepository<Phase1ror,Long>{
	List<Phase1ror> findByVillage(String village);

	List<Phase1ror> findByDeptOwnership(String ownersip);

	List<Phase1ror> findByLandclass(String landclass);

	List<Phase1ror> findByVillageAndDeptOwnership(String village, String ownership);

	List<Phase1ror> findByVillageAndDeptOwnershipAndLandclass(String village, String ownership, String landclass);

	List<Phase1ror> findByKissam(String kissam);

	List<Phase1ror> findByDlcSts(String dlc);

	List<Phase1ror> findByVillageAndDlcSts(String village, String dlc);

	List<Phase1ror> findByVillageAndKissam(String village, String kissam);
	
	@Query(value = "SELECT * FROM amns_phase1_4578_ror_final WHERE  reqareaac=:reqarea", nativeQuery = true)
	List<Phase1ror> findByReqareaac(double reqarea);

	@Query(value = "SELECT * FROM amns_phase1_4578_ror_final WHERE  reqareaac>:reqarea", nativeQuery = true)
	List<Phase1ror> findByReqareaacgreater(double reqarea);

	@Query(value = "SELECT * FROM amns_phase1_4578_ror_final WHERE  reqareaac<:reqarea", nativeQuery = true)
	List<Phase1ror> findByReqareaacless(double reqarea);
	
	@Query(value = "SELECT * FROM amns_phase1_4578_ror_final WHERE  reqareaac>=:reqarea", nativeQuery = true)
	List<Phase1ror> findByReqareaacgreaterequal(double reqarea);
	
	@Query(value = "SELECT * FROM amns_phase1_4578_ror_final WHERE  reqareaac<=:reqarea", nativeQuery = true)
	List<Phase1ror> findByReqareaaclessequal(double reqarea);
	
	//ror area filters
	@Query(value = "SELECT * FROM amns_phase1_4578_ror_final WHERE  reqareaac=:reqarea and village=:village", nativeQuery = true)
	List<Phase1ror> findByReqareaacvillage(double reqarea, String village);
	@Query(value = "SELECT * FROM amns_phase1_4578_ror_final WHERE  reqareaac>:reqarea and village=:village", nativeQuery = true)
	List<Phase1ror> findByReqareaacgreatervillage(double reqarea, String village);
	@Query(value = "SELECT * FROM amns_phase1_4578_ror_final WHERE  reqareaac<:reqarea and village=:village", nativeQuery = true)
	List<Phase1ror> findByReqareaaclessvillage(double reqarea, String village);
	@Query(value = "SELECT * FROM amns_phase1_4578_ror_final WHERE  reqareaac>=:reqarea and village=:village", nativeQuery = true)
	List<Phase1ror> findByReqareaacgreaterequalvillage(double reqarea, String village);
	@Query(value = "SELECT * FROM amns_phase1_4578_ror_final WHERE  reqareaac<=:reqarea and village=:village", nativeQuery = true)
	List<Phase1ror> findByReqareaaclessequalvillage(double reqarea, String village);

	@Query(value = "SELECT * FROM amns_phase1_4578_ror_final WHERE  reqareaac=:reqarea and village=:village and dept_ownership=:owner", nativeQuery = true)
	List<Phase1ror> findByReqareaacvillageowner(double reqarea, String village, String owner);
	@Query(value = "SELECT * FROM amns_phase1_4578_ror_final WHERE  reqareaac>:reqarea and village=:village and dept_ownership=:owner", nativeQuery = true)
	List<Phase1ror> findByReqareaacgreatervillageowner(double reqarea, String village, String owner);
	@Query(value = "SELECT * FROM amns_phase1_4578_ror_final WHERE  reqareaac<:reqarea and village=:village and dept_ownership=:owner", nativeQuery = true)
	List<Phase1ror> findByReqareaaclessvillageowner(double reqarea, String village, String owner);
	@Query(value = "SELECT * FROM amns_phase1_4578_ror_final WHERE  reqareaac>=:reqarea and village=:village and dept_ownership=:owner", nativeQuery = true)
	List<Phase1ror> findByReqareaacgreaterequalvillageowner(double reqarea, String village, String owner);
	@Query(value = "SELECT * FROM amns_phase1_4578_ror_final WHERE  reqareaac<=:reqarea and village=:village and dept_ownership=:owner", nativeQuery = true)
	List<Phase1ror> findByReqareaaclessequalvillageowner(double reqarea, String village, String owner);

	@Query(value = "SELECT * FROM amns_phase1_4578_ror_final WHERE  reqareaac=:reqarea and village=:village and dept_ownership=:owner and land_class=:landclass", nativeQuery = true)
	List<Phase1ror> findByReqareaacvillageownerlandclass(double reqarea, String village, String owner,
			String landclass);
	@Query(value = "SELECT * FROM amns_phase1_4578_ror_final WHERE  reqareaac>:reqarea and village=:village and dept_ownership=:owner and land_class=:landclass", nativeQuery = true)
	List<Phase1ror> findByReqareaacgreatervillageownerlandclass(double reqarea, String village, String owner,
			String landclass);
	@Query(value = "SELECT * FROM amns_phase1_4578_ror_final WHERE  reqareaac<:reqarea and village=:village and dept_ownership=:owner and land_class=:landclass", nativeQuery = true)
	List<Phase1ror> findByReqareaaclessvillageownerlandclass(double reqarea, String village, String owner,
			String landclass);
	@Query(value = "SELECT * FROM amns_phase1_4578_ror_final WHERE  reqareaac>=:reqarea and village=:village and dept_ownership=:owner and land_class=:landclass", nativeQuery = true)
	List<Phase1ror> findByReqareaacgreaterequalvillageownerlandclass(double reqarea, String village, String owner,
			String landclass);
	@Query(value = "SELECT * FROM amns_phase1_4578_ror_final WHERE  reqareaac<=:reqarea and village=:village and dept_ownership=:owner and land_class=:landclass", nativeQuery = true)
	List<Phase1ror> findByReqareaaclessequalvillageownerlandclass(double reqarea, String village, String owner,
			String landclass);

	List<Phase1ror> findByGid(long id);

	List<Phase1ror> findByVillageAndLandclass(String village, String landclass);

	List<Phase1ror> findByDeptOwnershipAndLandclass(String ownership, String landclass);

	List<Phase1ror> findByVillageAndKhataNo(String village, String khata);

	@Query(value = "SELECT distinct(khataNo) FROM Phase1ror WHERE village=:village")
	List<Object[]> villagewisekhata(String village);

	
	
	

	List<Phase1ror> findByVillageAndDeptOwnershipAndKhataNo(String village, String owner, String khata);

	List<Phase1ror> findByVillageAndDeptOwnershipAndLandclassAndKhataNo(String village, String owner, String landclass,
			String khata);
	@Query(value = "SELECT distinct(khataNo) FROM Phase1ror WHERE village=:village and deptOwnership=:owner")
	List<Object[]> villageownershipwisekhata(String village, String owner);
	@Query(value = "SELECT distinct(khataNo) FROM Phase1ror WHERE village=:village and deptOwnership=:owner and landclass=:landclass")
	List<Object[]> villageownershipwisekhatalandclass(String village, String owner, String landclass);
	@Query(value = "SELECT distinct(khataNo) FROM Phase1ror WHERE village=:village and landclass=:landclass")
	List<Object[]> villagekhatalandclass(String village, String landclass);
	@Query(value = "SELECT distinct(khataNo) FROM Phase1ror WHERE deptOwnership=:owner and landclass=:landclass")
	List<Object[]> khatabyownershiplandclass(String owner, String landclass);
	@Query(value = "SELECT distinct(khataNo) FROM Phase1ror WHERE deptOwnership=:owner")
	List<Object[]> ownershipwisekhata(String owner);
	@Query(value = "SELECT distinct(khataNo) FROM Phase1ror WHERE landclass=:landclass")
	List<Object[]> landclasswisekhata(String landclass);
	
	@Query(value = "select land_type,cast(area as decimal(10,2)) from UDFN_DashbboardPie(:phase)", nativeQuery = true)
	List<Object[]> getdashboardpie(String phase);
	@Query(value = "select villagertn as village,cast(govtareartn as decimal(10,2)) as Govt_area,cast(pvtareartn as decimal(10,2)) as pvt_area,\r\n"
			+ "cast(forestareartn as decimal(10,2)) as Forest_area,cast(totareartn as decimal(10,2)) as total_area\r\n"
			+ "from UDFN_VillageWiseAreaAbstract(:phase)", nativeQuery = true)
	List<Object[]> getdashboardvillageabstract(String phase);

	@Query(value = "select * from UDFN_Landclasswiseprogress(:phase)", nativeQuery = true)
	List<Object[]> getlandprogressdashboard(String phase);

	

	
	
	
	//Land details common API
	@Query(value = "select * from amns_phase1_4578_ror_final where village=:village", nativeQuery = true)
	List<Phase1ror> landdetailsbyvillageandphase(String village);
	@Query(value = "select * from amns_phase1_4578_ror_final where dept_ownership=:ownership", nativeQuery = true)
	List<Phase1ror> landdetailsbyownership(String ownership);
	@Query(value = "select * from amns_phase1_4578_ror_final where land_class=:landclass", nativeQuery = true)
	List<Phase1ror> landdetailsbylandclass(String landclass);
	@Query(value = "select * from amns_phase1_4578_ror_final where village=:village and dept_ownership=:ownership", nativeQuery = true)
	List<Phase1ror> landdetailsbyvillageownership(String village, String ownership);
	@Query(value = "select * from amns_phase1_4578_ror_final where village=:village and land_class=:landclass", nativeQuery = true)
	List<Phase1ror> landdetailsbyvillagelandclass(String village, String landclass);
	@Query(value = "select * from amns_phase1_4578_ror_final where dept_ownership=:ownership and land_class=:landclass", nativeQuery = true)
	List<Phase1ror> landdetailsbyownershiplandclass(String ownership, String landclass);
	@Query(value = "select * from amns_phase1_4578_ror_final where village=:village and dept_ownership=:ownership and land_class=:landclass", nativeQuery = true)
	List<Phase1ror> landdetailsbyvillageownershiplandclass(String village, String ownership, String landclass);
	@Query(value = "select * from amns_phase1_4578_ror_final where village=:village and khata_no=:khatano", nativeQuery = true)
	List<Phase1ror> landdetailsbyvillagekhata(String village, String khatano);
	@Query(value = "select * from amns_phase1_4578_ror_final where land_class=:landclass and khata_no=:khatano", nativeQuery = true)
	List<Phase1ror> landdetailsbylandclasskhata(String landclass, String khatano);
	@Query(value = "select * from amns_phase1_4578_ror_final where dept_ownership=:ownership and khata_no=:khatano", nativeQuery = true)
	List<Phase1ror> landdetailsbyownershipkhata(String ownership, String khatano);
	@Query(value = "select * from amns_phase1_4578_ror_final where village=:village and dept_ownership=:ownership and khata_no=:khatano", nativeQuery = true)
	List<Phase1ror> landdetailsbyvillageownershipkhata(String village, String ownership, String khatano);
	@Query(value = "select * from amns_phase1_4578_ror_final where village=:village and land_class=:landclass and khata_no=:khatano", nativeQuery = true)
	List<Phase1ror> landdetailsbyvillagelandclasskhata(String village, String landclass, String khatano);
	@Query(value = "select * from amns_phase1_4578_ror_final where dept_ownership=:ownership and land_class=:landclass and khata_no=:khatano", nativeQuery = true)
	List<Phase1ror> landdetailsbyownershiplandclasskhata(String ownership, String landclass, String khatano);
	@Query(value = "select * from amns_phase1_4578_ror_final where village=:village and dept_ownership=:ownership and land_class=:landclass and khata_no=:khatano", nativeQuery = true)
	List<Phase1ror> landdetailsbyvillageownershiplandclasskhata(String village, String ownership, String landclass,
			String khatano);
	@Query(value = "select * from amns_phase1_4578_ror_final where dlc_sts=:forest", nativeQuery = true)
	List<Phase1ror> landdetailsbydlcforest(String forest);
	@Query(value = "select * from amns_phase1_4578_ror_final where village=:village and dlc_sts=:forest", nativeQuery = true)
	List<Phase1ror> landdetailsbyvillagedlcforest(String village, String forest);

	
	List<Phase1ror> findByVillageAndLandclassAndLeaseCase(String village, String landclass, String leasecase);
	
	@Query(value = "select land_type,cast(area as decimal(10,2))*0.4047 as area from UDFN_DashbboardPie(:phase)", nativeQuery = true)
	List<Object[]> getdashboardpiehctr(String phase);

	@Query(value = "select villagertn as village,cast(govtareartn as decimal(10,2))*0.4047 as Govt_area,cast(pvtareartn as decimal(10,2))*0.4047 as pvt_area,\r\n"
			+ "cast(forestareartn as decimal(10,2))*0.4047 as Forest_area,cast(totareartn as decimal(10,2))*0.4047 as total_area\r\n"
			+ "from UDFN_VillageWiseAreaAbstract(:phase)", nativeQuery = true)
	List<Object[]> getdashboardvillageabstracthct(String phase);
	
	@Query(value = "select landclassrtn,cast(notstartedrtn*0.4047 as decimal(10,2)) as notstartedrtn,cast(initialrtn*0.4047 as decimal(10,2)) as initialrtn,\r\n"
			+ "cast(processingrtn*0.4047 as decimal(10,2)) as processingrtn,cast(finalrtn*0.4047 as decimal(10,2)) as finalrtn,cast(totalrtn*0.4047 as decimal(10,2)) as totalrtn,seqrtn\r\n"
			+ "from UDFN_Landclasswiseprogress(:phase)", nativeQuery = true)
	List<Object[]> getlandprogressdashboardhct(String phase);
	
}
