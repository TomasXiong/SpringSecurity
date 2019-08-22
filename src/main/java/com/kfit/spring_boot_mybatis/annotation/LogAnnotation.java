package com.kfit.spring_boot_mybatis.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 日志注解
 * @author 64507
 *
 */
@Target(ElementType.METHOD)  //方法注解(元注解)
@Retention(RetentionPolicy.RUNTIME) //运行时(元注解)
@Documented
public @interface LogAnnotation {
		
	String logRecord();  //注解只有成员变量，没有方法，方法名即为成员变量的名字，返回值类型即为该成员变量的类型，成员变量的类型必须是8种基本数据类型和类，接口，数组以及注解

}
