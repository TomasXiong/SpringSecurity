package com.kfit.spring_boot_mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.kfit.spring_boot_mybatis.domain.P2pCouponDonate;
import com.kfit.spring_boot_mybatis.domain.P2pDonateRate;

public interface P2pDonateRateMapper {
	
	
	@Select("select id as id, product_cycle as productCycle,rate as rate from p2p_donate_rate  p where 1=1 "
			+ "AND DATE_FORMAT(p.validate_begin, '%Y-%m-%d') <= DATE_FORMAT(SYSDATE(), '%Y-%m-%d') "
			+ "AND DATE_FORMAT(p.validate_end,'%Y-%m-%d') >= DATE_FORMAT(SYSDATE(), '%Y-%m-%d') "
			+ "order by product_cycle asc")
	public List<P2pDonateRate> getP2pDonateRatelist();
	
	
	
	@Select(" SELECT t.cust_nm as custName,p.money as money,p.create_time  as createTime from p2p_coupon_donate p"
			+ " LEFT JOIN p2p_user_account t on p.user_id = t.user_id where t.cust_nm = #{custName} ORDER BY p.create_time desc ")
	public List<P2pCouponDonate> getP2pDonateRateRecord(String custName);
	
	
	@Select(" SELECT t.cust_nm as custName,p.money as money,p.create_time  as createTime from p2p_coupon_donate p"
			+ " JOIN p2p_user_account t on p.user_id = t.user_id where 1=1 and p.create_time>=DATE_ADD(SYSDATE(),INTERVAL -6 day) ORDER BY p.create_time desc ")
	public List<P2pCouponDonate> getP2pDonateRateRecordAll();
	
	
	
	

}
