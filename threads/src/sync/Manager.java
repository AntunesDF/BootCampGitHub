package sync;

/**
 * Created by codecadet on 16/06/16.
 */
public class Manager {

    public static void main(String[] args) {

        Thread worker = new Thread(new Worker());
        worker.start();

        System.out.println("MANAGER: Waiting for that fcker to finish.");

        try {
            worker.join();
            System.out.println("MANAGER: At last, the mdfcker finished it.");
        } catch (InterruptedException e) {
            System.out.println("MANAGER: That fcker ain't finished, but i'll wait.");
        }

    }

}
