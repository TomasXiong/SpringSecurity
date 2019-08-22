package com.kfit.spring_boot_mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kfit.spring_boot_mybatis.domain.User;
import com.kfit.spring_boot_mybatis.mapper.UserMapper;


@Service
public class MyUserService implements UserDetailsService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userMapper.selectByUserName(username);
		if(user==null) {
			return null;
		}else {
			return user;
		}
		
	}
	
	
}