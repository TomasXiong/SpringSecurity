package com.kfit.spring_boot_mybatis.dao;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kfit.spring_boot_mybatis.domain.Demo;
import com.kfit.spring_boot_mybatis.mapper.DemoMapper;

@Repository("demoDao")
public class DemoDao {
	
	@Autowired 
	private DemoMapper demoMapper;
	
	public int insertSelective(Demo demo) {
		return  demoMapper.insertSelective(demo);
	}
    

    
}