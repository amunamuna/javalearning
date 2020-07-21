package com.nadou.mybatis.core.utils.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author zhangnannan  on 2017/1/18.
 * @version 1.0.0
 * @description
 */
public class ResendEmailRequest {
    @NotBlank(message = "邮箱不能为空")
    @Pattern(regexp = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$",message = "邮箱格式不对")
    private String email;
    @NotNull(message = "邮件类型不能为空")
    private Integer flag;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
