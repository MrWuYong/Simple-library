package com.zw.bbs.dao;

import com.zw.bbs.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    int insertByRegister(User user);

    User selectByPrimaryKey(Integer id);

    User selectByUserCode(@Param("userCode") String userCode);

    User selectById(@Param("id")Integer id);
    String selectForPwd(@Param("id")Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}