package multithread.synchronizedTest;

public class VolatileOtherDemo {

    private volatile int count =0;


    public int getCount() {
        return this.count;
    }


    public void setCount() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count+=1;
    }


    public static void main(String[] args) {
        VolatileOtherDemo demo=new VolatileOtherDemo();
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    demo.setCount();
                }
            }).start();
        }
        while(Thread.activeCount()>1)
        {
            Thread.yield();
        }
        System.out.println(demo.getCount());
    }

}
