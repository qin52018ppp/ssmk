package com.baobao.ssmk.common;


import com.baobao.ssmk.exception.BaseExceptionEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * @Company:新概念保险
 * @Auth:秦盼（Q）
 * @Description:
 * @Date:Created in 13:37 2017/12/11
 * @Modified By:
 */
public class Result {
    private String returnCode;
    private String returnMsg;
    private Object result;

    public Result(Object resut) {
        boolean isException = resut instanceof BaseExceptionEnum;
        if (isException) {
            BaseExceptionEnum exceptionEnum = (BaseExceptionEnum) resut;
            Map<String, Object> m = new HashMap<String, Object>();
            m.put("errorCode", exceptionEnum.getCode());
            m.put("errorMsg", exceptionEnum.getMessage());
            set(Constant.FAIL, exceptionEnum.getMessage(), m);
        } else {
            set(Constant.SUCCESS, "OK", resut);
        }
    }

    public Result(String errorMsg, String errorCode) {
        Map<String, Object> m = new HashMap<String, Object>();
        m.put("errorCode", errorCode);
        m.put("errorMsg", errorMsg);
        set(Constant.FAIL, errorMsg, m);
    }

    private void set(String returnCode, String returnMsg, Object resut) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
        this.result = resut;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
