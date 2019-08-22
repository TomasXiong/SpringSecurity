package com.kfit.spring_boot_mybatis.mapper;

import java.util.List;

import com.kfit.spring_boot_mybatis.domain.Resource;

public interface ResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);
    
    List<Resource> selectAll();
}