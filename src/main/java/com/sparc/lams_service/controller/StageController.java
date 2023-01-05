package com.sparc.lams_service.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sparc.lams_service.entity.Stage;
import com.sparc.lams_service.repo.StageRepository;

@CrossOrigin(origins = "*",maxAge =3600 )
@RestController
@RequestMapping("/api/v1")
public class StageController {
	@Autowired
	private StageRepository stagerepo;
	
		// get all plots
		@GetMapping("/stage")
		public List<Stage> getAllplots(){
		return stagerepo.findAll();
		}			
	
		@GetMapping("/stage/{landclass}")
		public ResponseEntity<?> getstagebylandclass(@PathVariable String landclass) {
			List<Stage> findByLandClass = null;
			try {
				 findByLandClass = stagerepo.findByLandClass(landclass);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}		
			return ResponseEntity.ok(findByLandClass);
		}
		
		@GetMapping("/findstage/{stagecode}")
		public ResponseEntity<?> getstagebystagecode(@PathVariable String stagecode) {
			List<Stage> findByLandClassstagecode=null;
			try {
				 findByLandClassstagecode = stagerepo.findByStageCode(stagecode);
			}
			catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
					
			return ResponseEntity.ok(findByLandClassstagecode);
		}
//		@GetMapping("/stage/{dlc}")
//		public ResponseEntity<?> getplotsbyvillagebydlc(@PathVariable   String dlc) {
//			List<Phase1ror> findByVillage=phase1repo.findByDlcSts(dlc);
//					
//			return ResponseEntity.ok(findByVillage);
//		}
	
}
