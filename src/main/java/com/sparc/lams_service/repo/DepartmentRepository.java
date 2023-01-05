package com.sparc.lams_service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sparc.lams_service.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long>{

	List<Department> findAllByOrderByIdAsc();

}
