package edu.gvsu.cis;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javafx.scene.control.TextArea;

/**<h1>WebClient</h1>
 * 
 * @author Kyle Turske
 * @version 1.0
 */
public class WebClient {
	
	private String hostName;
	private int portNumber;
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
	private PrintWriter txtWriter;
	private String inText;
	//private BufferedReader stdIn;
	
	/**
	 * Class constructor.
	 * @param portNumber The port which the web server is hosted on.
	 * @param hostName The name of the server.
	 */
	public WebClient(int portNumber, String hostName) {
		this.hostName = hostName;
		this.portNumber = portNumber;
	}
	
	/**
	 * This method is called when the user clicks "SEND" on the program. Calls
	 * startConnection, printInput, and closeEverything in order for the
	 * program to process the input.
	 * @param input The name of the file being processed. Entered in the text
	 * field.
	 * @param txt The text area for outputing the information. Used in the 
	 * printInput method.
	 */
	public void connectClient(String input, TextArea txt) {
		try {
			startConnection();
			printInput(input, txt);
			closeEverything();
		} catch (IOException ioE) {
			ioE.printStackTrace();
		}
	}
	
	/**
	 * Initializes the clientSocket, out, and in.
	 * @throws IOException if something goes wrong.
	 */
	private void startConnection() throws IOException {
		clientSocket = new Socket(hostName, portNumber);
		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(
					new InputStreamReader(clientSocket.getInputStream()));
		txtWriter = new PrintWriter(new File("./src/output.txt"));
		
	}
	
	/**
	 * Sends a request for a file to the web server.
	 * @param input The name of the file.
	 * @param txt The text area for the output.
	 * @throws IOException if something goes wrong.
	 */
	private void printInput(String input, TextArea txt) throws IOException{
		inText = "GET " + input + " HTTP/1.0\r\n\r\n";
		out.println(inText);
		while (in.readLine() != null) {
			//System.out.println(in.readLine());
			inText += in.readLine() + "\n";
		}
		txt.setText(inText);
		txtWriter.write(inText);
	}
	
	/**
	 * Closes the clientSocket, out, and in. Should be used when these objects 
	 * are initialized.
	 * @throws IOException if these objects are not initialized.
	 */
	private void closeEverything() throws IOException{
		txtWriter.close();
		in.close();
		out.close();
		clientSocket.close();		
	}
}
