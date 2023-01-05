package com.sparc.lams_service.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sparc.lams_service.entity.LeaseCaseHistory;
import com.sparc.lams_service.repo.LeasecaseHistoryrepository;

@CrossOrigin(origins = "*",maxAge =3600 )
@RestController
@RequestMapping("/api/v1")
public class LeaseCaseHistoryController {
	@Autowired
	private LeasecaseHistoryrepository leasecasehistoryrepo;
	
	
	
	// get all employees
	@GetMapping("/leasecasehistory")
	public List<LeaseCaseHistory> getAllhistory(){
		return leasecasehistoryrepo.findAll();
	}	
	
	// create employee rest api
		@PostMapping("/leasecasehistory")
		public LeaseCaseHistory Insertleasecasehistory(@RequestBody LeaseCaseHistory history) {
			return leasecasehistoryrepo.save(history);
		}
		
		@GetMapping("/leasecasehistory/{village}/{landclass}/{leasecase}")
		public ResponseEntity<?> gethistory(@PathVariable int village,@PathVariable int landclass,@PathVariable int leasecase) {
			List<LeaseCaseHistory> findByVilCodeAndLandClassAndLeaseCase =null;
			try {
				 findByVilCodeAndLandClassAndLeaseCase = leasecasehistoryrepo.findByVilCodeAndLandClassAndLeaseCase(village,landclass,leasecase);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
					
			return ResponseEntity.ok(findByVilCodeAndLandClassAndLeaseCase);
		}	
}
