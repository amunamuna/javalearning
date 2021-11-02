package com.nadou.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import com.nadou.redis.utils.RedisUtil;
import com.nadou.redis.web.entry.DemoApplication;

import javax.xml.ws.Response;
import java.util.Date;
import java.util.UUID;


/**
 * Created by amunamuna
 *2019/9/4 10:15
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class TestRedis {

  @Autowired
  private RedisTemplate redisTemplate;

  @Autowired
  private RedisUtil redisUtil;

  @Test
  public void test() throws Exception{
    Author user=new Author();
    user.setName("Alex");
    user.setIntro_l("不会打篮球的程序不是好男人");
    redisUtil.set("aaa",user);
    log.info("result:"+redisUtil.get("aaa"));
  }

//  @Test
//  public void testObj() throws Exception {
//    Author user=new Author();
//    user.setName("Jerry");
//    user.setIntro_l("不会打篮球的程序不是好男人!");
//
//    ValueOperations<String, Author> operations=redisTemplate.opsForValue();
//    operations.set("502", user);
//    Thread.sleep(500);
//    boolean exists=redisTemplate.hasKey("502");
//    if(exists){
//      log.info(redisTemplate.opsForValue().get("502").toString());
//    }else{
//      log.info("exists is false");
//    }
//    // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
//  }
}
