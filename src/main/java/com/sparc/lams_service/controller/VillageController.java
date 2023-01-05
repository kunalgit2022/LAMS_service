package com.sparc.lams_service.controller;
import java.util.ArrayList;
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

import com.sparc.lams_service.entity.Village;
import com.sparc.lams_service.repo.VillageRepository;
import com.sparc.lams_service.response.VillageResponse;


@CrossOrigin(origins = "*",maxAge =3600 )
@RestController
@RequestMapping("/api/v1")
public class VillageController {

	@Autowired
	private VillageRepository vlgRepository;
	
	
	
	// get all employees
	@GetMapping("/village")
	public List<Village> getAllVillage(){
		return vlgRepository.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/village")
	public Village createVillage(@RequestBody Village village) {
		return vlgRepository.save(village);
	}
	
	@GetMapping("/phasewisevillage/{phase}")
	public ResponseEntity<?> getplotsbyvillage(@PathVariable  String phase) {
		List<Village> findByVillage=null;
		try {
			 findByVillage=vlgRepository.findByPhase(phase);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
				
		return ResponseEntity.ok(findByVillage);
	}
	
	// get employee by id rest api
	@GetMapping("/village/{id}")
	public ResponseEntity<Village> getVillageById(@PathVariable Long id) {
		Village village =null;
        try {
			 village = vlgRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("village not exist with id :" + id));	
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return ResponseEntity.ok(village);
	}
	
	// update employee rest api
	
	@PutMapping("/village/{id}")
	public ResponseEntity<Village> updateVillage(@PathVariable Long id, @RequestBody Village village){
		Village vilclass = null;
		try {
			Village vill = vlgRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("village not exist with id :" + id));
			
			vill.setDistrict(village.getDistrict());
			vill.setTehsil(village.getTehsil());
			vill.setVillage(village.getVillage());
			vill.setric(village.getric());
			vill.setthanaNo(village.getthanaNo());
			vill.setthanaName(village.getthanaName());
			vill.setphase(village.getphase());
			 vilclass = vlgRepository.save(vill);
			} catch (Exception e) {
				e.printStackTrace();
			// TODO: handle exception
		}
		
		return ResponseEntity.ok(vilclass);
	}
	
	// delete employee rest api
	@DeleteMapping("/village/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteVillage(@PathVariable Long id){
		Map<String, Boolean> response = new HashMap<>();
		try {
			Village vilclass = vlgRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("village not exist with id :" + id));
			
			vlgRepository.delete(vilclass);
			 response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
				return ResponseEntity.ok(response);
	}
	
	@GetMapping("/getvillagename")
	public List<VillageResponse> getVillage() {
		List<VillageResponse> villlist=null;
		try {
			//List<Object> village = vlgRepository.getVillagename();
			List<Village> findAll = vlgRepository.findAll();
			 villlist=new ArrayList<>();
			for(Village vill:findAll) {
				VillageResponse res =new VillageResponse();
				res.setVillageCode(vill.getId());
				res.setVillageName(vill.getVillage());
				villlist.add(res);
			}
		}
			catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	    
		
	    return villlist;
	
		}	
		
}
