
package com.baobao.framework.spring;

import com.baobao.framework.support.web.context.BBHttpServletRequest;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequestEvent;
import javax.servlet.http.HttpServletRequest;


public class RequestContextListener extends org.springframework.web.context.request.RequestContextListener {

    private static final String REQUEST_ATTRIBUTES_ATTRIBUTE = RequestContextListener.class.getName() + ".REQUEST_ATTRIBUTES";

    public void requestInitialized(ServletRequestEvent requestEvent) {
        if (!(requestEvent.getServletRequest() instanceof HttpServletRequest)) {
            throw new IllegalArgumentException(
                    "Request is not an HttpServletRequest: " + requestEvent.getServletRequest());
        }
        HttpServletRequest request = new BBHttpServletRequest((HttpServletRequest) requestEvent.getServletRequest());
        ServletRequestAttributes attributes = new ServletRequestAttributes(request);
        request.setAttribute(REQUEST_ATTRIBUTES_ATTRIBUTE, attributes);
        LocaleContextHolder.setLocale(request.getLocale());
        RequestContextHolder.setRequestAttributes(attributes);
    }

    public void requestDestroyed(ServletRequestEvent requestEvent) {
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) requestEvent.getServletRequest().getAttribute(REQUEST_ATTRIBUTES_ATTRIBUTE);
        ServletRequestAttributes threadAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (threadAttributes != null) {
            // We're assumably within the original request thread...
            if (attributes == null) {
                attributes = threadAttributes;
            }
            LocaleContextHolder.resetLocaleContext();
            RequestContextHolder.resetRequestAttributes();
        }
        if (attributes != null) {
            attributes.requestCompleted();
        }
    }
}
