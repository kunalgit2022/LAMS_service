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
import com.sparc.lams_service.entity.Landclass;
import com.sparc.lams_service.repo.LandclassRepository;

@CrossOrigin(origins = "*",maxAge =3600 )
@RestController
@RequestMapping("/api/v1")
public class LandClassController {
	@Autowired
	private LandclassRepository lcRepository;
	
	// get all employees
	@GetMapping("/landclass")
	public List<Landclass> getAlllandclass(){
		return lcRepository.findByOrderByIdAsc();
	}		
	
	// create employee rest api
	@PostMapping("/landclass")
	public Landclass createlandclass(@RequestBody Landclass landclass) {
		return lcRepository.save(landclass);
	}
	
	
	
	@GetMapping("/landclass/{owner}")
	public ResponseEntity<?> getladclassbyowner(@PathVariable   String owner) {
		List<Landclass> findByVillage=null;
		try {
			findByVillage=lcRepository.findByOwnership(owner);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
				
		return ResponseEntity.ok(findByVillage);
	}
	
	// update employee rest api
	
	@PutMapping("/landclass/{id}")
	public ResponseEntity<Landclass> updatelandclass(@PathVariable Long id, @RequestBody Landclass landclassdetails){
		Landclass updatedlandclass=null;
		try {
			Landclass landclass = lcRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("landclass not exist with id :" + id));
			
			landclass.setlandClass(landclassdetails.getlandClass());
			landclass.setownership(landclassdetails.getownership());
			 updatedlandclass = lcRepository.save(landclass);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return ResponseEntity.ok(updatedlandclass);
	}
	
	// delete employee rest api
	@DeleteMapping("/landclass/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteLandClass(@PathVariable Long id){
		Map<String, Boolean> response = new HashMap<>();
		try {
			Landclass landclass = lcRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("landclass not exist with id :" + id));
			lcRepository.delete(landclass);
			response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
				return ResponseEntity.ok(response);
	}
}
