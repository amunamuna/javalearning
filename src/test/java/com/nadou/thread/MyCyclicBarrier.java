package com.nadou.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:CyclicBarrier的字面意思是可循环使用的屏障。
 * 让一组线程等待至某个状态之后再全部同时执行。
 * 线程间同步阻塞是使用的是ReentrantLock，可重入锁
 * 线程间通信使用的是Condition，Condition 将 Object 监视器方法（wait、notify 和 notifyAll）分解成截然不同的对象，以便通过将这些对象与任意 Lock 实现组合使用。
 * 执行结果:
    戈登到达集合点
    保罗到达集合点
    哈登到达集合点
     ****导游分发护照签证****
    哈登开始旅行啦～～
    戈登开始旅行啦～～
    保罗开始旅行啦～～
 */
public class MyCyclicBarrier {

    public static void main(String[] args) throws Exception{

        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,new TourGuideTask());
        ExecutorService executor = Executors.newFixedThreadPool(3);
        //登哥最大牌，到的最晚
        executor.submit(new TravelTask(cyclicBarrier,"哈登",5));
        executor.submit(new TravelTask(cyclicBarrier,"保罗",3));
        executor.submit(new TravelTask(cyclicBarrier,"戈登",1));

        executor.shutdown();
    }
}

class TravelTask implements Runnable{

    private CyclicBarrier cyclicBarrier;
    private String name;
    private int arriveTime;//赶到的时间

    public TravelTask(CyclicBarrier cyclicBarrier,String name,int arriveTime){
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
        this.arriveTime = arriveTime;
    }

    @Override
    public void run() {
        try {
            //模拟达到需要花的时间
            Thread.sleep(arriveTime * 1000);
            System.out.println(name +"到达集合点");
            cyclicBarrier.await();
            System.out.println(name +"开始旅行啦～～");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

class TourGuideTask implements Runnable{

    @Override
    public void run() {
        System.out.println("****导游分发护照签证****");
        try {
            //模拟发护照签证需要2秒
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}