package com.hust.soict.namdinh.client_server;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import com.hust.soict.namdinh.helper.*;
import java.util.Arrays;

public class Server {
	public static void main (String args[]) {
		System.out.println("The Sorter Server is running!");
		int clientNumber = 0;
		try (ServerSocket listener = new ServerSocket(9898)) {
			while (true) {
				new Sorter(listener.accept(), clientNumber++).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}