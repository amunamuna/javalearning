package com.nadou.redis.web;

import com.nadou.redis.Author;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nadou.redis.utils.RedisUtil;


/**
 * Created by amunamuna
 *2019/9/4 11:07
 **/
@RestController
@RequestMapping(value = "/poem")
public class AuthorController {

  private final static Logger logger = LoggerFactory.getLogger(AuthorController.class);

  @Autowired
  private RedisUtil redisUtil;

  @RequestMapping("/hello")
  public String hello(){
    Author user=new Author();
    user.setName("Alex");
    user.setIntro_l("不会打篮球的程序不是好男人");
    redisUtil.set("user",user);
    return "hello";
  }
  @RequestMapping("/test")
  public Object test(){
    return redisUtil.get("user");
  }
  @RequestMapping("/del")
  public String del(){
    redisUtil.del("user");
    return "del";
  }

}
