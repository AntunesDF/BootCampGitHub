import java.io.*;
import java.net.Socket;

/**
 * Created by codecadet on 20/06/16.
 */
public class Client implements Runnable {

    private Socket clientSocket;
    private BufferedReader in;
    private BufferedWriter out;


    public static void main(String[] args) throws IOException {

        if (args.length != 2) {
            System.out.println("Usage: java ChatClient <host> <port>");
            System.exit(1);
        }

        try {
            new Client(args[0], Integer.parseInt(args[1]));

        } catch (NumberFormatException ex) {
            System.out.println("Invalid port number " + args[0]);
        }
    }


    public Client(String serverAddress, int serverPort) throws IOException {

        clientSocket = new Socket(serverAddress, serverPort);

        try {
            setupSocketStreams();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread t = new Thread(this);
        t.start();

        while (!clientSocket.isClosed()) {

            try {
                String chat = in.readLine();
                out.write(chat);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        close();
    }


    @Override
    public void run() {

        try {
            setupSocketStreams();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (!clientSocket.isClosed()) {

            try {
                String chat = in.readLine();
                System.out.println(chat);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        close();
    }


    public void setupSocketStreams() throws IOException {

        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

    }


    public void close() {

        try {

            if (clientSocket != null) {
                System.out.println("Closing client connection");
                clientSocket.close();
            }

        } catch (IOException ex) {
            System.out.println("Error closing connection: " + ex.getMessage());
        }
    }

}
