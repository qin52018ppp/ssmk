package com.baobao.framework.support.utility.timer;

import java.util.Date;

/**
 * 计划任务，定时执行
 */

public interface ScheduleIterator {

    /**
     * Returns the next time that the related {@link SchedulerTask} should be run.
     *
     * @return the next time of execution
     */
    public Date next();
}
