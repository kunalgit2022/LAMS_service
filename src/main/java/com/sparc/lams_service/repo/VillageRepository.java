package com.sparc.lams_service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sparc.lams_service.entity.Village;

public interface VillageRepository extends JpaRepository<Village,Long>{
	@Query(value = "SELECT id,village FROM master_village", nativeQuery = true)
	List<Object> getVillagename();

	List<Village> findByPhase(String phase);
}
