package com.baobao.ssmk.asynchronous;/**
 * Created by Administrator on 2018/5/23.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Company:新概念保险
 * @Auth:秦盼（Q）
 * @Description: 异步执行 方法集合
 * @Date:Created in 13:52 2018/5/23
 * @Modified By:
 */
@Service
public class DemoAsync {
    public static final Logger LOGGER = LoggerFactory.getLogger(DemoAsync.class);
    @Async
    public void asyncTest()  {
        LOGGER.info("asynchronous method execute begin.thread name is " + Thread.currentThread().getName());
        //TODO  执行异步方法的地方
        LOGGER.info("asynchronous method execute end.thread name is " + Thread.currentThread().getName());
    }
}
