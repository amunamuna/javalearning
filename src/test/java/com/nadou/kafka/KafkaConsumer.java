package com.nadou.kafka;

import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;

/**
 *@ClassName KafkaListener
 *@Description TODO
 *@Author amunamuna
 *@Date 2019/12/17 11:18 AM
 *@Version 1.0
 **/
@Slf4j
@Component
public class KafkaConsumer {

  @KafkaListener(topics = { "${kafka.topic}" })
  public void listen(ConsumerRecord<?, ?> record) {
    Optional<?> kafkaMessage = Optional.ofNullable(record.value());
    if (kafkaMessage.isPresent()) {
      String message = (String) kafkaMessage.get();
      JSONObject messageJSONObject = null;
      try {
        // 首先将message转换成json对象
        messageJSONObject = JSONObject.parseObject(message);
        System.out.println("==============="+messageJSONObject.toString());
      } catch (Exception e) {
        System.out.println("输入message: " + message + ",解析有误");
      }
    }
  }
}
