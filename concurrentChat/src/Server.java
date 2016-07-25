import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by codecadet on 20/06/16.
 */
public class Server {

    private Socket clientSocket;
    private ServerSocket serverSocket;
    private BufferedReader in;
    private BufferedWriter out;

    //private String args[];
    private final CopyOnWriteArrayList<ClientManager> threadList = new CopyOnWriteArrayList<>();


    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Usage: java ChatServer [port]");
            System.exit(1);
        }

        try {
            new Server(Integer.parseInt(args[0]));

        } catch (NumberFormatException ex) {
            System.out.println("Invalid port number " + args[0]);
        }

    }


    public Server(int port) {

        Socket clientSocket;
        ServerSocket serverSocket;

        try {

            System.out.println("Binding to port " + port);
            serverSocket = new ServerSocket(port);

            while (true) {

                clientSocket = serverSocket.accept();

                ClientManager worker = new ClientManager(clientSocket);

                Thread t = new Thread(worker);

                t.start();

                threadList.add(worker);
            }

        } catch (IOException ioe) {

            System.out.println(ioe.getMessage());

        } finally {

            close();
        }
    }


    private class ClientManager implements Runnable {

        Socket clientSocket;
        BufferedReader in;
        BufferedWriter out;

        public ClientManager(Socket clientSocket) throws IOException {

            this.clientSocket = clientSocket;
            setupSocketStreams(this.clientSocket);

        }

        @Override
        public void run() {

            while (!clientSocket.isClosed()) {

                try {
                    String chat = in.readLine();
                    sendToAll(chat);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            close();
            threadList.remove(this);
        }

        public void send(String chat) throws IOException {

            out.write(chat);
            out.newLine();
            out.flush();
        }
    }


    private void sendToAll(String chat) {

        synchronized (threadList) {

            Iterator<ClientManager> it = threadList.iterator();

            while (it.hasNext()) {

                try {
                    it.next().send(chat);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }


    private void setupSocketStreams(Socket clientSocket) throws IOException {
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
    }


    private void close() {

        try {

            if (clientSocket != null) {
                System.out.println("Closing client connection");
                clientSocket.close();
            }

            if (serverSocket != null) {
                System.out.println("Closing server socket");
                serverSocket.close();
            }

        } catch (IOException ex) {
            System.out.println("Error closing connection: " + ex.getMessage());
        }
    }

}
