package com.hust.soict.namdinh.client_server;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//import java.io.PrintWriter;
//
//import java.net.Socket;
//import java.net.UnknownHostException;
//import java.util.Scanner;
//
//
//public class Client {
//	public static void main (String args[]) {
//		Socket socket;
//		try {
//			socket = new Socket("127.0.0.1", 9898);
//			BufferedReader in = new BufferedReader(new
//					InputStreamReader(socket.getInputStream()));
//			PrintWriter out = new
//					PrintWriter(socket.getOutputStream(), true);
//
//			System.out.println(in.readLine());
//			Scanner scanner = new Scanner(System.in);
//			String message = scanner.nextLine();
//			while (message != null) {
//				out.write(message);
//				out.flush();
//			}
//			socket.close();
//			scanner.close();
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        Socket socket = null;
        Scanner scanner = null;
        try {
            socket = new Socket("127.0.0.1", 9898);

            while (true) {
                BufferedReader in = new BufferedReader(new
                        InputStreamReader(socket.getInputStream()));
                PrintWriter out = new
                        PrintWriter(socket.getOutputStream(), true);

                scanner = new Scanner(System.in);

                StringBuilder message = new StringBuilder();
                String line = scanner.nextLine();
                while (!line.isEmpty()) {
                    message.append(line);
                    line = scanner.nextLine();
                }
                out.println(message);
                System.out.println(in.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                scanner.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}