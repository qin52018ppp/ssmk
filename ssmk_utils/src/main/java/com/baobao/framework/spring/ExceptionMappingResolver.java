
package com.baobao.framework.spring;
import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;  
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;  

/**
 * 异常处理类
 * ExceptionMappingResolver
 * @version 1.0.0
 * 
 */
public class ExceptionMappingResolver extends  
        SimpleMappingExceptionResolver {
	private static final Logger log = Logger.getLogger(ExceptionMappingResolver.class);
  
    @Override  
    protected ModelAndView doResolveException(HttpServletRequest request,  
            HttpServletResponse response, Object handler, Exception ex) {  
        // Expose ModelAndView for chosen error view.  
        String viewName = determineViewName(ex, request);  
        if (viewName != null) {
        	// 正常格式返回  
            if (!(request.getHeader("accept").indexOf("application/json") > -1 || (request  
                    .getHeader("X-Requested-With")!= null && request  
                    .getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1))) {  
                // 如果不是异步请求  
                // Apply HTTP status code for error views, if specified.  
                // Only apply it if we're processing a top-level request.  
                Integer statusCode = determineStatusCode(request, viewName);  
                if (statusCode != null) {  
                    applyStatusCodeIfPossible(request, response, statusCode);  
                }  
                return getModelAndView(viewName, ex, request);  
            } else {
            	// JSON格式返回  
                try {  
                    PrintWriter writer = response.getWriter();  
                    writer.write(ex.getMessage());  
                    writer.flush();  
                } catch (IOException e) {  
                	log.error(e);
                }  
                return null;  
  
            }  
        } else {  
            return null;  
        }  
    }  
}  