package MultyThrow;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static Integer CLIENT_PORT = 5998;

    public static void main(String[] args) {
        Listener listenerThread = new Listener(CLIENT_PORT);
        listenerThread.start();
        try (Socket socket = new Socket("127.0.0.1", Server.SERVER_PORT);
             BufferedWriter bufferedWriter = new BufferedWriter(
                     new OutputStreamWriter(socket.getOutputStream()))) {
            Scanner scanner = new Scanner(System.in);
            String message;
            while ((message = scanner.nextLine()) != "") {
                bufferedWriter.write(message);//+" a "+ socket.toString());
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}