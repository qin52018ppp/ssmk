package com.baobao.framework.utils;

import java.io.Serializable;

/**
 * 保保网络科技-framework
 * com.baobao.framework.utils
 * 作者-秦岭(Tain)
 * 说明：hession结果返回结果数据BEAN
 * 2016/12/13 14:46
 * 2016保保网络-版权所有
 */
public class Result implements Serializable{

    public static String SUCCESS = "success";

    public static String FAILED = "failed";

    /**
     * 结果信息描述
     */
    private String message = SUCCESS;

    /**
     * 结果信息CODE
     */
    private String code = SUCCESS;

    /**
     * 其他结果回传数据
     */
    private Object object;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

}
