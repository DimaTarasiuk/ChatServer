package com.dtarasiuk;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Scanner;

public class ServerMain {
    public static void main(String[] args) {
        int port = 8818;


        try {
            ServerSocket serverSocket = new ServerSocket(port); //port 8818
            while (true) {

                Socket clientSocket = serverSocket.accept(); //connection to server from client
                System.out.println("Connected to socket\n" + "\n");
                Scanner scanner = new Scanner(System.in);
                String s = scanner.next();
                OutputStream outputStream = clientSocket.getOutputStream();

                for (int i = 0; i < 10; i++) {
                    outputStream.write(("Response from server" + s + "\n").getBytes());
                    // Thread.sleep(1000);
                }
                //clientSocket.close();
                System.out.printf("connection closed");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}