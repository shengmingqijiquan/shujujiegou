package Thread;

/**
 * Created by Administrator on 2017/6/28 0028.
 * 继承Thread类，重写该类的run()方法。
 */
public class MyThread extends Thread {
    private int i = 0;

    @Override
    public void run() {
        for (i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
