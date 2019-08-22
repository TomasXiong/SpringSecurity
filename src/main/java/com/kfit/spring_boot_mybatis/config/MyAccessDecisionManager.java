package com.kfit.spring_boot_mybatis.config;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
@Component
public class MyAccessDecisionManager implements AccessDecisionManager {

	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		//当前用户具有的权限
		Collection<? extends GrantedAuthority> auhthList = authentication.getAuthorities(); 
		//从configAttributes中获取访问资源所需要的角色，它来自MySecurityMetadataSource的getAttributes
		Iterator<ConfigAttribute> itList = (Iterator<ConfigAttribute>) auhthList.iterator();
		while(itList.hasNext()) {
			ConfigAttribute configAttribute = itList.next();
			String roles = configAttribute.getAttribute(); //访问该资源需要的角色
			if("ROLE_NONE".equals(roles)) { //如果该资源不需要访问角色
			 if (authentication instanceof AnonymousAuthenticationToken) { //如果认证对象是未授权的，匿名的
                    throw new BadCredentialsException("用户未登录");
                } else
                    return;
			}
			
			//逐一进行角色匹配,迭代该用户具有的权限
			for(GrantedAuthority grantedAuthority:auhthList) {
				if(grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
					return;
				}
				if(grantedAuthority.getAuthority().equals(roles)) {
					return;
				}
			}
			
		}
		
		 //不能完成匹配
        throw new AccessDeniedException("你没有访问" + object + "的权限!");
		

	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		
		return true;
	}

}
