package multithread.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 *
 * @author Administrator
 *
 */
public class ReentrantReadWriteLockTest {
    public static void main(String[] args) {
        final ReadWrite rw = new ReadWrite();
        for (int i = 0; i < 3; i++) {
            Thread readThread = new Thread() {
                public void run() {
                    while (true) {
                        rw.read();
                    }
                }

            };
            readThread.setName("read"+i);
            readThread.start();

            Thread writeThread = new Thread() {
                public void run() {
                    while (true) {
                        rw.write(new Random().nextInt(10000));
                    }
                }

            };
            writeThread.setName("write"+i);
            writeThread.start();
        }

    }
}

/**
 * 读和写要互斥，因此要把它们放在同一个类中
 *
 * @author Administrator
 *
 */
class ReadWrite {
    private Object data = null;//共享数据，只能有一个线程写该数据，但可以有多个线程同时读该数据。
    ReadWriteLock rwl = new ReentrantReadWriteLock(true);

    /**
     * 读数据
     */
    public void read() {

        rwl.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " be ready to read data!");
            Thread.sleep((long) (Math.random() * 1000));
            System.out.println(Thread.currentThread().getName() + "have read data :" + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwl.readLock().unlock();
        }

    }

    /**
     * 写数据
     *
     * @param data
     */
    public void write(Object data) {

        rwl.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " be ready to write data!");
            Thread.sleep((long) (Math.random() * 1000));
            this.data = data;
            System.out.println(Thread.currentThread().getName() + " have write data: " + data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwl.writeLock().unlock();
        }

    }
}
