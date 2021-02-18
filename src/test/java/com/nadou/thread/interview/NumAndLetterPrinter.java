package com.nadou.thread.interview;

import java.util.concurrent.locks.LockSupport;

/**
 * 交替打印1A2B3C4D...26Z
 */
public class NumAndLetterPrinter {
    private static Thread numThread,letterThread;

    public static void main(String[] args) throws InterruptedException {
        letterThread = new Thread(() ->{
            for (int i = 0; i < 26; i++) {
                System.out.println((char)('A'+i));
                LockSupport.unpark(numThread);
                LockSupport.park();
            }
        },"letterThread");
        numThread = new Thread(() ->{
            for (int i = 1; i <=26; i++) {
                System.out.println(i);
                LockSupport.park();
                LockSupport.unpark(letterThread);
            }
        },"numThread");
//        Thread.sleep(1000);
        numThread.start();
        letterThread.start();
    }
}
