package com.nadou.mybatis.core.utils.request;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author shuai.zhang  on 2016/11/13
 * @version 1.0.0
 * @description 登陆校验
 */
public class LoginReqeust {
	@NotBlank(message = "用户名不能为空a")
	String name;
	@NotBlank(message = "密码不能为空")
	String pass;

	@NotBlank(message = "验证码不能为空")
	String vcode;

	boolean remember;


	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

	public boolean isRemember() {
		return remember;
	}

	public void setRemember(boolean remember) {
		this.remember = remember;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
