package com.baobao.framework.utils;

import org.apache.log4j.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.net.URLEncoder;

public class CookieUtility {


    private final static Logger logger = Logger.getLogger(CookieUtility.class);


    /**
     * 获取 Cookie
     */
    public static Cookie getCookieByName(String name, HttpServletRequest request) {
        Cookie cookies[] = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (name.equals(cookie.getName())) {
                    return cookie;
                }
            }
        }
        return null;
    }

    /**
     * 删除cookie
     */
    public static void removeCookieByName(String name, HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = getCookieByName(name, request);
        if (cookie != null) {
            //设置过期时间为立即。
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
    }

    public static void writeCookie(String name, String value, HttpServletResponse response) {
        //使用URL进行编码，避免写入cookie错误。
        try {
            writeCookie(response, new Cookie(name, URLEncoder.encode(value, "UTF-8")));
        } catch (Exception ex) {
            logger.error("Encode with URL error", ex);
        }
    }

    public static void writeCookie(HttpServletResponse response, Cookie cookie) {
        //使用URL进行编码，避免写入cookie错误。
        try {
            response.addCookie(cookie);
        } catch (Exception ex) {
            logger.error("Encode with URL error", ex);
        }
    }



}
