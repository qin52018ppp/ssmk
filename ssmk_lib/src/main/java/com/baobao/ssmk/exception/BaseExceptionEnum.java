package com.baobao.ssmk.exception;

/**
 * 异常枚举接口类
 *
 * @author
 * @since 2015-10-27
 */
public interface BaseExceptionEnum {
    /**
     * 获取异常代码
     *
     * @return 异常代码
     */
    String getCode();

    /**
     * 获取异常信息
     *
     * @return 异常信息
     */
    String getMessage();
}
