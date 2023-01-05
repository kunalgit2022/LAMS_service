package com.sparc.lams_service.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparc.lams_service.entity.Department;
import com.sparc.lams_service.entity.User;
import com.sparc.lams_service.exception.ResourceNotFoundException;
import com.sparc.lams_service.repo.UserRepository;


import com.sparc.lams_service.request.LoginRequest;
import com.sparc.lams_service.response.Dashboardlandprogressresponse;
import com.sparc.lams_service.response.LoginResponse;
import com.sparc.lams_service.response.Messageresponse;
import com.sparc.lams_service.response.SingleUserResponse;
import com.sparc.lams_service.response.UserResponse;
import com.sparc.lams_service.service.IAuthService;
@CrossOrigin(origins = "*",maxAge =3600 ,allowedHeaders = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private IAuthService authService;

	
	
	@Autowired
	private UserRepository userrepo;

	
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) throws UsernameNotFoundException {
		try {
			LoginResponse login = authService.login(loginRequest);
			return ResponseEntity.ok(login);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new Messageresponse("Invalid UserName or Password!"), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/registerUser")
	public ResponseEntity<?> registerUser(@RequestBody User user)
			throws Exception {
		//User empData = new ObjectMapper().readValue(employeeData, User.class);
		Optional<User> optional = userrepo.findByUserId(user.getUserId());
		if (optional.isPresent())
			return ResponseEntity.ok(new Messageresponse("User Id Already Existed"));
		User employee = authService.registerUser(user);
		if (employee != null)
			return ResponseEntity.ok(new Messageresponse("User Register Successfully"));
		else
			return ResponseEntity.internalServerError().body(new Messageresponse("Error"));

	}
	
	@GetMapping("/getuser")
	public ResponseEntity<?> ggetusers() {
		
		List<UserResponse> userrespo=new ArrayList<>();
		List<Object[]> usr=userrepo.userwithrole();
		
		usr.forEach(x->{
			UserResponse usrresponse=new UserResponse();
			usrresponse.setId((int) x[6]);
			usrresponse.setName(x[0].toString());
			usrresponse.setMobile(x[1].toString());
			usrresponse.setEmail(x[2].toString());
			usrresponse.setDesg(x[3].toString());
			usrresponse.setDept(x[4].toString());
			usrresponse.setRole(x[5].toString());
			usrresponse.setCreatedat(x[7].toString());
			usrresponse.setUpdatedat(x[8].toString());
			userrespo.add(usrresponse);
		});
		
		
		return ResponseEntity.ok(userrespo);
	}
	@GetMapping("/user/{id}")
	public ResponseEntity<?> ggetusersbyid(@PathVariable Long id) {
		List<SingleUserResponse> userrespo=new ArrayList<>();
		List<Object[]> usr=userrepo.userwithrolebyid(id);
		
		usr.forEach(x->{
			SingleUserResponse usrresponse=new SingleUserResponse();
			usrresponse.setUname(x[0].toString());
			usrresponse.setMobile(x[1].toString());
			usrresponse.setEmail(x[2].toString());
			usrresponse.setUserId(x[3].toString());
			usrresponse.setDesg(x[4].toString());
			usrresponse.setDeptId((int) x[5]);
			usrresponse.setDeptname(x[6].toString());
			usrresponse.setRoleId((int) x[7]);
			usrresponse.setRolename(x[8].toString());
			usrresponse.setCreatedAt(x[9].toString());
			usrresponse.setUpdatedAt(x[10].toString());
			userrespo.add(usrresponse);
		});
		
		
		return ResponseEntity.ok(userrespo);
	}
	
//	@GetMapping("/user/{id}")
//	public ResponseEntity<User> ggetusersbyid(@PathVariable Long id) {
//		User usr= userrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));;
//		return ResponseEntity.ok(usr);
//	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateDepartment(@PathVariable Long id, @RequestBody User userdtl){
		User oldusr = userrepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("user not exist with id :" + id));
		
		oldusr.setUName(userdtl.getUName());
		oldusr.setMobile(userdtl.getMobile());
    	oldusr.setEmail(userdtl.getEmail());
    	oldusr.setDeptId(userdtl.getDeptId());
    	oldusr.setDesg(userdtl.getDesg());
    	oldusr.setRoleId(userdtl.getRoleId());
    	oldusr.setUserId(userdtl.getUserId());
    	oldusr.setUpdatedAt(userdtl.getUpdatedAt());
		User updateduser = userrepo.save(oldusr);
		return ResponseEntity.ok(updateduser);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteuser(@PathVariable Long id){
		User usr = userrepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("user not exist with id :" + id));
		
		userrepo.delete(usr);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
//	
//	@DeleteMapping("/deleteEmployee/{id}")
//	@PreAuthorize("isAuthenticated()")
//	public ResponseEntity<?>deleteEmployee(@PathVariable Integer id){
//		String message=authService.deleteEmployee(id);
//		return ResponseEntity.ok(new Messageresponse(message));
//	}

}
