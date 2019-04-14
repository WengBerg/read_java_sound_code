package multithread.synchronizedTest;

import java.text.SimpleDateFormat;
import java.util.Date;

class SyncThread implements Runnable {

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        if (threadName.startsWith("A")) {
            async();
        } else if (threadName.startsWith("B")) {
            sync1();
        } else if (threadName.startsWith("C")) {
            sync2();
        }

    }

    /**
     * 异步方法
     */
    private void async() {
        try {
            System.out.println(Thread.currentThread().getName() + "_Async_Start: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "_Async_End: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 方法中有 synchronized(类.class) {} 同步代码块
     */
    private void sync1() {
        System.out.println(Thread.currentThread().getName() + "_Sync1: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        synchronized (SyncThread.class) {
            try {
                System.out.println(Thread.currentThread().getName() + "_Sync1_Start: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + "_Sync1_End: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * synchronized 修饰静态方法
     */
    private synchronized static void sync2() {
        System.out.println(Thread.currentThread().getName() + "_Sync2: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        try {
            System.out.println(Thread.currentThread().getName() + "_Sync2_Start: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "_Sync2_End: " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class SyncTest {

    public static void main(String... args) {
        Thread A_thread1 = new Thread(new SyncThread(), "A_thread1");
        Thread A_thread2 = new Thread(new SyncThread(), "A_thread2");
        Thread B_thread1 = new Thread(new SyncThread(), "B_thread1");
        Thread B_thread2 = new Thread(new SyncThread(), "B_thread2");
        Thread C_thread1 = new Thread(new SyncThread(), "C_thread1");
        Thread C_thread2 = new Thread(new SyncThread(), "C_thread2");
        A_thread1.start();
        A_thread2.start();
        B_thread1.start();
        B_thread2.start();
        C_thread1.start();
        C_thread2.start();
    }
}
