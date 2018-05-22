package com.zw.bbs.service.impl;

import com.zw.bbs.dao.ContentMapper;
import com.zw.bbs.model.Content;
import com.zw.bbs.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentMapper contentMapper;

    @Override
    public Integer insert(Content content) {
        int num = contentMapper.insert(content);
        Integer id = content.getId();
        return id;
    }

    @Override
    public Integer delete(Integer id) {
        return contentMapper.deleteByPrimaryKey(id);
    }
}
