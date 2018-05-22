package com.zw.bbs.service.impl;

import com.zw.bbs.dao.SexMapper;
import com.zw.bbs.model.Sex;
import com.zw.bbs.service.SexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SexServiceImpl implements SexService {
    @Autowired
    private SexMapper sexMapper;
    @Override
    public List<Sex> findAll() {
        return sexMapper.selectAll();
    }
}
