package com.kfit.spring_boot_mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfit.spring_boot_mybatis.dao.DemoDao;
import com.kfit.spring_boot_mybatis.domain.Demo;



@Service
public class DemoService {
	
	@Autowired 
	private DemoDao demoDao;

	/*@Autowired
	private DemoMappper demoMappper;*/

	
	/*public List<Demo> likeName(String name){
		return demoMappper.likeName(name);
	}
	
	
	public Demo getById(int id){
		return demoMappper.getById(id);
	}*/
	
	//@Transactional//添加事务.
	public void save(Demo demo){
		demoDao.insertSelective(demo);
	}
	
}
