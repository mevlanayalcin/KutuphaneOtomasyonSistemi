package Ayarlar;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class AyarlarMain extends Application {
	 @Override
	    public void start(Stage stage) throws Exception {
	        Parent root = FXMLLoader.load(getClass().getResource("Ayarlar.fxml"));
	        Scene scene = new Scene(root);
	        scene.getStylesheets().add(getClass().getResource("Ayarlar.css").toExternalForm());
	        stage.setScene(scene);
	        stage.setTitle("Ayarlar");
	        stage.show();
	        
	        //Secimler.initConfig();
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
}
