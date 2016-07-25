package org.academiadecodigo.webserver;

import java.io.*;
import java.net.Socket;

/**
 * Created by <vi.KING_> Ralfe Elias on 16/06/16.
 */
public class ClientThreadDispatcher implements Runnable {

    private Socket client;

    public ClientThreadDispatcher(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {

        try {
            //read http request from client connection
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String line = reader.readLine();
            String header = "";
            String[] verifyGET = line.split(" ");
            //set the landing page to index.html
            verifyGET[1] = ((verifyGET[1].equals("/") || (verifyGET[1].isEmpty())) ? "/index.html" : verifyGET[1]);

            String[] fileType = verifyGET[1].split("\\/.*\\.");

            while (!line.isEmpty()) {
                header += line + "\n";
                line = reader.readLine();
            }

            System.out.println(header);

            if (verifyGET[0].equals("GET")) {

                try {
                    File file = new File("/Users/codecadet/Documents/Java_Exercises/bootcamp/webserver/web-root" + verifyGET[1]);

                    //prepare server response
                    DataOutputStream sendFile = new DataOutputStream(client.getOutputStream());
                    FileInputStream fileInputStream = new FileInputStream(file);
                    byte[] fileByContent = new byte[fileInputStream.available()];

                    switch (fileType[1]) {

                        case "html":

                            //send response to client
                            sendFile.writeBytes("HTTP/1.0 200 Document Follows\r\n");
                            sendFile.writeBytes("Content-Type: text/html; charset=UTF-8\r\n");
                            sendFile.writeBytes("Content-Length: " + fileByContent.length + "\r\n");
                            sendFile.writeBytes("\r\n");

                            fileInputStream.read(fileByContent);
                            sendFile.write(fileByContent);
                            sendFile.flush();
                            sendFile.close();
                            break;

                        case "css":

                            //send response to client
                            sendFile.writeBytes("HTTP/1.0 200 Document Follows\r\n");
                            sendFile.writeBytes("Content-Type: text/css; charset=UTF-8\r\n");
                            sendFile.writeBytes("Content-Length: " + fileByContent.length + "\r\n");
                            sendFile.writeBytes("\r\n");

                            fileInputStream.read(fileByContent);
                            sendFile.write(fileByContent);
                            sendFile.flush();
                            sendFile.close();
                            break;

                        case "jpg":

                            //send response to client
                            sendFile.writeBytes("HTTP/1.0 200 Document Follows\r\n");
                            sendFile.writeBytes("Content-Type: image/jpg; charset=UTF-8\r\n");
                            sendFile.writeBytes("Content-Length: " + fileByContent.length + "\r\n");
                            sendFile.writeBytes("\r\n");

                            fileInputStream.read(fileByContent);
                            sendFile.write(fileByContent);
                            sendFile.flush();
                            sendFile.close();
                            break;

                        case "png":

                            //send response to client
                            sendFile.writeBytes("HTTP/1.0 200 Document Follows\r\n");
                            sendFile.writeBytes("Content-Type: image/png; charset=UTF-8\r\n");
                            sendFile.writeBytes("Content-Length: " + fileByContent.length + "\r\n");
                            sendFile.writeBytes("\r\n");

                            fileInputStream.read(fileByContent);
                            sendFile.write(fileByContent);
                            sendFile.flush();
                            sendFile.close();
                            break;
                    }

                    client.close();
                } catch (FileNotFoundException e) {

                    File errorfile = new File("/Users/codecadet/Documents/Java_Exercises/bootcamp/webserver/web-root/404.html");

                    DataOutputStream sendFile = new DataOutputStream(client.getOutputStream());
                    FileInputStream fileInputStream = new FileInputStream(errorfile);
                    byte[] fileByContent = new byte[fileInputStream.available()];

                    sendFile.writeBytes("HTTP/1.0 200 Document Follows\r\n");
                    sendFile.writeBytes("Content-Type: text/html; charset=UTF-8\r\n");
                    sendFile.writeBytes("Content-Length: " + fileByContent.length + "\r\n");
                    sendFile.writeBytes("\r\n");

                    fileInputStream.read(fileByContent);
                    sendFile.write(fileByContent);
                    sendFile.flush();
                    sendFile.close();
                }

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
