package com.nadou.mybatis.core.utils.exception;

public class UserException extends RuntimeException {

	/*系统级别错误*/
	public static final UserException ArgError = new UserException("参数错误", 10000);
	public static final UserException InerError = new UserException("系统内部错误",10500);

	public static final UserException UserTokenExpiredError  = new UserException("用户TOKEN过期", 11004);
	public static final UserException UserTokenParseError= new UserException("用户TOKEN无效", 11005);
	public static final UserException AccessDeniedError = new UserException("没有访问权限",11006);
	public static final UserException NoExistUserError = new UserException("不存在的用户", 11007);
	public static final UserException NoUserPasswordError = new UserException("用户名或密码错误",11008);
	public static final UserException ImgVcodeError = new UserException("图片验证码不正确",11009);
	public static final UserException phoneVcodeError = new UserException("手机验证码不正确",11010);
	public static final UserException phoneVcodeFrequentError = new UserException("手机验证码发送频繁",11011);
	public static final UserException phoneFormatError = new UserException("手机号格式错误",11012);
	public static final UserException emailFormatError = new UserException("邮箱格式错误",11013);
	public static final UserException securityKeyError = new UserException("激活Key为空",11014);



	/**service层 错误**/
	public static final UserException UserPhoneExistError = new UserException("手机号已存在",12001);
	public static final UserException UserSaveByPhoneError = new UserException("保存失败",12002);
	public static final UserException UserEmailExistError = new UserException("邮箱已存在",12003);
	public static final UserException GetKeyError = new UserException("生成密钥token异常",12004);
	public static final UserException SendEmailRegistError = new UserException("发送注册邮件异常",12005);
	public static final UserException KeyExpiredError = new UserException("有效期已过",12006);
	public static final UserException UserActivatedError = new UserException("用户已激活",12007);
	public static final UserException UserNotExistError = new UserException("用户不存在",12008);
	public static final UserException KeyError = new UserException("错误的key",12009);
	public static final UserException TokenError = new UserException("错误的token",12010);
	public static final UserException DecryptKeyError = new UserException("解密密钥token异常",12011);
	public static final UserException SendPhoneCodeError = new UserException("发送手机验证码错误",12012);
	public static final UserException UserIsExist = new UserException("用户已存在",12013);
	public static final UserException ParamError = new UserException("参数错误",12014);
	public static final UserException UserIsNotActivatedError = new UserException("用户未激活",12005);


	int errorCode;
	String errorMessage;

	public UserException(String message, int errorCode) {
		super(message);
		this.errorMessage = message;
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
