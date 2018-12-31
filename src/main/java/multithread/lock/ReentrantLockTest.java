package multithread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    public static void main(String[] args) {

        MyService service = new MyService();

        for(int i = 0 ; i < 50 ;i++) {
            new MyThread(service).start();
        }
/*        MyThread a1 = new MyThread(service);
        MyThread a2 = new MyThread(service);
        MyThread a3 = new MyThread(service);
        MyThread a4 = new MyThread(service);
        MyThread a5 = new MyThread(service);

        a1.start();
        a2.start();
        a3.start();
        a4.start();
        a5.start();*/

    }

    static public class MyService {

        private Lock lock = new ReentrantLock();

        public void testMethod() {

            try {
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                if(Thread.currentThread().getName().equals("10"))
                    Thread.interrupted();
                for (int i = 0; i < 5; i++) {
                    System.out.println("ThreadName=" + Thread.currentThread().getName() + (" " + (i + 1)));
                }
            }  finally {
                lock.unlock();
            }

        }

    }

    static public class MyThread extends Thread {

        private MyService service;

        public MyThread(MyService service) {
            super();
            this.service = service;
        }

        @Override
        public void run() {
            service.testMethod();
        }
    }
}

