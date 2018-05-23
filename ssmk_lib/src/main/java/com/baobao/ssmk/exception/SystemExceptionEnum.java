package com.baobao.ssmk.exception;

/**
 * 系统异常枚举类
 * @author
 * @since 2015-10-27
 */
public enum SystemExceptionEnum implements BaseExceptionEnum {

	DB_ERROR_EXCEPTION("S0001", "数据库异常，请重试！"),
	SYS_ERROR_EXCEPTION("S0002", "系统异常，请重试！"),
	NO_SYS_EXCEPTION("S0003", "当前访问的服务不存在！"),
	SYS_LOGIN_EXCEPTION("S0004", "未登录，跳转登陆！"),
	SYS_AUTH_EXCEPTION("S0005", "暂无权限操作！")
	;
	
	private String code;
	
	private String message;

	private SystemExceptionEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String toString() {
		return super.toString() + "("+code+","+message+")";
	}
	
	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
