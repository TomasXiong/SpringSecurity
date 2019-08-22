package com.kfit.spring_boot_mybatis.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kfit.spring_boot_mybatis.base.ResponseBean;
/**
 * 无访问权限处理
 * @author 64507
 *
 */
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		
		    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
	        response.setContentType("application/json;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        ResponseBean info = new ResponseBean(500, accessDeniedException.getMessage(), null);
	        out.write(new ObjectMapper().writeValueAsString(info));
	        out.flush();
	        out.close();
		

	}

}
