package com.sparc.lams_service.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sparc.lams_service.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

	Optional<User> findByUserId(String getuserId);
	
	@Query(value = "select master_user.u_name,master_user.mobile,master_user.email,master_user.desg,master_departmment.dept_name,\r\n"
			+ "master_role.role_name,cast(master_user.id as int) as id,cast(master_user.created_at as varchar(255)) as created_at,cast(master_user.updated_at as varchar(255)) as updated_at from master_departmment right join master_user on master_departmment.id=master_user.dept_id left join \r\n"
			+ "master_role on master_role.id=master_user.role_id", nativeQuery = true)
	List<Object[]> userwithrole();
	@Query(value = "select master_user.u_name,master_user.mobile,master_user.email,master_user.user_id,master_user.desg,master_user.dept_id,master_departmment.dept_name,\r\n"
			+ "master_user.role_id,master_role.role_name,cast(master_user.created_at as varchar(100)) as created_at,cast(master_user.updated_at as varchar(100)) as updated_at from master_departmment right join master_user on master_departmment.id=master_user.dept_id left join \r\n"
			+ "master_role on master_role.id=master_user.role_id where master_user.id=:id", nativeQuery = true)
	List<Object[]> userwithrolebyid(Long id);

}
