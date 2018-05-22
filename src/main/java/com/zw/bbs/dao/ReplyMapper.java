package com.zw.bbs.dao;

import com.zw.bbs.model.Reply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyMapper {
    int deleteByPrimaryKey(Integer id);

    List<Reply> selectAllByPostId(Integer id);

    Integer selectFloor(@Param("id")Integer id);

    Integer deleteByPostsId(Integer postsId);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);
}