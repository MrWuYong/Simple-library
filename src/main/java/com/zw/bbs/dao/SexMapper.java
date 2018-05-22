package com.zw.bbs.dao;

import com.zw.bbs.model.Sex;

import java.util.List;

public interface SexMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sex record);

    int insertSelective(Sex record);

    Sex selectByPrimaryKey(Integer id);

    List<Sex> selectAll();

    int updateByPrimaryKeySelective(Sex record);

    int updateByPrimaryKey(Sex record);
}