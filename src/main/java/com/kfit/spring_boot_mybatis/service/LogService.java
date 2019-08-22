package com.kfit.spring_boot_mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kfit.spring_boot_mybatis.domain.LogRecord;
import com.kfit.spring_boot_mybatis.mapper.LogRecordMapper;

@Service
public class LogService {
  
	
	@Autowired
	private LogRecordMapper logRecordMapper;
	
	public int addRecord(LogRecord record) {
		return logRecordMapper.insert(record);
	}
	
}