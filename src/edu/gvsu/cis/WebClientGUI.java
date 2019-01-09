package edu.gvsu.cis;

import java.io.IOException;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

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
		btnSend.setOnAction(e -> {
			String input = txtInput.getText();
			WebClientTest.getClient().connectClient(input);
			/*try {
				
			} catch (IOException ioE){
				ioE.printStackTrace();
			}	*/	
			
		});
		
		scene.setSpacing(10);
		scene.setAlignment(Pos.CENTER);
		scene.getChildren().addAll(label, txtInput, btnSend);
		return scene;
	}
}
