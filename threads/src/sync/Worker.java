package sync;

/**
 * Created by codecadet on 16/06/16.
 */
public class Worker implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i < 8; i++) {

            System.out.println("WORKER: Working really hard man...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("WORKER: Some fcker just woke me up...");
            }

        }

        System.out.println("WORKER: Finished it mdfckers!");
    }
}
