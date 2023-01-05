package com.sparc.lams_service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sparc.lams_service.entity.User;
import com.sparc.lams_service.repo.UserRepository;
import com.sparc.lams_service.service.IUserService;
@CrossOrigin(origins = "*",maxAge =3600 )
@Service
public class SecUserServiceImpl implements IUserService {

	@Autowired
	private UserRepository empRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String empName) throws UsernameNotFoundException {
		User emp = empRepo.findByUserId(empName)
				.orElseThrow(() -> new UsernameNotFoundException("User not Found WIth Id: " + empName));

		return SecUserDetailsImpl.build(emp);
	}

}
