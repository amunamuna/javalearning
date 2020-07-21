package com.nadou.stream;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Created by amunamuna
 * skip(删除元素)
 *2019/11/12 9:32
 **/
public class SkipDemo {
  /**
   * 集合skip，删除前n个元素
   */
  @Test
  public void testSkip() {
    List<String> list = Arrays.asList("333","222","111");
    list.stream().skip(2).forEach(System.out::println);
  }

}
