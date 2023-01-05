package com.sparc.lams_service.serviceImpl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

import com.sparc.lams_service.entity.User;
import com.sparc.lams_service.repo.UserRepository;

import com.sparc.lams_service.request.LoginRequest;
import com.sparc.lams_service.response.LoginResponse;
import com.sparc.lams_service.service.IAuthService;
import com.sparc.lams_service.util.JwtUtil;
@CrossOrigin(origins = "*",maxAge =3600 )
@Service
public class AuthServiceImpl implements IAuthService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userrepo;

	@Autowired
	private JwtUtil jwtUtil;

	

	@Autowired
	private PasswordEncoder pwdEncoder;

	@Value("${fileLocation}")
	private String fileLocation;

	@Override
	public LoginResponse login(LoginRequest loginRequest) {

		try {
//			authenticationManager.authenticate(
//					new UsernamePasswordAuthenticationToken(loginRequest.getUserId(), loginRequest.getPassword()));
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUserId(), loginRequest.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwtToken = jwtUtil.generateJwtToken(authentication);
			SecUserDetailsImpl response = (SecUserDetailsImpl) authentication.getPrincipal();
			return new LoginResponse(response.getUid(),response.getUserId(), response.getUname(), response.getDesignation(),
					response.getMobile(),response.getEmail(), response.getRoleId(), jwtToken, "Bearer");
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("UserName or Password is Invalid");
		}
	}

	@Override
	public User registerUser(User empData) throws Exception {
		try {
			
			
			User addData = new User();
			addData.setUName(empData.getUName());
			addData.setMobile(empData.getMobile());
			addData.setEmail(empData.getEmail());
			addData.setPassword(pwdEncoder.encode(empData.getPassword().toString()));
			addData.setDeptId(empData.getDeptId());
			addData.setDesg(empData.getDesg());
			addData.setRoleId(empData.getRoleId());
			addData.setUserId(empData.getUserId());
			addData.setCreatedAt(empData.getCreatedAt());
			addData.setUpdatedAt(empData.getUpdatedAt());
			User save = userrepo.save(addData);
			if(save!=null)
			{}
			return save;

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
//	@Override
//	public String deleteEmployee(Integer id) {
//		Optional<Employee> optional = empRepo.findById(id);
//		if(optional.isPresent()) { 
//			empRepo.deleteById(id);
//			return "successfull";
//		}
//		else
//			return "emp not exist";
//	}

}
