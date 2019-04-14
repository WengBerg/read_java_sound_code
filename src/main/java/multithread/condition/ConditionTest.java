package multithread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    private int signal = 0;
    private Lock lock = new ReentrantLock();
    private Condition a = lock.newCondition();
    private Condition b = lock.newCondition();
    private Condition c = lock.newCondition();

    public void a(){
        lock.lock();
        while (signal != 0) {
            try {
                a.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("a");
        signal = 1;
        b.signal();
        lock.unlock();
    }

    public void b(){
        lock.lock();
        while (signal != 1) {
            try {
                b.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("b");
        signal = 2;
        c.signal();
        lock.unlock();
    }

    public void c(){
        lock.lock();
        while (signal != 2) {
            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("c");
        signal = 0;
        a.signal();
        lock.unlock();
    }

    public static void main(String[] args) {
        ConditionTest conditionTest = new ConditionTest();
        new Thread(new A(conditionTest),"A").start();
        new Thread(new B(conditionTest),"B").start();
        new Thread(new C(conditionTest),"C").start();
    }
}

class A implements Runnable {

    private ConditionTest c;

    public A(ConditionTest c) {
        this.c = c;
    }

    @Override
    public void run() {
        while (true)
        c.a();
    }
}
class B implements Runnable {

    private ConditionTest c;

    public B(ConditionTest c) {
        this.c = c;
    }

    @Override
    public void run() {
        while (true)
        c.b();
    }
}
class C implements Runnable {

    private ConditionTest c;

    public C(ConditionTest c) {
        this.c = c;
    }

    @Override
    public void run() {
        while (true)
        c.c();
    }
}
