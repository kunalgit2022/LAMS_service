package com.sparc.lams_service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sparc.lams_service.entity.Stage;

public interface StageRepository extends JpaRepository<Stage,Long>{

	List<Stage> findByLandClass(String landclass);

	List<Stage> findByStageCode(String stagecode);
}
