package com.baobao.ssmk.task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Administrator on 2017/11/20.
 */
public class DemoTask {
    private static final Logger LOGGER = LoggerFactory.getLogger(DemoTask.class);
    @Value("${task_run_status}")
    private String taskRunStatus;

    /**
     * 判断是否执行定时
     *
     * @return
     */
    private boolean isTaskRun() {
        return "Y".equalsIgnoreCase(taskRunStatus);
    }

    public void test1() {
        if (!isTaskRun())
            return;
        LOGGER.info("execute task updateNoDockingOrderStatus begin...");
    }
}
