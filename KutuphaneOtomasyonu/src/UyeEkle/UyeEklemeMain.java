package UyeEkle;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class UyeEklemeMain extends Application {
	 @Override
	    public void start(Stage stage) throws Exception {
	        Parent root = FXMLLoader.load(getClass().getResource("UyeEkle.fxml"));
	        Scene scene = new Scene(root);
	        scene.getStylesheets().add(getClass().getResource("UyeEkle.css").toExternalForm());
	        stage.setScene(scene);
	        stage.setTitle("Üye Ekleme Bölümü");
	        stage.show();
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
}
