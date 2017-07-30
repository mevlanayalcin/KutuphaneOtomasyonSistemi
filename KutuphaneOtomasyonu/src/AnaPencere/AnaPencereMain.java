package AnaPencere;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class AnaPencereMain extends Application {
	 @Override
	    public void start(Stage stage) throws Exception {
	        Parent root = FXMLLoader.load(getClass().getResource("/Login/Login.fxml"));
	        //Parent root = FXMLLoader.load(getClass().getResource("AnaPencere.fxml"));
	        Scene scene = new Scene(root);
	        scene.getStylesheets().add(getClass().getResource("AnaPencere.css").toExternalForm());
	        stage.setScene(scene);
	        stage.setTitle("KÜTÜPHANE OTOMASYON SISTEMI MEVLANA YALÇIN 2017");
	        stage.initStyle(StageStyle.TRANSPARENT);
	        stage.show();
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
}


