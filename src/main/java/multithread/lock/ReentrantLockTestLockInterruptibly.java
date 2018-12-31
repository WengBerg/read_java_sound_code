package multithread.lock;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTestLockInterruptibly {
    public static void main(String[] args) throws InterruptedException {
        final ReentrantLock lock = new ReentrantLock(true);

        final Thread t1 =     new Thread(new Runnable() {
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("我是终端锁，在等待被中断");
                    lock.lockInterruptibly();//此处如果是lock.lock(),及时线程2来中断也不会做任何响应.
                    System.out.println("如果我出现，则代表，我不能相应终端");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("我被打断了");
                } finally {
                    lock.unlock();
                }

            }
        });
        t1.start();

        Thread t2 =     new Thread(new Runnable() {

            public void run() {
                try {
                    lock.lock();
                    System.out.println(new Date() + ":我要睡5秒");
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("开始打断线程1");
                    t1.interrupt();
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("已经打断了线程1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        t2.start();

    }
}
