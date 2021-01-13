package com.nadou.thread;

/**
 *@ClassName Test
 *@Description TODO
 *@Author amunamuna
 *@Date 2020/8/3 10:46
 *@Version 1.0
 **/
public class Test {

  public static void main(String[] args) {
    String key = "11111111";
    int h;
    int hash =  (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    System.out.println(hash);
    System.out.println(15 & hash);

  }
}
