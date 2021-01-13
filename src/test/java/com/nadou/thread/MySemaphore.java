package com.nadou.thread;

import java.util.concurrent.Semaphore;

/**
 *@ClassName MySemaphore
 *@Description Semaphore信号量主要用于两个目的，一个是用于多个资源的互斥作用，另一个用于并发线程数的控制
 * 无论是Synchroniezd还是ReentrantLock,一次都只允许一个线程访问一个资源,但是Semaphore可以指定多个线程同时访问某一个资源.
 *@Author amunamuna
 *@Date 2020/7/23 11:25
 *@Version 1.0
 **/
public class MySemaphore {
  public static void main(String[] args) {
    Semaphore semaphore = new Semaphore(3); //3个车位
    for(int i=1;i<7;i++){
      new Thread(new Runnable() {
        @Override
        public void run() {
          try {
            semaphore.acquire();
            System.out.println("线程"+Thread.currentThread().getName()+"抢到车位");
            Thread.sleep(3000);
            System.out.println("3秒后,线程"+Thread.currentThread().getName()+"释放车位");
          } catch (Exception e) {
            e.printStackTrace();
          }finally {
            semaphore.release();
          }
        }
      },String.valueOf(i)).start();

    }

  }
}
