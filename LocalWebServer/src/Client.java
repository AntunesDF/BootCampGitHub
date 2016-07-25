import java.net.Socket;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by codecadet on 15/06/16.
 */
public class Client {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public Client(String hostName, int portNumber) throws IOException {

        String[] args = new String[0];

        // STEP1: Get the host and the port from the commandline
        hostName = args[0];
        portNumber = Integer.parseInt(args[1]);


        // STEP2: Open a client socket, blocking while connecting to the server
        Socket clientSocket = new Socket(hostName, portNumber);
        System.out.println("Connected to: " + clientSocket);

        setupSocketStreams();
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

        } catch (IOException ex) {

            System.out.println("Error closing connection: " + ex.getMessage());

        }
    }
}
