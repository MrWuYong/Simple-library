package com.zw.bbs.service;

import com.github.pagehelper.PageInfo;
import com.zw.bbs.model.Posts;
import com.zw.bbs.model.Topic;

import java.util.List;
import java.util.Map;


public interface PostsService {
    PageInfo<Posts> findAsPage(PageInfo<Posts> pageInfo, Topic topic);
    Map<String,Object> insert(Posts posts);
    Posts findById(Integer id);
    List<Posts> findByUserId(Integer id);
    int removeById(Integer id);
}
