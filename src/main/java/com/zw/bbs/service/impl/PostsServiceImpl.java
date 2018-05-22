package com.zw.bbs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zw.bbs.dao.PostsMapper;
import com.zw.bbs.model.Posts;
import com.zw.bbs.model.Topic;
import com.zw.bbs.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostsServiceImpl implements PostsService{
    @Autowired
    private PostsMapper postsMapper;
    @Override
    public PageInfo<Posts> findAsPage(PageInfo<Posts> pageInfo, Topic topic) {
        PageHelper.startPage(pageInfo);
        return new PageInfo<Posts>(postsMapper.selectForPage(topic.getId()));
    }

    @Override
    public Map<String,Object> insert(Posts posts) {
        Map<String,Object> map = new HashMap<String, Object>();
        boolean b = true;
        if (posts.getContentId()==null){
            b=false;
        }else if(!b||posts.getPostTopic()==null){
            b=false;
        }else if(!b||posts.getUserId()==null){
            b=false;
        }
        if (b){
            Integer num = postsMapper.insert(posts);
            map.put("resultType", num);
            if (num==1) {
//                map.put("id",posts.getId());
                map.put("resultInfo", "发帖成功");
            }else {
                map.put("resultInfo", "因为未知原因，帖子发布失败");
            }
        }else{
            map.put("resultType",-1);
            map.put("resultInfo","发帖失败");
        }
        return map;
    }

    @Override
    public Posts findById(Integer id) {
        return postsMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Posts> findByUserId(Integer id) {
        return postsMapper.selectAllByUserId(id);
    }

    @Override
    public int removeById(Integer id) {
        return postsMapper.deleteByPrimaryKey(id);
    }
}
