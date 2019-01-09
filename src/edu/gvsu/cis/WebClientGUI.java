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
 * file name in the text field, then the console
 * @author Kyle Turske
 * @version 1.0
 * @
 */
public final class WebClientGUI {

	private static VBox scene;
	private WebClient client;
	
	private WebClientGUI() {

	}
	
	public static VBox clientScene() throws IOException {
		scene = new VBox(10);
		
		Label label = new Label("Enter client input!");
		TextField txtInput = new TextField();
		Button btnSend = new Button("SEND");
		TextArea txtOutput = new TextArea();
		txtOutput.setPrefColumnCount(50);
		txtOutput.setPrefRowCount(10);
		txtOutput.setEditable(false);
		btnSend.setOnAction(e -> {
			String input = txtInput.getText();
			WebClientTest.getClient().connectClient(input, txtOutput);
			/*try {
				
			} catch (IOException ioE){
				ioE.printStackTrace();
			}	*/	
			
		});
		
		
		scene.setSpacing(10);
		scene.setAlignment(Pos.CENTER);
		scene.getChildren().addAll(label, txtInput, btnSend, txtOutput);
		return scene;
	}
}
