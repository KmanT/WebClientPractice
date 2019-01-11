package edu.gvsu.cis;

import java.io.IOException;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**<h1>WebClientGUI</h1>
 * This is the user interface for the program. Once the user enters the desired
 * file name in the text field, then file information is printed to the text
 * area.
 * @author Kyle Turske
 * @version 1.0
 */
public final class WebClientGUI {

	/**Holds the layout information.*/
	private static VBox scene;
	
	/**
	 * Private constructor.
	 */
	private WebClientGUI() {

	}
	
	/**
	 * Sets up the layout for the program.
	 * @return The actual GUI for the user to interact with. Contains a label
	 * telling the user what to do, a text field for the user to enter a file
	 * name, a button to send the data, and a text area to display the file
	 * information.
	 * @throws IOException if something goes wrong with the program.
	 */
	public static VBox clientScene() throws IOException {
		scene = new VBox(10);
		
		Label label = new Label("Enter the name of the desired file in your"
				+ " root directory!");
		TextField txtInput = new TextField();
		Button btnSend = new Button("SEND");
		TextArea txtOutput = new TextArea();
		txtOutput.setPrefColumnCount(50);
		txtOutput.setPrefRowCount(10);
		txtOutput.setEditable(false);
		btnSend.setOnAction(e -> {
			String input = txtInput.getText();
			WebClientTest.getClient().connectClient(input, txtOutput);
		});
		
		scene.setSpacing(10);
		scene.setAlignment(Pos.CENTER);
		scene.getChildren().addAll(label, txtInput, btnSend, txtOutput);
		return scene;
	}
}
