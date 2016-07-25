package creation;

import creation.MyThread;

/**
 * Created by codecadet on 16/06/16.
 */
public class ThreadLauncher {

    public static void main(String[] args) {

        MyThread myThread = new MyThread();
        myThread.run();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread((Runnable) new MyThread());
            thread.setName("AC-THREAD-" + i);
            thread.start();
        }

        Thread thread = new Thread((Runnable) myThread);
        thread.start();

    }
}
