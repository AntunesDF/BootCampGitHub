import java.io.BufferedReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * Created by codecadet on 15/06/16.
 */
public class Server {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public Server(int portNumber) throws IOException {

        String[] args = new String[0];

        // STEP1: Get parameters from command line arguments
        portNumber = Integer.parseInt(args[0]);


        // STEP2: Bind to local port and block while waiting for client connections
        ServerSocket serverSocket = new ServerSocket(portNumber);
        System.out.println("Server started: " + serverSocket);

        Socket clientSocket = serverSocket.accept();
        System.out.println("Waiting for a client connection");

        setupSocketStreams();
        System.out.println("Client accepted: " + clientSocket);
    }

    public void setupSocketStreams() throws IOException {

        // STEP3: Setup input and output streams

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }


    // STEP4: Read from/write to the stream



    public void close() {
        // STEP5: Close the streams
        // STEP6: Close the sockets
        try {

            if (clientSocket != null) {
                System.out.println("Closing client connection.");
                clientSocket.close();
            }

            if (serverSocket != null) {
                System.out.println("Closing server socket.");
                serverSocket.close();
            }


        } catch (IOException ex) {

            System.out.println("Error closing connection: " + ex.getMessage());

        }
    }
}
