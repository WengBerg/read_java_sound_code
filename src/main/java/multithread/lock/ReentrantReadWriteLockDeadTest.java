package multithread.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockDeadTest {

    public static void main(String[] args) throws Exception{

/*        final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
        System.out.println("readWriteLock.readLock().lock() begin");
        readWriteLock.readLock().lock();
        System.out.println("readWriteLock.readLock().lock() over");


        new Thread(){
            @Override
            public void run() {


                for(int i = 0; i< 10; i++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    System.out.println(" ");
                    System.out.println("Thread readWriteLock.readLock().lock() begin i:"+i);
                    readWriteLock.readLock().lock(); // 获取过一次就能再次获取, 但是若其他没有获取的线程因为 syn queue里面 head.next 是获取write的线程, 则到 syn queue 里面进行等待
                    System.out.println("Thread readWriteLock.readLock().lock() over i:" + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }.start();

//        Thread.sleep(1 * 1000);

        System.out.println("readWriteLock.writeLock().lock() begin");
        *//*readWriteLock.writeLock().lock();*//*
        System.out.println("readWriteLock.writeLock().lock() over");*/

        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
/*                System.out.println(Thread.currentThread().getName()+":"+"writeLock");
                readWriteLock.writeLock().lock();
                System.out.println(Thread.currentThread().getName()+":"+"readLock");
                readWriteLock.readLock().lock();
                System.out.println("succeed");
                readWriteLock.readLock().unlock();*/
                while (true) {
                    readWriteLock.readLock().lock();
                    System.out.println(Thread.currentThread().getName()+":"+"readLock");
                    readWriteLock.readLock().unlock();
                }
            }
        };

        new Thread(runnable).start();

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+":"+"readLock");
                readWriteLock.readLock().lock();
                System.out.println(Thread.currentThread().getName()+":"+"writeLock");
                readWriteLock.writeLock().lock();
                System.out.println(Thread.currentThread().getName()+":"+"succeed");
                readWriteLock.writeLock().unlock();
            }
        };

        Thread thread = new Thread(runnable2);
        thread.start();

    }
}
