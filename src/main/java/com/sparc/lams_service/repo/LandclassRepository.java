package com.sparc.lams_service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sparc.lams_service.entity.Landclass;

public interface LandclassRepository extends JpaRepository<Landclass,Long>{
	List<Landclass> findByOwnership(String owner);

	List<Landclass> findByOrderByIdAsc();
}
