package com.nadou.mybatis.core.utils.request;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author zhangnannan  on 2017/1/13.
 * @version 1.0.0
 * @description 注册
 */
public class RegisterReqeust {

    @NotBlank(message = "邮箱不能为空",groups = {VGroupComRegister.class})
    @Pattern(regexp = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$",message = "邮箱格式不对",groups = {VGroupComRegister.class})
    @Length(max=45,message = "邮箱超出长度限制")
    private String email;

    @NotBlank(message = "手机号码不能为空",groups = {VGroupUserRegister.class})
    @Length(max=45,message = "手机号码超出长度限制")
    @Pattern(regexp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$",message = "手机号格式不对",groups = {VGroupUserRegister.class})
    private String phone;

    @NotBlank(message = "企业名称不能为空",groups = {VGroupComRegister.class})
    @Length(max=200,message = "企业名称超出长度限制")
    private String name;

    @NotBlank(message = "密码不能为空")
    @Length(max=45,message = "密码长度超出限制")
    private String pass;

    @NotBlank(message = "验证码不能为空",groups = {VGroupUserRegister.class})
    private String vcode;

    @Length(max=45,message = "联系人长度超出限制")
    private String contractPerson;

    @Length(max=45,message = "联系电话长度超出限制")
    private String contractPhone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getContractPerson() {
        return contractPerson;
    }

    public void setContractPerson(String contractPerson) {
        this.contractPerson = contractPerson;
    }

    public String getContractPhone() {
        return contractPhone;
    }

    public void setContractPhone(String contractPhone) {
        this.contractPhone = contractPhone;
    }

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
