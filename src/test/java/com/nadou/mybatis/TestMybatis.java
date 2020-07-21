package com.nadou.mybatis;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import com.nadou.mybatis.web.entry.DemoApplication;
import com.nadou.mybatis.web.model.user.TbUUser;
import com.nadou.mybatis.web.service.user.ITbUUserService;

/**
 * Created by amunamuna
 *2019/10/9 14:59
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class})// 指定启动类
@Slf4j
public class TestMybatis {

  @Autowired
  private ITbUUserService userService;

  @Test
  public void test01() {
    List<TbUUser> userlist =  userService.getUserList();

    for (TbUUser user:userlist
    ) {
      log.info("result:"+user.toString());
    }
  }
}
