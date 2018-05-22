package com.zw.bbs.service;

import com.zw.bbs.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    User findByUserCode(String userCode);
    User findByUserName(String userCode);
    List<User> findAll();
    void login(User user);
    Map<String,Object> register(User user);
    User findById(Integer id);
    String findForPassword(Integer id);
    Map update(User oldUser,User newUser);
}
