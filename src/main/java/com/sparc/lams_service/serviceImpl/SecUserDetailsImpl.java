package com.sparc.lams_service.serviceImpl;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.management.relation.RoleInfoNotFoundException;
import javax.management.relation.RoleNotFoundException;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparc.lams_service.entity.User;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@CrossOrigin(origins = "*",maxAge =3600 )
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class SecUserDetailsImpl implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long uid;
	@NonNull
	private String userId;
	private String uname;
	@NonNull
	private String designation;
	@NonNull
	private String mobile;
	@NonNull
	private String email;
	@NonNull
	private Integer roleId;

	
	@JsonIgnore
	@NonNull
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public static SecUserDetailsImpl build(User emp) {
//		List<SimpleGrantedAuthority> authorities = Set.of(emp.getMRole()).stream()
//				.map(x -> new SimpleGrantedAuthority(x.getRoleName().name())).collect(Collectors.toList());
		SecUserDetailsImpl impl = new SecUserDetailsImpl();
		impl.setUid(emp.getId());
		//impl.setAuthorities(authorities);
		impl.setDesignation(emp.getDesg());
		impl.setUserId(emp.getUserId());
		impl.setUname(emp.getUName());
		impl.setMobile(emp.getMobile());
		impl.setEmail(emp.getEmail());
		impl.setRoleId(emp.getRoleId());
		impl.setPassword(emp.getPassword());
		return impl;

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userId;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		SecUserDetailsImpl user = (SecUserDetailsImpl) obj;
		return Objects.equals(userId, user.getUserId());
	}

}
