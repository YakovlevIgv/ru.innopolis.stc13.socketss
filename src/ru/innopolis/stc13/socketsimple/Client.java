package ru.innopolis.stc13.socketsimple;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException{
        try (Socket socket = new Socket("127.0.0.1",Server.SERVER_PORT);
            OutputStreamWriter serverOutput = new OutputStreamWriter(socket.getOutputStream());
            InputStreamReader serverInput = new InputStreamReader(socket.getInputStream())){
            Scanner scanner = new Scanner(System.in);
            String message;
            BufferedReader bufferedReader = new BufferedReader(serverInput);
            while ((message = scanner.nextLine()).equals("")){
                BufferedWriter bufferedWriter = new BufferedWriter(serverOutput);
                bufferedWriter.write(message);
                bufferedWriter.newLine();
                bufferedWriter.flush();
                System.out.println("server echo"+ bufferedReader.readLine());
            }
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }


    }
}
