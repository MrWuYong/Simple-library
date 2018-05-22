package com.zw.bbs.service.impl;

import com.zw.bbs.dao.ReplyMapper;
import com.zw.bbs.model.Reply;
import com.zw.bbs.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReplyServiceImpl implements ReplyService{
    @Autowired
    private ReplyMapper replyMapper;
    @Override
    public List<Reply> findAllByPostId(Integer postId) {
        return replyMapper.selectAllByPostId(postId);
    }

    @Override
    public int insert(Reply reply) {
        Integer floor = replyMapper.selectFloor(reply.getPostsId());
        if (floor==null){
            floor=1;
        }else {
            floor++;
        }
        reply.setFloor(floor);
        return replyMapper.insert(reply);
    }

    @Override
    public int deleteByPostsId(Integer postsId) {
        return replyMapper.deleteByPostsId(postsId);
    }
}
