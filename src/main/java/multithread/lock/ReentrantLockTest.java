package multithread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    public static void main(String[] args) {

        MyService service = new MyService();

/*        for(int i = 0 ; i < 50 ;i++) {
            new MyThread(service).start();
        }*/
        MyThread a1 = new MyThread(service,Thread.currentThread());
        MyThread a2 = new MyThread(service,a1);
        MyThread a3 = new MyThread(service,a2);
        MyThread a4 = new MyThread(service,a3);
        MyThread a5 = new MyThread(service,a4);

        a4.start();
        a1.start();
        a2.start();
        a5.start();
        a3.start();

    }

    static public class MyService {

        private Lock lock = new ReentrantLock(true);

        public void testMethod(Thread t) {

            try {
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("ThreadName=" + Thread.currentThread().getName() + (" " + (i + 1)));
                }
                if(Thread.currentThread().getName().equals("Thread-3")) {
                    t.interrupt();
                    System.out.println("中断线程2");
                }
            }  finally {
                lock.unlock();
            }

        }

    }

    static public class MyThread extends Thread {

        private MyService service;

        private Thread t;
        public MyThread(MyService service,Thread t) {
            super();
            this.service = service;
            this.t = t;
        }

        @Override
        public void run() {
            service.testMethod(t);
        }
    }
}

