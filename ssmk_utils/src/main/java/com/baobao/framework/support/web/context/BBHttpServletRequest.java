package com.baobao.framework.support.web.context;

import com.baobao.framework.utils.XssHtmlUtility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Created by Administrator on 2015/11/3.
 */
public class BBHttpServletRequest extends HttpServletRequestWrapper {
    public BBHttpServletRequest(HttpServletRequest request) {
        super(request);
    }

    public String getParameter(String name) {
        return XssHtmlUtility.encode(super.getParameter(name));
    }

    public String getOriginParameter(String name) {
        return super.getRequest().getParameter(name);
    }

    public String[] getParameterValues(String name) {
        String[] values = super.getParameterValues(name);
        if (null != values) {
            for (int i = 0; i < values.length; i++) {
                values[i] = XssHtmlUtility.encode(values[i]);
            }
        }
        return values;
    }

    public String[] getOriginParameterValues(String name) {
        return super.getRequest().getParameterValues(name);
    }

}
