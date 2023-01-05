package com.sparc.lams_service.service;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

import com.sparc.lams_service.entity.User;
import com.sparc.lams_service.request.LoginRequest;
import com.sparc.lams_service.response.LoginResponse;
@CrossOrigin(origins = "*",maxAge =3600 )
public interface IAuthService {

	LoginResponse login(LoginRequest loginRequest);



	User registerUser(User empData)throws Exception;



	//String deleteEmployee(Integer id);

}
