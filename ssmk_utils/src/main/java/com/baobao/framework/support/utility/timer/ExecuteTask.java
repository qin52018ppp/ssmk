package com.baobao.framework.support.utility.timer;

/**
 * Scheduler 与  ThreadPool 的封装 提供 了一个 服务接口
 */
public class ExecuteTask {

    private static Scheduler scheduler = new Scheduler();

    /**
     * 定时执行
     *
     * @param schedulerTask
     * @param iterator
     * @param execute
     */
    public static void executeTask(SchedulerTask schedulerTask, ScheduleIterator iterator, Boolean... execute) {
        if (null != execute && execute.length > 0 && execute[0]) {
            schedulerTask.run();
        }
        scheduler.schedule(schedulerTask, iterator);
    }

    /**
     * 线程迟,只要有任务存在就执行
     *
     * @param schedulerTask
     */
    public static void executeTask(Runnable schedulerTask) {
        ThreadPool.executeTask(schedulerTask);
    }
}
