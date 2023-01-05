package com.sparc.lams_service.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sparc.lams_service.entity.Permission;

public interface permissionRepository extends JpaRepository<Permission,Long>{
	@Query(value = "SELECT permission.pid,primary_link.p_name from permission inner join primary_link on permission.pid=primary_link.id WHERE  permission.roleid=:roleid", nativeQuery = true)
	List<Object[]> findpermissionbyroleid(int roleid);
	@Query(value = "SELECT * from permission  WHERE  roleid=:roleid", nativeQuery = true)
	Permission findByRoleid(int roleid);
	void deleteByIdIn(List<Permission> permission);

	@Query(value = "delete from permission  WHERE  roleid=:roleid", nativeQuery = true)
	void deletebyRoleid(int roleid);

	@Query(value = "select * from udfn_deletemultiplepermission(:roleid)", nativeQuery = true)
	List<Object[]> getupdatedrecords(int roleid);
	
}
