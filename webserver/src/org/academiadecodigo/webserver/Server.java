package org.academiadecodigo.webserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by <vi.KING_> Ralfe Elias on 15/06/16.
 */
public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(8080);
        System.out.println("Waiting for connection on port: " + server.getLocalPort());

        ExecutorService pool = Executors.newFixedThreadPool(5);

        while (true) {

            Socket client = server.accept();

            pool.submit(new ClientThreadDispatcher(client));

            //Thread thread = new Thread(new ClientThreadDispatcher(client));
            //thread.start();
        }

    }

}
