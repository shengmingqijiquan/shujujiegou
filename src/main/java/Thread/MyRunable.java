package Thread;

/**
 * Created by Administrator on 2017/6/28 0028.
 */
public class MyRunable implements Runnable {

        private int i = 0;

        @Override
        public void run() {
            for (i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
}

