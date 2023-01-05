package com.sparc.lams_service.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sparc.lams_service.exception.ResourceNotFoundException;
import com.sparc.lams_service.entity.LeaseCaseVillageLink;

import com.sparc.lams_service.repo.LeaseCaseVillageLinkRepository;

@CrossOrigin(origins = "*",maxAge =3600 )
@RestController
@RequestMapping("/api/v1")
public class LeaseCaseVillageLinkController {
	@Autowired
	private LeaseCaseVillageLinkRepository lcvrepo;
	
	// get all employees
	@GetMapping("/lcvillage")
	public List<LeaseCaseVillageLink> getAllVillage(){
		
		return lcvrepo.findAll();
		
	}		
	
	// create employee rest api
	@PostMapping("/lcvillage")
	public LeaseCaseVillageLink createVillage(@RequestBody LeaseCaseVillageLink lcvil) {
	
		return lcvrepo.save(lcvil);
		
	}
	
	// get employee by id rest api
	@GetMapping("/lcvillage/{id}")
	public ResponseEntity<LeaseCaseVillageLink> getVillageById(@PathVariable String id) {
		LeaseCaseVillageLink lcmodel=null;
		try {
			 lcmodel = lcvrepo.findByLeaseCaseno(id)
					.orElseThrow(() -> new ResourceNotFoundException("village not exist with id :" + id));
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
			return ResponseEntity.ok(lcmodel);
			
		
		
	}
	
	@GetMapping("/getleasecase/{village}/{landclass}")
	public ResponseEntity<?> getleasecasebyvillage(@PathVariable  int village,@PathVariable  String landclass) {
		List<LeaseCaseVillageLink> findByVillage=null;
		try {
		 findByVillage=lcvrepo.findByVilCodeAndLandClass(village,landclass);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
				
		
		return ResponseEntity.ok(findByVillage);
		
		
		
		
	}
	
	
	
	@GetMapping("/lclist/{village}/{landclass}/{leasecase}")
	public ResponseEntity<LeaseCaseVillageLink> getleasecasebyLandClassandvill(@PathVariable int village,@PathVariable String landclass,@PathVariable String leasecase) {
		LeaseCaseVillageLink lcmodel=null;
		try {
		 lcmodel = lcvrepo.findByVilCodeAndLandClassAndLeaseCaseno(village,landclass,leasecase)
				.orElseThrow(() -> new ResourceNotFoundException("Not Exists"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ResponseEntity.ok(lcmodel);
	}
	
	// update Document
	
		@PutMapping("/lcdocmap/{village}/{landclass}/{leasecase}")
		public ResponseEntity<LeaseCaseVillageLink> updateleasecaseDoc(@PathVariable int village,@PathVariable String landclass,@PathVariable String leasecase, @RequestBody LeaseCaseVillageLink lcmodel){
			LeaseCaseVillageLink vilclass=null;
			
			try {
			LeaseCaseVillageLink lcmodelval = lcvrepo.findByVilCodeAndLandClassAndLeaseCaseno(village,landclass,leasecase)
					.orElseThrow(() -> new ResourceNotFoundException("Not Found"));
			

			lcmodelval.setdocRef(lcmodel.getdocRef());
			
			
			
			 vilclass = lcvrepo.save(lcmodelval);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return ResponseEntity.ok(vilclass);
			
			
			
			            
		}
		
	
	// update employee rest api
	
	@PutMapping("/lcupdate/{village}/{landclass}/{leasecase}")
	public ResponseEntity<LeaseCaseVillageLink> updateleasecasewisevillage(@PathVariable int village,@PathVariable String landclass,@PathVariable String leasecase, @RequestBody LeaseCaseVillageLink lcmodel){
		LeaseCaseVillageLink vilclass=null;
		try {
		LeaseCaseVillageLink lcmodelval = lcvrepo.findByVilCodeAndLandClassAndLeaseCaseno(village,landclass,leasecase)
				.orElseThrow(() -> new ResourceNotFoundException("Not Found"));
		

		lcmodelval.setcurStage(lcmodel.getcurStage());
		lcmodelval.setcurPhase(lcmodel.getcurPhase());

		lcmodelval.setlastUpdated(lcmodel.getlastUpdated());
		
		
		 vilclass = lcvrepo.save(lcmodelval);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(vilclass);
		
		
		
		
	}
	
	
	
	// delete employee rest api
	@DeleteMapping("/lcvillage/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteVillage(@PathVariable Long id){
		Map<String, Boolean> response = new HashMap<>();
		try {
		LeaseCaseVillageLink vilclass = lcvrepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("village not exist with id :" + id));
		lcvrepo.delete(vilclass);
		
		response.put("deleted", Boolean.TRUE);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(response);
		
		
		
	}
}
