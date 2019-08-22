package com.kfit.spring_boot_mybatis.config;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import com.kfit.spring_boot_mybatis.domain.Resource;
import com.kfit.spring_boot_mybatis.service.ResourceService;
/**
 * 读取数据库资源配置，返回资源列表
 * @author 64507
 *
 */
@Component
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	
	@Autowired
	private ResourceService resourceService;

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		
		AntPathMatcher matcher = new AntPathMatcher();
		
		String requestUrl = ((FilterInvocation)object).getRequestUrl(); //获取请求地址
		//获取资源配置表的所有配置信息(后期可考虑从缓存取)
		List<Resource> resourceList = resourceService.selectAll();
		//迭代
		for(Resource resourceBean:resourceList) {
			if(matcher.match(resourceBean.getUrl(), requestUrl)
					&&resourceBean.getRolesArray().length>0) { //如果请求地址在所有请求列表之内并且配置了角色
				//匹配成功，加入到要返回的权限列表中，权限校验转到AccessDecisionManager决定是否有访问权限
				return SecurityConfig.createList(resourceBean.getRolesArray());						
			}
		}
		
		//匹配不成功则返回一个特殊的role_none
		return SecurityConfig.createList("ROLE_NONE");
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return FilterInvocation.class.isAssignableFrom(clazz); //FilterInvocation持有对象相关联的http过滤器
	}

}
