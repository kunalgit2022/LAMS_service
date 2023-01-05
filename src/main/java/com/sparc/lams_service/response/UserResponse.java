package com.sparc.lams_service.response;

import lombok.Data;

@Data
public class UserResponse {
private int id;
private String name;
private String mobile;
private String email;
private String desg;
private String dept;
private String role;
private String createdat;
private String updatedat;
}
