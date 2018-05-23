package com.baobao.ssmk.shiro;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;

public class MyRealm extends AuthorizingRealm {
    public static final Logger logger = LoggerFactory.getLogger(MyRealm.class);
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 验证当前登录的Subject
     * 本例中该方法的调用时机为LoginController.login()方法中执行Subject.login()时
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authcToken;
        String userName = usernamePasswordToken.getUsername();
        logger.info("login username:"+userName);
        if (StringUtils.isBlank(userName)) {
            throw new AuthenticationException("user name is null");
        }

        if(!userName.equals("qinpan")){
            throw new AuthenticationException("user is error");
        }

        return new SimpleAuthenticationInfo();
    }
}
