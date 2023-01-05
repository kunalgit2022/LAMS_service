package com.sparc.lams_service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sparc.lams_service.entity.LeaseCaseHistory;

public interface LeasecaseHistoryrepository extends JpaRepository<LeaseCaseHistory,Long>{
	List<LeaseCaseHistory> findByVilCodeAndLandClassAndLeaseCase(int village, int landclass, int leasecase);
}
