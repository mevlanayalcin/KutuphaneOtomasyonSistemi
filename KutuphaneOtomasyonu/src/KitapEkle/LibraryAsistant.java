package KitapEkle;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class LibraryAsistant extends Application {
	 @Override
	    public void start(Stage stage) throws Exception {
	        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
	        Scene scene = new Scene(root);
	        scene.getStylesheets().add(getClass().getResource("AddBook.css").toExternalForm());
	        stage.setScene(scene);
	        stage.setTitle("Kitap Ekleme Bölümü");
	        stage.show();
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
}
