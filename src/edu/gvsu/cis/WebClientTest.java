package edu.gvsu.cis;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class WebClientTest extends Application{

	private static Scene scene;
	private static WebClient client = new WebClient(8000, "localhost");
	private static final double WINDOW_WIDTH = 500;
	private static final double WINDOW_HIEGHT = 300;
	
    public static void main(String[] args) {
        launch(args);
    }
    
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
    
    public static WebClient getClient() {
    	return client;
    }
}