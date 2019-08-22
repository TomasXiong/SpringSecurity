package com.kfit.spring_boot_mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfit.spring_boot_mybatis.domain.LogRecord;
import com.kfit.spring_boot_mybatis.domain.Resource;
import com.kfit.spring_boot_mybatis.mapper.LogRecordMapper;
import com.kfit.spring_boot_mybatis.mapper.ResourceMapper;

@Service
public class ResourceService {
  
	
	@Autowired
	private ResourceMapper resourceMapper;
	
	public List<Resource> selectAll() {
		return resourceMapper.selectAll();
	}
	
}