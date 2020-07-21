package com.nadou.stream;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Created by amunamuna
 * limit（限制返回个数）
 *2019/11/12 9:29
 **/
public class LimitDemo {

  /**
   * 集合limit，返回前几个元素
   */
  @Test
  public void testLimit() {
    List<String> list = Arrays.asList("333","222","111");
    list.stream().limit(2).forEach(System.out::println);
  }

}
