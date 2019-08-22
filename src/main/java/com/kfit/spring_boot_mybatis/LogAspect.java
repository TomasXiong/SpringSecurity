package com.kfit.spring_boot_mybatis;

import java.lang.reflect.Method;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kfit.spring_boot_mybatis.annotation.LogAnnotation;
import com.kfit.spring_boot_mybatis.domain.LogRecord;
import com.kfit.spring_boot_mybatis.service.LogService;
import com.kfit.spring_boot_mybatis.utils.DateUtil;

/**
 * 编写切面
 * @author 64507
 *
 */
@Aspect
@Component
public class LogAspect {
	
	private long currentTime = 0L;
	
	@Autowired
	LogService logService;
	
	//配置切入点
	@Pointcut("@annotation(com.kfit.spring_boot_mybatis.annotation.LogAnnotation)")
	public void pointCut() {
		
	}
	
	/**
	 * 环绕通知
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	 @Around("pointCut()")
	  public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
	        Object result = null;
	        currentTime = System.currentTimeMillis();
	        result = joinPoint.proceed();
	        long wasteTime = System.currentTimeMillis() - currentTime;
	        LogRecord log = new LogRecord();
	        
	        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
	        Method method = methodSignature.getMethod();
	        
	        LogAnnotation logAnnotation = method.getAnnotation(com.kfit.spring_boot_mybatis.annotation.LogAnnotation.class);
	        //String record = logAnnotation.logRecord(); //切面记录
	        
	        String methodName = joinPoint.getTarget().getClass().getName()+"."+methodSignature.getName()+"()";
	        
	        Object[] objectArr = joinPoint.getArgs();
	        
	        log.setRequestMethod(methodName);
	        String requesTtime = DateUtil.getCurrentDate();
	        log.setRequestTime(requesTtime);
	        
	        logService.addRecord(log);
	        
	        System.out.println("===methodName="+methodName+" objectArr=="+objectArr);
	        
	        //核心方法，从joinPoint获取参数值
	        //logService.save(getUsername(), StringUtils.getIP(RequestHolder.getHttpServletRequest()),joinPoint, log);
	        return result;
	    }

}
