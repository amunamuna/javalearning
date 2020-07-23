package com.nadou.thread;

import java.util.concurrent.CountDownLatch;

/**
 *@ClassName MyCountDownLatch
 *@Description
 * 多线程并发编程中充当计时器,并且维护一个count的变量，并且其操作都是原子操作
 * 该类主要通过countDown()和await()两个方法实现功能的
 *@Author amunamuna
 *@Date 2020/7/23 09:08
 *@Version 1.0
 **/
public class MyCountDownLatch {

  private static final int COUNT = 7;
  private static final CountDownLatch countDownLatch = new CountDownLatch(COUNT);

  public static void main(String[] args) throws InterruptedException {
    long start = System.currentTimeMillis();
    for (int i = 0; i < COUNT; i++) {
      int index = i + 1;
      new Thread(() -> {
        try {
          System.out.println(index + "龙珠被找到");
          Thread.sleep(5000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        countDownLatch.countDown();
      }).start();
    }
    countDownLatch.await();//await()方法会一直阻塞，直到当前的count被减到0
    System.out.println("召唤神龙");
  }

}
