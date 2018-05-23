package com.baobao.framework.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface LoginListener {
    /**
     * 登录成功后执行的方法
     *
     * @param authorization
     */
    void success(Authorization authorization, HttpServletRequest request, HttpServletResponse response);

    /**
     * 退出登录后执行的方法
     *
     * @param authorization
     */
    void logout(Authorization authorization);
}
