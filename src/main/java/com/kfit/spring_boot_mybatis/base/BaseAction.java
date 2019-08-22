package com.kfit.spring_boot_mybatis.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;

public class BaseAction {
	private static Logger logger  = Logger.getLogger(BaseAction.class);
    public void weixinUserWrite(HttpServletRequest request,HttpServletResponse response,Object obj) {
        try {
             //转为json  
            String jsonMap = JSON.toJSONString(obj,true);   
            response.setContentType("text/html;charset=UTF-8");  
            PrintWriter out = response.getWriter();
            out.print(jsonMap);//返回json数值  
            out.flush();  
            out.close();  
        } catch (IOException e) {
        	logger.info("返回参数发生异常:e==="+e.toString());
            logger.debug(e.getMessage());
            return;
        }
    }

}
