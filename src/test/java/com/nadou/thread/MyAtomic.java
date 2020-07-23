package com.nadou.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;

/**
 *@ClassName MyAtomic
 *@Description 利用CAS解决原子性
 * 在 java.util.concurrent.atomic 包下提供了一些原子变量。
 * 		1. volatile 保证内存可见性
 * 		2. CAS（Compare-And-Swap） 算法保证数据变量的原子性
 * 			CAS 算法是硬件对于并发操作的支持
 * 			CAS 包含了三个操作数：
 * 			①内存值  V
 * 			②预估值  A
 * 			③更新值  B
 * 		    当且仅当 V == A 时， V = B; 否则，不会执行任何操作。
 * 举例:
 * 我们有10个线程分别去做自增操作，很明显count是共享变量，它将被这10个线程追杀加1。
 * 假如线程1将count追加到100时，正准备更新到101这一刻，线程2插一脚抢先一步把count追加到101，那么线程1该怎么办呢？
 * 它将获取最新的count值再去自增。因为value是被volatile修饰的
 *@Author amunamuna
 *@Date 2020/7/21 13:53
 *@Version 1.0
 **/
@Slf4j
public class MyAtomic {

  private static AtomicInteger index = new AtomicInteger(0);
//  private static int index = 0;//index++ index-- 不能保证原子操作性

  public static void main(String[] args) {
    int num = 100;
    ExecutorService executorService1 = Executors.newFixedThreadPool(num);
    for (int i = 0; i < num; i++) {
      executorService1.submit(new Runnable() {
        @Override
        public void run() {
          try {
            Thread.sleep(10);
//            index++;
            index.incrementAndGet();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      });
    }

    ExecutorService executorService2 = Executors.newFixedThreadPool(num);

    for (int i = 0; i < num; i++) {
      executorService2.submit(
          new Runnable() {
            @Override
            public void run() {
              try {
                Thread.sleep(10);
//                index--;
                index.decrementAndGet();
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            }
          });
    }

    executorService1.shutdown();
    executorService2.shutdown();
    while (true) {
      if (executorService1.isTerminated() && executorService2.isTerminated()) {
        log.info("index:" + index);
        break;
      }
    }
  }
}
