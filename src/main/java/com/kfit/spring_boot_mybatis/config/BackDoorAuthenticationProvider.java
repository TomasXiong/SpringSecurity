package com.kfit.spring_boot_mybatis.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class BackDoorAuthenticationProvider  implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName = authentication.getName();
		String passWord  = authentication.getCredentials().toString();
		
		if("xiongminming".equals(userName)) {
			Collection<GrantedAuthority>  authorityCollection  = new ArrayList<>(); 
			authorityCollection.add(new SimpleGrantedAuthority("ROLE_USER")); //SimpleGrantedAuthority实现GrantedAuthority接口
			authorityCollection.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			
			//UsernamePasswordAuthenticationToken继承AbstractAuthenticationToken，AbstractAuthenticationToken实现Authentication接口
			return new UsernamePasswordAuthenticationToken(userName,passWord,authorityCollection);
		}else {
			return null;
		}
		
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
