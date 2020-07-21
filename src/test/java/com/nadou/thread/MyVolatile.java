package com.nadou.thread;

/**
 *@ClassName MyVolatile
 *@Description TODO
 *@Author amunamuna
 *@Date 2020/7/21 09:05
 *@Version 1.0
 **/
public class MyVolatile {

  public static void main(String[] args) {
    ThreadDemo demo = new ThreadDemo();
    new Thread(demo).start(); //开启线程

    while (true) { //while底层机制较高效，未重复去获取主内存flag值，除了volatile，另一种方法是加synchronized
      if (demo.isFlag()) {
        System.out.println("main thread is break");
        break;
      }
    }
  }
}

class ThreadDemo implements Runnable {

  //当flag未加上volatile时，结果：flag is true
  // 加上volatile两种结果：
  //  第一种:
  //  main thread is break
  //  flag is true
  //  第二种:
  //  flag is true
  //  main thread is break
  private volatile boolean flag = false;

  @Override
  public void run() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    flag = true;
    System.out.println("flag is true");
  }

  public boolean isFlag() {
    return flag;
  }

  public void setFlag(boolean flag) {
    this.flag = flag;
  }
}
