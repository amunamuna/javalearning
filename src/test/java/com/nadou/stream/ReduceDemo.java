package com.nadou.stream;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Created by amunamuna
 * reduce(聚合)
 *2019/11/12 9:33
 **/
public class ReduceDemo {
  /**
   * 集合reduce,将集合中每个元素聚合成一条数据
   */
  @Test
  public void testReduce() {
    List<String> list = Arrays.asList("欢","迎","你");
    String appendStr = list.stream().reduce("北京",(a,b) -> a+b);
    System.out.println(appendStr);
  }

}
