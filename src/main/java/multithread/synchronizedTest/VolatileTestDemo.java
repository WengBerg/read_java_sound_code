package multithread.synchronizedTest;

public class VolatileTestDemo {
    public static void main(String[] args) {
        VolatileDemo volatileDemo = new VolatileDemo();
        new Thread(volatileDemo).start();
        new Thread(volatileDemo).start();
        new Thread(volatileDemo).start();
        new Thread(volatileDemo).start();
        new Thread(volatileDemo).start();
        new Thread(volatileDemo).start();
        new Thread(volatileDemo).start();
        new Thread(volatileDemo).start();
        new Thread(volatileDemo).start();
        new Thread(volatileDemo).start();
        new Thread(volatileDemo).start();
        new Thread(volatileDemo).start();
        new Thread(volatileDemo).start();
        new Thread(volatileDemo).start();
        new Thread(volatileDemo).start();
        new Thread(volatileDemo).start();
        new Thread(volatileDemo).start();
        new Thread(volatileDemo).start();
        new Thread(volatileDemo).start();
    }
}

class VolatileDemo implements Runnable {
    public volatile int i = 0;
    @Override
    public void run() {
        for (int j = 0; j < 500; j++) {
            this.i++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
        System.out.println(i);
    }

    public int getI() {
        return i;
    }
}

