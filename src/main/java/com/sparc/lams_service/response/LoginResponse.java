package com.sparc.lams_service.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class LoginResponse {
	private long id;
	private String userId;
	private String uname;
	private String designation;
	private String mobile;;
	private String email;
	private int roleid;	
	
	private String jwt;
	private String tokenType;

}
