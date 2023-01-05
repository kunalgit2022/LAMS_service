package com.sparc.lams_service.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sparc.lams_service.exception.ResourceNotFoundException;

import com.sparc.lams_service.entity.Phase1ror;

import com.sparc.lams_service.response.DashboardPie;
import com.sparc.lams_service.response.DashboardVillageAbstract;
import com.sparc.lams_service.response.Dashboardlandprogressresponse;
import com.sparc.lams_service.response.Khataresponse;

import com.sparc.lams_service.repo.phase1rorRepository;


@CrossOrigin(origins = "*",maxAge =3600,allowedHeaders = "*" )
@RestController
@RequestMapping("/api/v1")
public class PlotRor {
	@Autowired
	private phase1rorRepository phase1repo;
	
		// get all plots
		@GetMapping("/phase1allplots")
		public List<Phase1ror> getAllplots(){
			
		return phase1repo.findAll();
		
			
			
		}			
	
		@GetMapping("/phase1plotsbyvillage/{village}")
		public ResponseEntity<?> getplotsbyvillage(@PathVariable  String village) {
			List<Phase1ror> findByVillage=null;
			try {
			 findByVillage=phase1repo.findByVillage(village);
			}
			
			catch (Exception e) {
				e.printStackTrace();
			}
					
			return ResponseEntity.ok(findByVillage);
		}
		
		@GetMapping("/phase1plotsbyvillagelandclasslease/{phase}/{village}/{landclass}/{leasecase}")
		public ResponseEntity<?> getplotsbyvillagelease(@PathVariable  String phase,@PathVariable  String village,@PathVariable  String landclass,@PathVariable  String leasecase) {
			List<Phase1ror> findByVillage=null;
			try {
			
			if(phase.matches("Phase 1"))
			{
				findByVillage=phase1repo.findByVillageAndLandclassAndLeaseCase(village,landclass,leasecase);
			}
			else
			{
				
			}	
			
			}
			
			catch (Exception e) {
				e.printStackTrace();
			}
			return ResponseEntity.ok(findByVillage);
		}
		
		
		@PutMapping("/updateplotleasecase/{phase}/{id}")
		public ResponseEntity<Phase1ror> updatePlot(@PathVariable String phase,@PathVariable Long id, @RequestBody Phase1ror plots){
			Phase1ror ps1=null;
			Phase1ror updatedplot=null;
			try {
			if(phase.matches("Phase 1"))
			{
				ps1 = phase1repo.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("plot not exist with id :" + id));
				ps1.setLeaseCase(plots.getLeaseCase());
				updatedplot = phase1repo.save(ps1);
			}
			else
			{
				
			}
			
			}
			catch (Exception e) {
				e.printStackTrace();
			}

			return ResponseEntity.ok(updatedplot);
		}
		
		@PutMapping("/updateplotwisestage/{phase}/{id}")
		public ResponseEntity<Phase1ror> updatePlotbyid(@PathVariable String phase,@PathVariable Long id, @RequestBody Phase1ror plots){
			Phase1ror ps1=null;
			Phase1ror updatedplot=null;
			try {
			if(phase.matches("Phase 1"))
			{
				ps1 = phase1repo.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("plot not exist with id :" + id));
				//ps1.setLeaseCase(plots.getLeaseCase());
				ps1.setAcqStage(plots.getAcqStage());
				ps1.setAcqPhase(plots.getAcqPhase());
				updatedplot = phase1repo.save(ps1);
			}
			else
			{
				
			}
			
			}
			catch (Exception e) {
				e.printStackTrace();
			}

			return ResponseEntity.ok(updatedplot);
		}
		
		
		@GetMapping("/plotbyid/{id}")
		public ResponseEntity<?> getplotsbyvillage(@PathVariable  long id) {
			List<Phase1ror> findByVillage=null;
			try {
			 findByVillage=phase1repo.findByGid(id);
			}
			catch(Exception e)
			{
				
			}
			return ResponseEntity.ok(findByVillage);
		}
		
		@GetMapping("/phase1plotsbyownership/{ownersip}")
		public ResponseEntity<?> getplotsbyvillagebyowner(@PathVariable   String ownersip) {
			List<Phase1ror> findByVillage=null;
			try {
			 findByVillage=phase1repo.findByDeptOwnership(ownersip);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return ResponseEntity.ok(findByVillage);
		}
		@GetMapping("/phase1plotsbylandclass/{landclass}")
		public ResponseEntity<?> getplotsbyvillagebylandclass(@PathVariable   String landclass) {
			List<Phase1ror> findByVillage=null;
			try {
			 findByVillage=phase1repo.findByLandclass(landclass);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return ResponseEntity.ok(findByVillage);
		}
		@GetMapping("/phase1plotsbyvillage/{village}/{ownership}")
		public ResponseEntity<?> getplotsbyvillageandownership(@PathVariable  String village,@PathVariable  String ownership) {
			List<Phase1ror> findByVillage=null;
			try {
			 findByVillage=phase1repo.findByVillageAndDeptOwnership(village,ownership);
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return ResponseEntity.ok(findByVillage);
		}
		@GetMapping("/phase1plotsbyvillage/{village}/{ownership}/{landclass}")
		public ResponseEntity<?> getplotsbyvillageandownershiplandclass(@PathVariable  String village,@PathVariable  String ownership,@PathVariable  String landclass) {
			
			List<Phase1ror> findByVillage=null;
			try {
			 findByVillage=phase1repo.findByVillageAndDeptOwnershipAndLandclass(village,ownership,landclass);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return ResponseEntity.ok(findByVillage);
		}
		@GetMapping("/phase1plotsbykissam/{kissam}")
		public ResponseEntity<?> getplotsbyvillagebykissam(@PathVariable   String kissam) {
			List<Phase1ror> findByVillage=null;
			try {
			findByVillage=phase1repo.findByKissam(kissam);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return ResponseEntity.ok(findByVillage);
		}
		@GetMapping("/phase1plotsbydlc/{dlc}")
		public ResponseEntity<?> getplotsbyvillagebydlc(@PathVariable   String dlc) {
			List<Phase1ror> findByVillage=null;
			try {
			 findByVillage=phase1repo.findByDlcSts(dlc);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return ResponseEntity.ok(findByVillage);
		}
		@GetMapping("/phase1plotsbyvillageanddlc/{village}/{dlc}")
		public ResponseEntity<?> getplotsbyvillagebydlcandvillage(@PathVariable   String village,@PathVariable   String dlc) {
			List<Phase1ror> findByVillage=null;
			try {
			 findByVillage=phase1repo.findByVillageAndDlcSts(village,dlc);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return ResponseEntity.ok(findByVillage);
		}
		@GetMapping("/phase1plotsbyvillageandkissam/{village}/{kissam}")
		public ResponseEntity<?> getplotsbyvillagebykissamandvillage(@PathVariable   String village,@PathVariable   String kissam) {
			List<Phase1ror> findByVillage=null;
			try {
			 findByVillage=phase1repo.findByVillageAndKissam(village,kissam);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return ResponseEntity.ok(findByVillage);
		}
		
		//VILLAGE AND LANDCLASS
		
		@GetMapping("/phase1plotsbyvillagelandclass/{phase}/{village}/{landclass}")
		public ResponseEntity<?> getplotsbyvillageandlandclass(@PathVariable  String phase,@PathVariable  String village,@PathVariable  String landclass) {
			List<Phase1ror> findByVillage=null;
			try {
			if(phase.matches("Phase 1"))
			{
				findByVillage=phase1repo.findByVillageAndLandclass(village,landclass);
			}
			else
			{
				
			}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
					
			return ResponseEntity.ok(findByVillage);
		}
		
		//OWNERSHIP AND LANDCLASS
		
		@GetMapping("/phase1plotsbyownershiplandclass/{ownership}/{landclass}")
		public ResponseEntity<?> getplotsbyownershipandlandclass(@PathVariable  String ownership,@PathVariable  String landclass) {
			List<Phase1ror> findByVillage=null;
			try {
			 findByVillage=phase1repo.findByDeptOwnershipAndLandclass(ownership,landclass);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return ResponseEntity.ok(findByVillage);
		}
		
		//GET KHATA NOS
		@GetMapping("/getkhatanos")
		public ResponseEntity<?> getplotsbyvillagewisekhata(@RequestParam  String phase,@RequestParam  String village,@RequestParam  String owner,@RequestParam  String landclass) {
			List<Object[]> findByVillage=null;
			List<Khataresponse> villlist=new ArrayList<>();
			try {
			if(phase.matches("Phase 1") && owner.matches("0") && landclass.matches("0"))
			{
				findByVillage=phase1repo.villagewisekhata(village);
			}
			else if(phase.matches("Phase 1") && village.matches("0") && landclass.matches("0"))
			{
				findByVillage=phase1repo.ownershipwisekhata(owner);
			}
			else if(phase.matches("Phase 1") && village.matches("0") && owner.matches("0"))
			{
				findByVillage=phase1repo.landclasswisekhata(landclass);
			}
			else if(phase.matches("Phase 1") && landclass.matches("0"))
			{
				findByVillage=phase1repo.villageownershipwisekhata(village,owner);
			}
			else if(phase.matches("Phase 1") && owner.matches("0"))
			{
				findByVillage=phase1repo.villagekhatalandclass(village,landclass);
			}
			else if(phase.matches("Phase 1") && village.matches("0"))
			{
				findByVillage=phase1repo.khatabyownershiplandclass(owner,landclass);
			}
			else if (phase.matches("Phase 1") && village.matches("0") && owner.matches("0") && landclass.matches("0"))
			{
				findByVillage=null;
			}
			else if (phase.matches("Phase 1"))
			{
				findByVillage=phase1repo.villageownershipwisekhatalandclass(village,owner,landclass);
			}
			
			
			
			//List<Phase1ror> responseList = new ArrayList<>();
			findByVillage.forEach(x->{
				Khataresponse khataresponse=new Khataresponse();
				khataresponse.setKhatano(x[0].toString());		
				villlist.add(khataresponse);
			});
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return ResponseEntity.ok(villlist);
		}
		
		
				
				//DASHBOARD PIE CHART
				@GetMapping("/dashboardpiechart")
				public ResponseEntity<?> getdashboardpie(@RequestParam  String phase,@RequestParam String munit) {
					List<DashboardPie> villlist=new ArrayList<>();
					List<Object[]> findByVillage=null;
					try {
						if(munit.matches("a"))
						{
							findByVillage=phase1repo.getdashboardpie(phase);
						}
						else if(munit.matches("h"))
						{
							findByVillage=phase1repo.getdashboardpiehctr(phase);
						}
					
					
					//List<Phase1ror> responseList = new ArrayList<>();
					findByVillage.forEach(x->{
						DashboardPie piresponse=new DashboardPie();
						piresponse.setLandtype(x[0].toString());
						piresponse.setArea(x[1].toString());
//						Phase1ror response=new Phase1ror();
//						response.setKhataNo(x[0].toString());
						villlist.add(piresponse);
					});
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					return ResponseEntity.ok(villlist);
				}
				
				//DASHBOARD VILLAGE ABSTRACT
				
				@GetMapping("/dashboardvillageabstract")
				public ResponseEntity<?> getdashboardvillageabstract(@RequestParam  String phase,@RequestParam  String munit) {
					List<DashboardVillageAbstract> villlist=new ArrayList<>();
					List<Object[]> findByVillage=null;
					try {
						if(munit.matches("a"))
						{
							findByVillage=phase1repo.getdashboardvillageabstract(phase);
						}
						else if(munit.matches("h"))
						{
							findByVillage=phase1repo.getdashboardvillageabstracthct(phase);
						}
					
					
					//List<Phase1ror> responseList = new ArrayList<>();
					findByVillage.forEach(x->{
						DashboardVillageAbstract piresponse=new DashboardVillageAbstract();
						piresponse.setVillage(x[0].toString());
						piresponse.setGovtarea(x[1].toString());
						piresponse.setPvtarea(x[2].toString());
						piresponse.setForarea(x[3].toString());
						piresponse.setTotarea(x[4].toString());
//						Phase1ror response=new Phase1ror();
//						response.setKhataNo(x[0].toString());
						villlist.add(piresponse);
					});
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					return ResponseEntity.ok(villlist);
				}
				
					//DASHBOARD LAND PROGRESS RESPONSE
				@GetMapping("/dashboardlandprogress")
				public ResponseEntity<?> getdashboardlandprogress(@RequestParam  String phase,@RequestParam  String munit) {
					List<Dashboardlandprogressresponse> villlist=new ArrayList<>();
					List<Object[]> findByVillage=null;
					try {
						if(munit.matches("a"))
						{
							findByVillage=phase1repo.getlandprogressdashboard(phase);
						}
						else if(munit.matches("h"))
						{
							findByVillage=phase1repo.getlandprogressdashboardhct(phase);
						}
					
					
					//List<Phase1ror> responseList = new ArrayList<>();
					findByVillage.forEach(x->{
						Dashboardlandprogressresponse piresponse=new Dashboardlandprogressresponse();
						piresponse.setLandclass(x[0].toString());
						piresponse.setNotstarted(x[1].toString());
						piresponse.setInitial(x[2].toString());
						piresponse.setProcessing(x[3].toString());
						piresponse.setFinalst(x[4].toString());
						piresponse.setTotal(x[5].toString());
						villlist.add(piresponse);
					});
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					return ResponseEntity.ok(villlist);
				}
				
				//common API for fetch land details
				
				
				@GetMapping("/landdetails")
				public ResponseEntity<?> getlanddetails(@RequestParam String phase,@RequestParam String village,@RequestParam String ownership,@RequestParam String landclass,@RequestParam String khatano,@RequestParam String kissam,@RequestParam String operator,@RequestParam double reqarea,@RequestParam String forest) {
					
					List<Phase1ror> findByVillage=null;
					//only village filter
					try {
					if(phase.matches("Phase 1") && ownership.matches("0") &&  landclass.matches("0") && khatano.matches("0") && kissam.matches("0") && operator.matches("0") && reqarea==0 && forest.matches("0"))
					{
						findByVillage=phase1repo.landdetailsbyvillageandphase(village);
					}
					//only ownership filter 
					else if(phase.matches("Phase 1") && village.matches("0")  &&  landclass.matches("0") && khatano.matches("0") && kissam.matches("0") && operator.matches("0") && reqarea==0 && forest.matches("0"))
					{
						findByVillage=phase1repo.landdetailsbyownership(ownership);
					}
					//only landclass filter 
					else if(phase.matches("Phase 1") && village.matches("0")  &&  ownership.matches("0") && khatano.matches("0") && kissam.matches("0") && operator.matches("0") && reqarea==0 && forest.matches("0"))
					{
						findByVillage=phase1repo.landdetailsbylandclass(landclass);
					}
					//village and ownership
					else if(phase.matches("Phase 1") && landclass.matches("0") && khatano.matches("0") && kissam.matches("0") && operator.matches("0") && reqarea==0  && forest.matches("0"))
					{
						findByVillage=phase1repo.landdetailsbyvillageownership(village,ownership);
					}
					//village and landclass
					else if(phase.matches("Phase 1") && ownership.matches("0") && khatano.matches("0") && kissam.matches("0") && operator.matches("0") && reqarea==0 && forest.matches("0"))
					{
						findByVillage=phase1repo.landdetailsbyvillagelandclass(village,landclass);
					}
					//Ownership and landclass
					else if(phase.matches("Phase 1") && village.matches("0") && khatano.matches("0") && kissam.matches("0") && operator.matches("0") && reqarea==0 && forest.matches("0"))
					{
						findByVillage=phase1repo.landdetailsbyownershiplandclass(ownership,landclass);
					}
					//village, ownership and landclass
					else if(phase.matches("Phase 1") && khatano.matches("0") && kissam.matches("0") && operator.matches("0") && reqarea==0 && forest.matches("0"))
					{
						findByVillage=phase1repo.landdetailsbyvillageownershiplandclass(village,ownership,landclass);
					}
					//village and khata
					else if(phase.matches("Phase 1") && ownership.matches("0") && landclass.matches("0") && kissam.matches("0") && operator.matches("0") && reqarea==0 && forest.matches("0"))
					{
						findByVillage=phase1repo.landdetailsbyvillagekhata(village,khatano);
					}
					//landclass and khata
					else if(phase.matches("Phase 1") && ownership.matches("0") && village.matches("0") && kissam.matches("0") && operator.matches("0") && reqarea==0 && forest.matches("0"))
					{
						findByVillage=phase1repo.landdetailsbylandclasskhata(landclass,khatano);
					}
					//ownership and khata
					else if(phase.matches("Phase 1") && landclass.matches("0") && village.matches("0") && kissam.matches("0") && operator.matches("0") && reqarea==0 && forest.matches("0"))
					{
						findByVillage=phase1repo.landdetailsbyownershipkhata(ownership,khatano);
					}
					//village ,ownership and khata
					else if(phase.matches("Phase 1") && landclass.matches("0") && kissam.matches("0") && operator.matches("0") && reqarea==0 && forest.matches("0"))
					{
						findByVillage=phase1repo.landdetailsbyvillageownershipkhata(village,ownership,khatano);
					}
					//village ,landclass and khata
					else if(phase.matches("Phase 1") && ownership.matches("0") && kissam.matches("0") && operator.matches("0") && reqarea==0 && forest.matches("0"))
					{
						findByVillage=phase1repo.landdetailsbyvillagelandclasskhata(village,landclass,khatano);
					}
					//ownership ,landclass and khata
					else if(phase.matches("Phase 1") && ownership.matches("0") && kissam.matches("0") && operator.matches("0") && reqarea==0 && forest.matches("0"))
					{
						findByVillage=phase1repo.landdetailsbyownershiplandclasskhata(ownership,landclass,khatano);
					}
					
					//village, ownership, landclass and khata
					else if(phase.matches("Phase 1") && kissam.matches("0") && operator.matches("0") && reqarea==0 && forest.matches("0"))
					{
						findByVillage=phase1repo.landdetailsbyvillageownershiplandclasskhata(village,ownership,landclass,khatano);
					}
					//forest type
					else if(phase.matches("Phase 1") && village.matches("0") && ownership.matches("0") && landclass.matches("0") && khatano.matches("0") && kissam.matches("0") && operator.matches("0") && reqarea==0)
					{
						findByVillage=phase1repo.landdetailsbydlcforest(forest);
					}
					//village and forest type
					else if(phase.matches("Phase 1")  && (ownership.matches("0") || ownership.matches("Forest") || ownership.matches("Government")) && (landclass.matches("0") || landclass.matches("Forest")) && khatano.matches("0") && kissam.matches("0") && operator.matches("0") && reqarea==0)
					{
						findByVillage=phase1repo.landdetailsbyvillagedlcforest(village,forest);
					}
					else if(phase.matches("Phase 1") &&  ownership.matches("0")  && landclass.matches("0") && khatano.matches("0") && kissam.matches("0") && reqarea!=0)
					{
						if(operator.matches("="))
						{
							
							findByVillage=phase1repo.findByReqareaacvillage(reqarea,village);
							
						}
						if(operator.matches(">"))
						{
							
							findByVillage=phase1repo.findByReqareaacgreatervillage(reqarea,village);
							
						}
						if(operator.matches("<"))
						{
							
							findByVillage=phase1repo.findByReqareaaclessvillage(reqarea,village);
							
						}
						if(operator.matches(">="))
						{
							
							findByVillage=phase1repo.findByReqareaacgreaterequalvillage(reqarea,village);
							
						}
						if(operator.matches("<="))
						{
							
							findByVillage=phase1repo.findByReqareaaclessequalvillage(reqarea,village);
							
						}
						
					}
					
					//Village and ownership and req area
					
					else if(phase.matches("Phase 1")  && landclass.matches("0") && khatano.matches("0") && kissam.matches("0") && reqarea!=0)
					{
						if(operator.matches("="))
						{
							
							findByVillage=phase1repo.findByReqareaacvillageowner(reqarea,village,ownership);
							
						}
						if(operator.matches(">"))
						{
							
							findByVillage=phase1repo.findByReqareaacgreatervillageowner(reqarea,village,ownership);
							
						}
						if(operator.matches("<"))
						{
							
							findByVillage=phase1repo.findByReqareaaclessvillageowner(reqarea,village,ownership);
							
						}
						if(operator.matches(">="))
						{
							
							findByVillage=phase1repo.findByReqareaacgreaterequalvillageowner(reqarea,village,ownership);
							
						}
						if(operator.matches("<="))
						{
							
							findByVillage=phase1repo.findByReqareaaclessequalvillageowner(reqarea,village,ownership);
							
						}
						
					}
					
					//village, ownership and landclass
					
					else if(phase.matches("Phase 1")   && khatano.matches("0") && kissam.matches("0") && reqarea!=0)
					{
						if(operator.matches("="))
						{
							
							findByVillage=phase1repo.findByReqareaacvillageownerlandclass(reqarea,village,ownership,landclass);
							
						}
						if(operator.matches(">"))
						{
							
							findByVillage=phase1repo.findByReqareaacgreatervillageownerlandclass(reqarea,village,ownership,landclass);
							
						}
						if(operator.matches("<"))
						{
							
							findByVillage=phase1repo.findByReqareaaclessvillageownerlandclass(reqarea,village,ownership,landclass);
							
						}
						if(operator.matches(">="))
						{
							
							findByVillage=phase1repo.findByReqareaacgreaterequalvillageownerlandclass(reqarea,village,ownership,landclass);
						}
						if(operator.matches("<="))
						{
							
							findByVillage=phase1repo.findByReqareaaclessequalvillageownerlandclass(reqarea,village,ownership,landclass);
							
						}
						
					}
					
					}
					catch (Exception e) {
						e.printStackTrace();
					}
					
					return ResponseEntity.ok(findByVillage);
					
					
					
					
				}
}
