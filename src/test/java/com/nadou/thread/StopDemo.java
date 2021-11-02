package com.nadou.thread;

/**
 * @ClassName StopDemo
 * @Description stop的落幕
 * @Author amunamuna
 * @Date 2021/7/5 8:59 上午
 * @Version 1.0
 **/

public class StopDemo {

    /**
     * 1、输出结果：
     * t1获取到锁
     * t2获取到锁
     * t2结束
     * 2、当线程t1在获取到o1和o2两个锁开始执行，在还没有执行结束的时候，
     *  主线程调用了t1的stop方法中断了t1的执行，释放了t1线程获取到的所有锁，
     *  中断后t2获取到了o1和o2锁，开始执行直到结束，而t1却夭折在了sleep的时候，sleep后的代码没有执行。
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Object o1=new Object();
        Object o2=new Object();
        Thread t1=new Thread(()->{
            synchronized (o1)
            {
                synchronized (o2)
                {
                    try {
                        System.out.println("t1获取到锁");
                        Thread.sleep(5000);
                        System.out.println("t1结束");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        Thread.sleep(1000);
        Thread t2=new Thread(()->{
            synchronized (o1)
            {
                synchronized (o2)
                {
                    try {
                        System.out.println("t2获取到锁");
                        Thread.sleep(5000);
                        System.out.println("t2结束");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t2.start();
        t1.stop();
    }
}
