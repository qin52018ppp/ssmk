package com.baobao.ssmk.exception;

/**
 * 业务处理异常类
 * @author
 * @since 2015-10-27
 */
public class BusinessException extends BaseException {
	
	private static final long serialVersionUID = 8174736429360778072L;

	public BusinessException(String code) {
		super();
		if(null != code) {
			super.code = code;
		}
	}

	public BusinessException(String code, String message) {
		super();
		if(null != code) {
			super.code = code;
			super.message = message;
		}
	}
	
	public BusinessException(BaseExceptionEnum exceptionEnum) {
		super();
		if(null != exceptionEnum) {
			super.code = exceptionEnum.getCode();
			super.message = exceptionEnum.getMessage();
		}
	}

}
