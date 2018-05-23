package com.baobao.ssmk.exception;

/**
 * 系统异常处理类
 * @author
 * @since 2015-10-27
 */
public class SystemException extends BaseException {
	
	private static final long serialVersionUID = -3348092393094619874L;

	public SystemException(String code) {
		super();
		if(null != code) {
			super.code = code;
		}
	}
	
	public SystemException(BaseExceptionEnum exceptionEnum) {
		super();
		if(null != exceptionEnum) {
			super.code = exceptionEnum.getCode();
			super.message = exceptionEnum.getMessage();
		}
	}

}
