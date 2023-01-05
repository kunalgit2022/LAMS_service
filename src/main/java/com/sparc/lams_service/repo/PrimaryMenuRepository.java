package com.sparc.lams_service.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sparc.lams_service.entity.Primarymenus;
public interface PrimaryMenuRepository extends JpaRepository<Primarymenus,Long>{
	@Query(value = "select * from primary_link order by seq", nativeQuery = true)
	List<Primarymenus> findAllprimarylink();

	List<Primarymenus> findAllByOrderBySeqAsc();
}
