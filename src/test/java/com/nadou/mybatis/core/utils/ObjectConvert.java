package com.nadou.mybatis.core.utils;

import java.util.Date;

import com.nadou.mybatis.core.utils.request.RegisterReqeust;
import com.nadou.mybatis.web.model.user.TbUUser;


/**
 * Copyright ©2016 Beijing Tender Union Information co , LTD
 *
 * @author zhangnannan  on 2017/1/13.
 * @version 1.0.0
 * @description
 */
public class ObjectConvert {

    public static TbUUser convertPhoneTbUUser(RegisterReqeust registerReqeust){
        TbUUser tbUUser= new TbUUser();
        tbUUser.setUuName(registerReqeust.getPhone());//用户名即手机号
        tbUUser.setUuPhone(registerReqeust.getPhone());
        tbUUser.setUuPassword(registerReqeust.getPass());
        tbUUser.setUuState(0);//未激活
        tbUUser.setUuCreateTime(new Date());
        return tbUUser;
    }

    public static TbUUser convertEmailTbUUser(RegisterReqeust registerReqeust){
        TbUUser tbUUser= new TbUUser();
        tbUUser.setUuEmail(registerReqeust.getEmail());
        tbUUser.setUuName(registerReqeust.getName());
        tbUUser.setUuPassword(registerReqeust.getPass());
        tbUUser.setUuContractPerson(registerReqeust.getContractPerson());
        tbUUser.setUuContractPhone(registerReqeust.getContractPhone());
        tbUUser.setUuState(0);//未激活
        tbUUser.setUuCreateTime(new Date());
        return tbUUser;
    }

}
