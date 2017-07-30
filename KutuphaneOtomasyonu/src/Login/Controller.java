package Login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.codec.digest.DigestUtils;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import Ayarlar.Secimler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Controller implements Initializable
{

	@FXML
	private JFXTextField kullaniciAdi;
	
	@FXML
	private JFXPasswordField sifreText;
	
	@FXML
	private Pane ust;
	
	Secimler secimler;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		try {
			secimler=Secimler.getSecimler();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@FXML
	private void girisButonuTiklandi(ActionEvent event) throws IOException
	{
		String username=kullaniciAdi.getText();
		String password=DigestUtils.shaHex(sifreText.getText());
		
		if(username.equals(secimler.getKullaniciadi()) && password.equals(secimler.getPassword()))
		{
			closeStage();
			loadMain();
		}
		else
		{
			Alert alert1=new Alert(Alert.AlertType.ERROR);
			alert1.setTitle("Giriþ Yapýlamadý");
			alert1.setHeaderText(null);
			alert1.setContentText("Kullanýcý adý veya þifre hatalý");
			alert1.showAndWait();
		}
		
	}
	
	private void closeStage() {
		((Stage)kullaniciAdi.getScene().getWindow()).close();
		
	}


	@FXML
	private void iptalButonuTiklandi(ActionEvent event)
	{
		((Stage)kullaniciAdi.getScene().getWindow()).close();
	}
	
	
	void loadMain() throws IOException
	{
		Parent parent=FXMLLoader.load(getClass().getResource("/AnaPencere/AnaPencere.fxml"));
		Stage stage=new Stage(StageStyle.DECORATED);
		stage.setTitle("Ana Menü");
		stage.setScene(new Scene(parent));
		stage.show();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}