package com.zw.bbs.service.impl;

import com.zw.bbs.dao.UserMapper;
import com.zw.bbs.model.User;
import com.zw.bbs.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User findByUserCode(String userCode) {
        return userMapper.selectByUserCode(userCode);
    }
    public void login(User user){
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token =new UsernamePasswordToken(user.getUserCode(),user.getPassword());
        try {
            subject.login(token);
        }catch (AuthenticationException e){
            throw new AuthenticationException("用户名或密码错误");
        }
    }

    @Override
    public Map<String,Object> register(User user) {
        int num = userMapper.insertByRegister(user);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("resultType",num);
        if (num>=0){
            map.put("resultInfo","注册成功");
        }else {
            map.put("resultInfo","注册失败，请核对信息后重新注册");
        }
        return map;
    }

    @Override
    public User findById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public String findForPassword(Integer id) {
        return userMapper.selectForPwd(id);
    }

    @Override
    public Map<String,Object> update(User oldUser,User newUser) {
        if (newUser.getPassword()!=null){
            oldUser.setPassword(newUser.getPassword());
        }
        if (newUser.getSex()!=null){
            oldUser.setSex(newUser.getSex());
        }
        if (newUser.getUserName()!=null){
            oldUser.setUserName(newUser.getUserName());
        }
        int num = userMapper.updateByPrimaryKey(oldUser);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("resultType",num);
        if (num>=0){
            map.put("resultInfo","更新成功");
        }else {
            map.put("resultInfo","更新失败，请核对信息后重新注册");
        }
        return map;
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
