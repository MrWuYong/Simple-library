package com.zw.bbs.service;

import com.zw.bbs.model.Reply;

import java.util.List;

public interface ReplyService {
    List<Reply> findAllByPostId(Integer postId);
    int insert(Reply reply);
    int deleteByPostsId(Integer postsId);
}
