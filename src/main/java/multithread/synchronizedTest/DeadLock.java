package multithread.synchronizedTest;

public class DeadLock implements Runnable {
    private Object obj1;
    private Object obj2;
    DeadLock(Object obj1,Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public void run() {
        if(Thread.currentThread().getName().startsWith("A")) {
            synchronized (obj1) {
                System.out.println("obj1"+Thread.currentThread().getName());
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2) {
                    System.out.println("obj2"+Thread.currentThread().getName());
                }
            }
        } else if(Thread.currentThread().getName().startsWith("B")) {
            synchronized (obj2) {
                System.out.println("obj2"+Thread.currentThread().getName());
                synchronized (obj1) {
                    System.out.println("obj1"+Thread.currentThread().getName());
                }
            }
        }
    }

    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        DeadLock deadLock = new DeadLock(o1, o2);
        Thread a = new Thread(deadLock, "A");
        Thread b = new Thread(deadLock, "B");
        a.start();
        b.start();
/*        int a = 16;
        int b =  (1 << a);
        System.out.println(b);*/
    }
}