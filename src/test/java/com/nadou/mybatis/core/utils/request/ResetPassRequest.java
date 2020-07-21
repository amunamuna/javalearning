package com.nadou.mybatis.core.utils.request;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author zhangnannan  on 2017/1/17.
 * @version 1.0.0
 * @description
 */
public class ResetPassRequest {
    @NotBlank(message = "企业名称不能为空")
    private String name;

    @NotBlank(message = "密码不能为空")
    private String pass;

    @NotBlank(message = "重置密码时key不能为空")
    private String key;

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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
