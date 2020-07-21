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
public class SendValidCodeRequest {

    @NotBlank(message = "手机号码不能为空")
    @Pattern(regexp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$",message = "手机号格式不对")
    private String phone;
    @NotNull(message = "短信类型不能为空")
    private Integer flag;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
