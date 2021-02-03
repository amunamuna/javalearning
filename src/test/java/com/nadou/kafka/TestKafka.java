package com.nadou.kafka;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

/**
 *@ClassName TestKafka
 *@Description TODO
 *@Author amunamuna
 *@Date 2019/12/16 3:48 PM
 *@Version 1.0
 **/
@Slf4j
public class TestKafka {

  @Test
  public void produceData(){
    Properties props = new Properties();
    props.put("bootstrap.servers", "gcsc01:9092,gcsc02:9092");
    props.put("acks", "all");
    props.put("retries", 0);
    props.put("batch.size", 16384);
    props.put("linger.ms", 1);
    props.put("buffer.memory", 33554432);
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    //自定义分区需要添加上我们自定义分区的那个类
//    props.put("partitioner.class", "cn.itcast.kafka.kafkaPartitioner.MyOwnPartitioner");


    Producer<String, String> producer = new KafkaProducer<String,String>(props);
    for (int i = 0; i < 100; i++){
      /// /    producer.send(new ProducerRecord<String, String>("test", Integer.toString(i), Integer.toString(i)));
      //kafka的第一种分区方式，如果给定了分区号，那么就直接将数据发送到指定的分区号里面去
      //producer.send(new ProducerRecord<String, String>("test",2,"helloworld",i+""));
      //kafka的第二种分区策略，没有给定分区号，给定了数据的key，那么就通过key取hashcode，将数据均匀的发送到三台机器里面去
      //注意如果实际工作当中，要通过key取上hashcode来进行分区，那么就一定要 保证key的变化，否则，数据就会全部去往一个分区里面
      /// producer.send(new ProducerRecord<String, String>("test",i+"",i+""));
      //kafka的第三种分区策略，既没有给定分区号，也没有给定数据的key值，那么就会按照轮循的方式进行数的发送
      producer.send(new ProducerRecord<String, String>("dataTest",i+""));
      //kafka的第四种分区策略，自定义分区类，实现我们数据的分区

    }
    producer.close();
  }

  @Test
  public void consumeData(){
    /**
     * 自动提交offset
     *
     */

        //这种写法是自动提交offset  偏移量，记录了我们消费到哪一条数据来了
        //offset记录了我们消息消费的偏移量，就是说我们上一次消费到了哪里
        //在kafka新的版本当中，这个offset保存在了一个默认的topic当中
        //每次消费数据之前，获取一下offset偏移量的值，就知道我们该要从哪一条数据消费
        //消费完成之后，offset的值要不要更新。消费完成之后，offset的值一定要更新，才不会造成重复消费的问题
        Properties props = new Properties();
        props.put("bootstrap.servers", "gcsc01:9092,gcsc02:9092");
        //设置我们的消费是属于哪一个组的，这个组名随便取，与别人的不重复即可
        props.put("group.id", "test");
        //设置我们的offset值自动提交
        props.put("enable.auto.commit", "true");
        //offset的值自动提交的频率 1 提交   1.5 消费了500调数据  1.6秒宕机了  2 提交offset
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String,String>(props);
        //消费者订阅我们的topic
        consumer.subscribe(Arrays.asList("dataTest"));
        //相当于开启了一个线程，一直在运行，等待topic当中有数据就去拉取数据
        while (true) {
            //push  poll
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records)
                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
       consumer.commitSync();

        }

      /*
      手动提交offset    如何保证spark消费kafka当中的数据 exactly  once
      如果数据正常处理，提交offset，如果数据处理失败，不要提交offset
       */
//    Properties props = new Properties();
//    props.put("bootstrap.servers", "node01:9092,node02:9092,node03:9092");
//    props.put("group.id", "test");
//    //关闭我们的offset的自动提交
//    props.put("enable.auto.commit", "false");
//    props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//    props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//    KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
//    consumer.subscribe(Arrays.asList("test"));
//    final int minBatchSize = 200;
//    List<ConsumerRecord<String, String>> buffer = new ArrayList<ConsumerRecord<String, String>>();
//    while (true) {
//      ConsumerRecords<String, String> records = consumer.poll(100);
//      for (ConsumerRecord<String, String> record : records) {
//        buffer.add(record);
//      }
//      if (buffer.size() >= minBatchSize) {
//        //   insertIntoDb(buffer);
//        //手动提交offset的值
//        consumer.commitSync();
//        buffer.clear();
//      }
//    }
  }
}
