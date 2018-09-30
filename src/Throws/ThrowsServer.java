package Throws;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ThrowsServer {
    public static Integer serverTPORT= 7000;

    public static void main(String[] args) {
        try (ServerSocket serverSocket= new ServerSocket(serverTPORT);

             Socket socket= serverSocket.accept();
             InputStream fromClient = socket.getInputStream();
             OutputStream toClient = socket.getOutputStream()) {
            System.out.println("server1_start");
            BufferedWriter clientWriter = new BufferedWriter(new OutputStreamWriter(toClient));
            BufferedReader clientReader = new BufferedReader(new InputStreamReader(fromClient));
            String message =null;
            while ((message = clientReader.readLine()) !=null){
                System.out.println(message);
                clientWriter.write("Message\""+ message +" resived by server" );
                clientWriter.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
