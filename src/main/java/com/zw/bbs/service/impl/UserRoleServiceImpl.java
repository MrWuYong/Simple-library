package com.zw.bbs.service.impl;

import com.zw.bbs.dao.UserRoleMapper;
import com.zw.bbs.model.UserRole;
import com.zw.bbs.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Override
    public List<UserRole> findAll() {
        return userRoleMapper.selectAll();
    }
}
