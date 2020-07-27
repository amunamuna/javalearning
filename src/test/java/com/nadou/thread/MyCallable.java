package com.nadou.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *@ClassName MyCallable
 *@Description 实现callable接口,创建线程
 * 相较于实现Runnable接口的方式，方法可以有返回值，并且可以抛出异常
 *@Author amunamuna
 *@Date 2020/7/27 13:56
 *@Version 1.0
 **/
public class MyCallable {

  public static void main(String[] args) {
    Callable<String> callable = new Callable<String>() {
      @Override
      public String call() throws Exception {
        Thread.sleep(5000);
        return "call 方法执行..";
      }
    };
    //执行Callable方式，需要FutureTask实现类的支持，用于接受运算结果
    FutureTask<String> futureTask = new FutureTask<>(callable);
    new Thread(futureTask).start();
    try {
      //接受线程运算后的结果
      String result = futureTask.get();
      System.out.println(result);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
  }
}
