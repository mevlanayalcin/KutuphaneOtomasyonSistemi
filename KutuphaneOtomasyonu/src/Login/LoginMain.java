package Login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginMain extends Application{

	@Override
	public void start(Stage stage) throws Exception
	{
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("Ayarlar.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Ayarlar");
        stage.show();
		
	}
	
	 public static void main(String[] args) {
	        launch(args);
	    }

}
