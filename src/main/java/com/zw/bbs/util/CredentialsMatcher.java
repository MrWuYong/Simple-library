package com.zw.bbs.util;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;

public class CredentialsMatcher implements org.apache.shiro.authc.credential.CredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken Token, AuthenticationInfo Info) {
        UsernamePasswordToken token=(UsernamePasswordToken)Token;
        String password =new String(token.getPassword());
        String rePassword = (String)Info.getCredentials();
        return rePassword.equals(password);
    }
}
