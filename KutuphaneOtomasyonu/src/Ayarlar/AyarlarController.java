package Ayarlar;


import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class AyarlarController implements Initializable
{

	
	
	@FXML
    private JFXTextField maksimumGun;
    @FXML
    private JFXTextField cezaGun;
    @FXML
    private JFXTextField kullaniciAdi;
    @FXML
    private JFXPasswordField sifreAdi;
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		try {
			initDefaultValues();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	
	
    private void initDefaultValues() throws IOException 
    {
		Secimler secimler=Secimler.getSecimler();
		maksimumGun.setText(String.valueOf(secimler.getMaksimumGunSayisi()));
		cezaGun.setText(String.valueOf(secimler.getGunBasiCeza()));
		kullaniciAdi.setText(String.valueOf(secimler.getKullaniciadi()));
		sifreAdi.setText(String.valueOf(secimler.getPassword()));
	}


	@FXML
    private void kaydetButonuTiklandi(ActionEvent event) throws IOException
    {
		int kacGun=Integer.parseInt(maksimumGun.getText());
		double ceza=Double.parseDouble(cezaGun.getText());
		String kadi=kullaniciAdi.getText();
		String pass=sifreAdi.getText();
		
    	Secimler secimler=Secimler.getSecimler();
    	secimler.setMaksimumGunSayisi(kacGun);
    	secimler.setGunBasiCeza(ceza);
    	secimler.setKullaniciadi(kadi);
    	secimler.setPassword(pass);
    	
    	secimler.writeToFile(secimler);
    }
    
    
    @FXML
    private void iptalButonuTiklandi(ActionEvent event)
    {
    	((Stage)maksimumGun.getScene().getWindow()).close();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
}
