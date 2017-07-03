package Thread;

/**
 * Created by Administrator on 2017/6/28 0028.
 */
public class ThreadAndRunnable {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 30) {
                Runnable myRunnable = new MyRunnable();
                Thread thread = new MyThread1(myRunnable);
                thread.start();
            }
        }
    }
}

class MyRunnable implements Runnable {
    private int i = 0;

    @Override
    public void run() {
        System.out.println("in MyRunnable run");
        for (i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

class MyThread1 extends Thread {

    private int i = 0;

    public MyThread1(Runnable runnable) {
        super(runnable);
    }

    @Override
    public void run() {
        System.out.println("in MyThread1 run");
        for (i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

