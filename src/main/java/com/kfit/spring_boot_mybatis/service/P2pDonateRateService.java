package com.kfit.spring_boot_mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfit.spring_boot_mybatis.domain.P2pCouponDonate;
import com.kfit.spring_boot_mybatis.domain.P2pDonateRate;
import com.kfit.spring_boot_mybatis.mapper.P2pDonateRateMapper;

@Service
public class P2pDonateRateService {
  
	
	@Autowired
	private P2pDonateRateMapper p2pDonateRateMapper;
	
	
	public List<P2pDonateRate> getP2pDonateRatelist(){
		
		return p2pDonateRateMapper.getP2pDonateRatelist();
	}
	
	
      public List<P2pCouponDonate> getP2pDonateRateRecord(String custName){
		
		return p2pDonateRateMapper.getP2pDonateRateRecord(custName);
	}
      
      
      public List<P2pCouponDonate> getP2pDonateRateRecordAll(){
  		
  		return p2pDonateRateMapper.getP2pDonateRateRecordAll();
  	}
	
}
