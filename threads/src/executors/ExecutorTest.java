package executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by codecadet on 17/06/16.
 */
public class ExecutorTest {

    public static void main(String[] args) {

        ExecutorTest executorTest = new ExecutorTest();
        executorTest.test();

        System.out.println("Have submitted all threads to pool.");
        System.out.println("Currently " + Thread.activeCount() + " threads are still running");

    }

    private void test() {

        ExecutorService pool = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 10; i++) {
            System.out.println("Submitting new thread to pool: " + i);
            pool.submit(new MyThread(i, 3));
        }

        System.out.println("All threads submitted, will not accept new ones!");
        pool.shutdown();
    }

    private class MyThread implements Runnable {

        private int threadNum;
        private int countDown;

        public MyThread(int threadNum, int countDown) {
            this.countDown = countDown;
            this.threadNum = threadNum;
        }

        @Override
        public void run() {

            while (countDown > 0) {

                //do some sh1t

                System.out.println("Thread-" + threadNum + " countDown" + countDown);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                countDown--;
            }
        }
    }
}
