package com.kfit.spring_boot_mybatis.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import com.kfit.spring_boot_mybatis.domain.P2pActivityRule;

public interface P2pActivityRuleMappper {
	
	/**
	 * 保存数据.
	 */
	@Insert("INSERT INTO p2p_activity_rule(activity_id,rule_cycle,money_min,prize,begin_time,end_time,create_time,remark,valid_day,type_id)"
			+ " values(1,#{ruleCycle},#{moneyMin},#{prize},sysdate(),DATE_ADD(SYSDATE(),INTERVAL 3 day),sysdate(),#{remark},3,0)" )
	@Options(useGeneratedKeys=true,keyProperty="id",keyColumn="id")
	public Integer save(P2pActivityRule demo);
	
}
