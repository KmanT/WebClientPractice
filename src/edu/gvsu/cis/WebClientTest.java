package edu.gvsu.cis;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

/**<h1>WebClientRunner</h1>
 * This runs the entire program. Holds an instance of the the web client for 
 * the user to interact with through the GUI.
 * 
 * @author Kyle
 * @version 1.0
 */
public class WebClientTest extends Application{

	/**Holds the layout information. Gets it from WebClientGUI*/
	private static Scene scene;
	/**Instance of the client that interacts with the server*/
	private static WebClient client = new WebClient(8000, "localhost");
	/**The width of the window*/
	private static final double WINDOW_WIDTH = 500;
	/**The height of the window*/
	private static final double WINDOW_HIEGHT = 300;
	
	/**
	 * Launches the program
	 * @param args the arguments used inside the launch method.
	 */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * Sets the scene for the program.
     */
    @Override
    public void start(final Stage primaryStage) throws IOException{
    	primaryStage.setTitle("Web Client");
    	primaryStage.setWidth(WINDOW_WIDTH);
    	primaryStage.setHeight(WINDOW_HIEGHT);
    	scene =
			new Scene(WebClientGUI.clientScene(), WINDOW_WIDTH, WINDOW_HIEGHT);
    	primaryStage.setScene(scene);
    	primaryStage.show();
    }
    
    /**
     * Used so the GUI can interact with the client instance.
     * @return an instance of the WebClient.
     */
    public static WebClient getClient() {
    	return client;
    }
}