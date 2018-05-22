package com.zw.bbs.dao;

import com.github.pagehelper.PageInfo;
import com.zw.bbs.model.Posts;
import com.zw.bbs.model.Topic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Posts record);

    List<Posts> selectAllByUserId(@Param("id")Integer id);

    List<Posts> selectForPage(@Param("id")Integer id);

    int insertSelective(Posts record);

    Posts selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Posts record);

    int updateByPrimaryKey(Posts record);
}