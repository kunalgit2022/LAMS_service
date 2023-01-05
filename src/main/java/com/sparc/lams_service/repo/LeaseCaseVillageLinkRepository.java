package com.sparc.lams_service.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sparc.lams_service.entity.LeaseCaseVillageLink;

public interface LeaseCaseVillageLinkRepository extends JpaRepository<LeaseCaseVillageLink,Long>{
	Optional<LeaseCaseVillageLink> findByLeaseCaseno(String id);

	//List<LeaseCaseVillageLink> findByVilCodeAndLandClass(int village, String landclass);

	Optional<LeaseCaseVillageLink> findByVilCodeAndLandClassAndLeaseCaseno(int village, String landclass,
			String leasecase);

	

	List<LeaseCaseVillageLink> findByVilCodeAndLandClass(int village, String landclass);
}
