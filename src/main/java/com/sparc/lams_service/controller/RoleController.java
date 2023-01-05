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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sparc.lams_service.exception.ResourceNotFoundException;
import com.sparc.lams_service.entity.Role;

import com.sparc.lams_service.entity.Permission;

import com.sparc.lams_service.entity.Primarymenus;
import com.sparc.lams_service.repo.roleRepository;

import com.sparc.lams_service.response.DeletedpermResponse;
import com.sparc.lams_service.response.PermissionlistResponse;
import com.sparc.lams_service.repo.permissionRepository;
import com.sparc.lams_service.repo.PrimaryMenuRepository;

@CrossOrigin(origins = "*",maxAge =3600 )
@RestController
@RequestMapping("/api/v1")

public class RoleController {
	@Autowired
	private roleRepository rolerepo;
	@Autowired
	private permissionRepository permissionrepo;
	@Autowired
	private PrimaryMenuRepository prmrepo;
	
		// get all roles
		@GetMapping("/role")
		public List<Role> getAllroles(){
		return rolerepo.findAll();
		}		
		
		// insert to role table
		@PostMapping("/role")
		public Role createrole(@RequestBody Role role) {
		return rolerepo.save(role);
				}
				
		
		//get all primary link menus
		@GetMapping("/primarylink")
		public List<Primarymenus> getAllprimarylink(){
		return prmrepo.findAllByOrderBySeqAsc();
		}	
		
		//get all permissions
		@GetMapping("/permission")
		public List<Permission> getAllpermission(){
		return permissionrepo.findAll();
		}	
		
		// insert to permission table
		@PostMapping("/permission")
		public Permission createVillage(@RequestBody Permission permission) {
			return permissionrepo.save(permission);
		}
		
		//get permission name by roleid
		@GetMapping("/permissionbyroleid")
		public ResponseEntity<?> getAllpermissionbyroleid(@RequestParam  int roleid){
			List<PermissionlistResponse> permlist=new ArrayList<>();
			try {
			List<Object[]> findByVillage=permissionrepo.findpermissionbyroleid(roleid);
			
			findByVillage.forEach(x->{
				PermissionlistResponse permres=new PermissionlistResponse();
				permres.setPermissionid(x[0].toString());
				permres.setPermissionname(x[1].toString());
				
				
				permlist.add(permres);
			});
			}
			
			catch (Exception e) {
				e.printStackTrace();
			}
			return ResponseEntity.ok(permlist);

		}	
		
		//delete role
		
		@DeleteMapping("/deleterole")
		public ResponseEntity<Map<String, Boolean>> deleterole(@RequestParam Long roleid){
			Map<String, Boolean> response = new HashMap<>();
			try
			{
			Role role = rolerepo.findById(roleid)
					.orElseThrow(() -> new ResourceNotFoundException("role not exist with id :" + roleid));
			rolerepo.delete(role);
			
			
			response.put("deleted", Boolean.TRUE);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return ResponseEntity.ok(response);
		}
		
		//update role name
		@PutMapping("/updaterole")
		public ResponseEntity<Role> updaterolename(@RequestParam long roleid, @RequestBody Role role){
			Role updatedrole=null;
			try {
			Role getrole = rolerepo.findById(roleid)
					.orElseThrow(() -> new ResourceNotFoundException("role not exist with id :" + roleid));
			
			getrole.setRoleName(role.getRoleName());
			
			
			 updatedrole = rolerepo.save(getrole);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return ResponseEntity.ok(updatedrole);
		}
		
//		//delete permission
////		
//				@DeleteMapping("/deletepermission")
//				public ResponseEntity<Map<String, Boolean>> deletepermission(@RequestParam int roleid){
//					List<Permission> permission = permissionrepo.findByRoleid(roleid);
//					//permission.forEach(null)
//					//permissionrepo.delete(permission);
//					permissionrepo.deleteByIdIn(permission);
//					Map<String, Boolean> response = new HashMap<>();
//					response.put("deleted", Boolean.TRUE);
//					return ResponseEntity.ok(response);
//				}
				
				//get all permissions
//		@DeleteMapping("/removepermission")
//				public void deleteperm(@RequestParam int roleid){
//				 permissionrepo.deletebyRoleid(roleid);
//				 
//				 
//				}	
		@GetMapping("/removepermission")
		public ResponseEntity<?> getupdatedpermissions(@RequestParam  int roleid) {
			List<DeletedpermResponse> villlist=new ArrayList<>();
			try {
			List<Object[]> findupdatedpermission=permissionrepo.getupdatedrecords(roleid);
			
			//List<Phase1ror> responseList = new ArrayList<>();
			findupdatedpermission.forEach(x->{
				DeletedpermResponse piresponse=new DeletedpermResponse();
				piresponse.setPermid(x[0].toString());
				piresponse.setRoleid(x[1].toString());
				villlist.add(piresponse);
			});
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return ResponseEntity.ok(villlist);
		}
}
