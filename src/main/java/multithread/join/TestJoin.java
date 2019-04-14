package multithread.join;

public class TestJoin {

    public static void main(String[] args) {
/*        //循环五次
        for (int i = 0; i < 5; i++) {

            MyThread thread = new MyThread();
            //启动线程
            thread.start();
*//*            try {
                //调用join()方法
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*//*
            System.out.println("主线程执行完毕");
            System.out.println("~~~~~~~~~~~~~~~");

        }*/
        MyThread t1 = new MyThread("t1");
        MyThread t2 = new MyThread(t1, "t2");
        MyThread t3 = new MyThread(t2, "t3");
        t3.start();
        t1.start();
        t2.start();

    }
}

class MyThread extends Thread {

    private Thread thread;

    private String str;
    MyThread(Thread thread,String str) {
        this.thread = thread;
        this.str = str;
    }
    MyThread(String str) {
        this.str = str;
    }
    @Override
    public void run() {
        if(thread != null) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(str);
    }
}


