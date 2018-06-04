package com.baobao.ssmk;/**
 * Created by Administrator on 2018/5/30.
 */

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Company:新概念保险
 * @Auth:秦盼（Q）
 * @Description:秦盼（Q）
 * @Date:Created in 17:15 2018/5/30
 * @Modified By:
 */
public class Main {
    public static void main(String[] args) {
/*        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"classpath*:META-INF/spring/applictionContext.xml"});
        context.start();*/
        com.alibaba.dubbo.container.Main.main(args);
    }
}
