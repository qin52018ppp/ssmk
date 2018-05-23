
package com.baobao.framework.support.web;

import com.baobao.framework.support.web.context.BBHttpServletRequest;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * XSSFilter
 * @description 防止 XSS 攻击，转义 表单中 HTML 脚本
 */
public class XSSFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(new BBHttpServletRequest((HttpServletRequest) request), response);
    }

    public void destroy() {
    }
}
