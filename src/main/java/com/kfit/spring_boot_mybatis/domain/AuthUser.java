package com.kfit.spring_boot_mybatis.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthUser implements UserDetails  {
	
	private Integer userId;

    private String userName;

    private String password;
    
	private User user; //系统类
	private Set<GrantedAuthority> authorities; //权限列表
	
	//构造方法
	public AuthUser(User user,Set<GrantedAuthority> authorities) {
		this.user = user;
		this.authorities = authorities;
	}
	
	
	public AuthUser(Integer userId,String userName,String password) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}
	public AuthUser(Integer userId,String userName,String password,Set<GrantedAuthority> authorities) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.authorities = authorities;
	}
	
	
	 public Collection getRoles() {
	     
		// return authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
		 
		 Collection<GrantedAuthority> authorities = new ArrayList<>();
	        String username = this.getUsername();
	        if (username != null) {
	            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(username);
	            authorities.add(authority);
	        }
	        return authorities;
	      
	    }

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
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
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return getRoles();
	}
	
	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public void setPassword(String password) {
		this.password = password;
	}
}