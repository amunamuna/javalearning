package com.nadou.mybatis.core.utils;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/26
 * @version 1.0.0
 * @description 类的功能
 */
public class Constant {
	public static final String KEY_UUID = "uuid";
	public static final String KEY_UID = "uid";
	public static final long DEFAULT_UUID_EXPIRED_TIME = 7200L;  //默认TOKEN有效期为7200秒
	public static final String SESSION_VCODE = "vcode";  //验证码
	public static final String SESSION_PHNOE_CODE = "mcode";  //手机验证码
	public static final String SESSION_PHNOE_SENDTIME = "sendTime";  //手机验证码的发送时间
	public static final long SESSION_PHNOE_TIMELINESS = 120L;  //手机验证码时效为两分钟
}
