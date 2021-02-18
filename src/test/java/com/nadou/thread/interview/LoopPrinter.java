package com.nadou.thread.interview;

import java.util.concurrent.Semaphore;

public class LoopPrinter {

    private static final int THREAD_COUNT = 3;
    static int result = 0;
    static int maxNum = 10;

    public static void main(String[] args) throws InterruptedException {
        final Semaphore[] semaphores = new Semaphore[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            semaphores[i] = new Semaphore(1);
            if (i != THREAD_COUNT - 1) {
                System.out.println(i + "===" + semaphores[i].getQueueLength());
                //获取一个许可前线程将一起阻塞，for循环之后只有semaphores[2]没有被阻塞
                semaphores[i].acquire();
            }
        }
        for (int i = 0; i < THREAD_COUNT; i++) {
            //初次执行，上一个信号量是semaphores[2]
            final Semaphore lastSemaphore = i == 0 ? semaphores[THREAD_COUNT - 1] : semaphores[i - 1];
            final Semaphore currentSemaphore = semaphores[i];
            final int index = i;
            new Thread(() -> {
                try {
                    while (true) {
                        //初次执行，让第一个for循环没有阻塞的semaphores[2]先获取到令牌阻塞
                        lastSemaphore.acquire();
                        System.out.println("thread" + index + ":" + result++);
                        if (result > maxNum) {
                            System.exit(0);
                        }
                        //释放当前信号量，semaphores[0]信号量此时为1，
                        currentSemaphore.release();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}

