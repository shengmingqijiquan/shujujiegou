package Thread;

/**
 * Created by Administrator on 2017/6/28 0028.
 */

public class MyRunableTest {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 30) {
                Runnable myRunable = new MyRunable(); // 创建一个Runnable实现类的对象
                Thread thread1 = new Thread(myRunable); // 将myRunnable作为Thread target创建新的线程
                Thread thread2 = new Thread(myRunable);
                thread1.start(); // 调用start()方法使得线程进入就绪状态
                thread2.start();
            }
        }
    }

}

