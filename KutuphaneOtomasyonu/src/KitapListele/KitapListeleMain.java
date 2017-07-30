package KitapListele;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class KitapListeleMain extends Application {
	 @Override
	    public void start(Stage stage) throws Exception {
	        Parent root = FXMLLoader.load(getClass().getResource("KitapListele.fxml"));
	        Scene scene = new Scene(root);
	        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        stage.setScene(scene);
	        stage.setTitle("Kitap Listesi");
	        stage.show();
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
}
