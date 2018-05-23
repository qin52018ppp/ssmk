package com.baobao.ssmk.exception;

/**
 *
 * @author
 * @since 2015-10-27
 */
public enum BusinessExceptionEnum implements BaseExceptionEnum {
	SUCCESS_EXCEPTION("00000", "成功"),
	LOGIN_ERROR("10001", "输入的用户名密码错误！")
	;
	private String code;
	
	private String message;
	
	BusinessExceptionEnum(String code, String message) {
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
