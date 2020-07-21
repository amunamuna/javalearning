package com.nadou.mybatis.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nadou.mybatis.web.model.user.TbUUser;
import com.nadou.mybatis.web.service.user.ITbUUserService;


/**
 * @Classname UserController
 * @Description 用户测试控制类
 * @Author amunamuna
 * @Date
 * @Version 1.0
 */
@RestController
public class UserController {

    @Autowired
    private ITbUUserService userService;

    @GetMapping("/select")
    public List<TbUUser> select() {
        return userService.getUserList();
    }

    @GetMapping("/insert")
    public Boolean insert(TbUUser user) {
        return userService.save(user);
    }

}
