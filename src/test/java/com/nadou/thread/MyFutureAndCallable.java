package com.nadou.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import lombok.extern.slf4j.Slf4j;

/**
 *@ClassName MyFutureAndCallable
 *@Description TODO
 *@Author amunamuna
 *@Date 2020/7/27 14:25
 *@Version 1.0
 **/
@Slf4j
public class MyFutureAndCallable {
  public static void main(String[] args) throws InterruptedException, ExecutionException {

    ExecutorService executorService = Executors.newSingleThreadExecutor();

    // 使用 Callable ，可以获取返回值
    Callable<String> callable = () -> {
      log.info("进入 Callable 的 call 方法");
      // 模拟子线程任务，在此睡眠 2s，
      // 小细节：由于 call 方法会抛出 Exception，这里不用像使用 Runnable 的run 方法那样 try/catch 了
      Thread.sleep(2000);
      return "Hello from Callable";
    };

    log.info("提交 Callable 到线程池");
    Future<String> future = executorService.submit(callable);
    long startTime = System.nanoTime();

    log.info("主线程继续执行");

    log.info("主线程等待获取 Future 结果");

//    第一种:通过调用 future.get() 方法会阻塞自己，直到子任务完成
//    String result = future.get();
//    log.info("主线程获取到 Future 结果: {}", result);
//    第二种:使用 Future 方法提供的 isDone 方法，检查 task 是否已经完成
    while (!future.isDone()) {
      System.out.println("子线程任务还没有结束...");
      Thread.sleep(1000);

      double elapsedTimeInSec = (System.nanoTime() - startTime) / 5000000000.0;

      // 如果程序运行时间大于 5s，则取消子线程的运行
      if (elapsedTimeInSec > 1) {
        future.cancel(true);
      }
    }
    // 通过 isCancelled 方法判断程序是否被取消，如果被取消，则打印日志，如果没被取消，则正常调用 get() 方法
    if (!future.isCancelled()) {
      log.info("子线程任务已完成");
      String result = future.get();
      log.info("主线程获取到 Future 结果: {}", result);
    } else {
      log.warn("子线程任务被取消");
    }
    executorService.shutdown();
  }
}
