package UyeListele;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class UyeListeleMain extends Application {
	 @Override
	    public void start(Stage stage) throws Exception {
	        Parent root = FXMLLoader.load(getClass().getResource("UyeListele.fxml"));
	        Scene scene = new Scene(root);
	        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        stage.setScene(scene);
	        stage.setTitle("Üye Listesi");
	        stage.show();
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
}
