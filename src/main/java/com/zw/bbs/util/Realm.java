package com.zw.bbs.util;

import com.zw.bbs.model.User;
import com.zw.bbs.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class Realm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
    @Autowired
    UserService userService;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;
        String userCode = token.getUsername();
        User user = userService.findByUserCode(userCode);
        if (user == null){
            throw new AuthenticationException("查找用户名失败");
        }
        Subject subject= SecurityUtils.getSubject();
        subject.getSession().setAttribute("user",user);
        subject.getSession().setAttribute("username",userCode);
        return  new SimpleAuthenticationInfo(user.getUserCode(),user.getPassword(),this.getClass().getName());
    }
}
