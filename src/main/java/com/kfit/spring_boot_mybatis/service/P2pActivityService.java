package com.kfit.spring_boot_mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kfit.spring_boot_mybatis.domain.P2pActivityRule;
import com.kfit.spring_boot_mybatis.mapper.P2pActivityRuleMappper;

@Service
public class P2pActivityService {
  
	
	@Autowired
	private P2pActivityRuleMappper p2pActivityRuleMappper;
	
	
	@Transactional//添加事务.
	public Integer save(P2pActivityRule demo){
		p2pActivityRuleMappper.save(demo);
		return demo.getId();
     }
}