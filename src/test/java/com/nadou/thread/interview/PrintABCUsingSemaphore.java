package com.nadou.thread.interview;

import java.util.concurrent.Semaphore;

/**
 * 多线程循环打印ABC
 * 一般使用信号量解决是效率较高的方案，上一个线程持有下一个线程的信号量，通过一个信号量数组将全部关联起来，这种方式不会存在浪费资源的情况。
 */
public class PrintABCUsingSemaphore {
    private int times;
    private static Semaphore semaphoreA = new Semaphore(1);
    private static Semaphore semaphoreB = new Semaphore(0);
    private static Semaphore semaphoreC = new Semaphore(0);

    public PrintABCUsingSemaphore(int times){
        this.times = times;
    }

    public void print(String name,Semaphore current,Semaphore next){
        for (int i = 0; i < times; i++) {
            System.out.println("111:"+Thread.currentThread().getName());
            try {
                current.acquire();
                System.out.println(name);
                next.release();
                System.out.println("222:"+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        PrintABCUsingSemaphore printer = new PrintABCUsingSemaphore(1);
        new Thread(()->{
            printer.print("A",semaphoreA,semaphoreB);
        }).start();
        new Thread(()->{
            printer.print("B",semaphoreB,semaphoreC);
        }).start();
        new Thread(()->{
            printer.print("C",semaphoreC,semaphoreA);
        }).start();
    }
}
