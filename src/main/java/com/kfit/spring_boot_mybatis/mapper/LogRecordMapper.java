package com.kfit.spring_boot_mybatis.mapper;

import com.kfit.spring_boot_mybatis.domain.LogRecord;

public interface LogRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LogRecord record);

    int insertSelective(LogRecord record);

    LogRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LogRecord record);

    int updateByPrimaryKey(LogRecord record);
}