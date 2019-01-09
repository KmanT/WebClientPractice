package edu.gvsu.cis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class WebClient {
	
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private String hostName;
	private int portNumber;
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	//private BufferedReader stdIn;
	
	public WebClient(int portNumber, String hostName) {
		this.hostName = hostName;
		this.portNumber = portNumber;
	}
	
	public void connectClient(String input) {
		try {
			startConnection();
			printInput(input);
			closeEverything();
		} catch (IOException ioE) {
			ioE.printStackTrace();
		}
	}
	
	private void startConnection() throws IOException {
		clientSocket = new Socket(hostName, portNumber);
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(
					new InputStreamReader(clientSocket.getInputStream()));
	}
	
	private void printInput(String input) throws IOException{
		//while (input != null) {
			out.println("GET " + input + " HTTP/1.0\r\n\r\n");
			out.flush();
			
			while (in.readLine() != null) {
				System.out.println(in.readLine());
			}
			
		//}
		
	}
	private void closeEverything() throws IOException{
		in.close();
		out.close();
		clientSocket.close();		
	}
}
