package com.nadou.kafka;

import javax.annotation.PostConstruct;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *@ClassName KafkaApplication
 *@Description TODO
 *@Author amunamuna
 *@Date 2019/12/17 2:21 PM
 *@Version 1.0
 **/

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(value = "com.nadou.kafka")
public class KafkaApplication {

  public static void main(String[] args) {
    SpringApplication.run(KafkaApplication.class, args);
  }
}
