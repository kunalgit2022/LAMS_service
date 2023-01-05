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
import com.sparc.lams_service.entity.Department;
import com.sparc.lams_service.repo.DepartmentRepository;
@CrossOrigin(origins = "*",maxAge =3600 )
@RestController
@RequestMapping("/api/v1")
public class DepartmentController {
	@Autowired
	private DepartmentRepository departmentRepository;
	
	// get all employees
	@GetMapping("/department")
	public List<Department> getAllDepartment(){
		
		return departmentRepository.findAllByOrderByIdAsc();
	
	}
	// create employee rest api
	@PostMapping("/department")
	public Department createDepartment(@RequestBody Department department) {
		
			return departmentRepository.save(department);
		
		
	}
	
	// get employee by id rest api
	@GetMapping("/department/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
		Department department=null;
			try {
				 department = departmentRepository.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("department not exist with id :" + id));
				
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			return ResponseEntity.ok(department);
		
		
		
	}
	
	// update employee rest api
	
	@PutMapping("/department/{id}")
	public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department departmentDetails){
		Department department=null;
		Department updatedEmployee=null;
		try {
			 department = departmentRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("department not exist with id :" + id));
			
			department.setDeptName(departmentDetails.getDeptName());
			
			
			 updatedEmployee = departmentRepository.save(department);
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
			// TODO: handle exception
		
		
	return ResponseEntity.ok(updatedEmployee);
	}
	
	// delete employee rest api
	@DeleteMapping("/department/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDepartment(@PathVariable Long id){
		Department department=null;
		Map<String, Boolean> response = new HashMap<>();   
		try {
			 department = departmentRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("department not exist with id :" + id));
			
			departmentRepository.delete(department);
			
			response.put("deleted", Boolean.TRUE);
			
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
			// TODO: handle exception
		return ResponseEntity.ok(response);
		}
}
