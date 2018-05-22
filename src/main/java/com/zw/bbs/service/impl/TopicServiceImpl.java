package com.zw.bbs.service.impl;

import com.zw.bbs.dao.TopicMapper;
import com.zw.bbs.model.Topic;
import com.zw.bbs.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TopicServiceImpl implements TopicService{
    @Autowired
    private TopicMapper topicMapper;

    public List<Topic> findAll() {
        return topicMapper.selectAll();
    }
}
