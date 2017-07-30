package Ayarlar;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.apache.commons.codec.digest.DigestUtils;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import javafx.scene.control.Alert;

public class Secimler 
{
	public static final String CONFIG_FILE="config.txt";
	int maksimumGunSayisi;
	double gunBasiCeza;
	String kullaniciadi;
	String password;
	
	
	public Secimler()
	{
		maksimumGunSayisi=30;
		gunBasiCeza=0.50;
		kullaniciadi="admin";	
		setPassword("admin");
	}

	public int getMaksimumGunSayisi() {
		return maksimumGunSayisi;
	}

	public void setMaksimumGunSayisi(int maksimumGunSayisi) {
		this.maksimumGunSayisi = maksimumGunSayisi;
	}

	public double getGunBasiCeza() {
		return gunBasiCeza;
	}

	public void setGunBasiCeza(double gunBasiCeza) {
		this.gunBasiCeza = gunBasiCeza;
	}

	public String getKullaniciadi() {
		return kullaniciadi;
	}

	public void setKullaniciadi(String kullaniciadi) {
		this.kullaniciadi = kullaniciadi;
	}

	public String getPassword() {
	
		return password;
	}

	public void setPassword(String password) {
		if(password.length()<16)
		{
		this.password =DigestUtils.shaHex(password);
		}
		else
		{
			this.password =password;
		}
	}
	
	
	public static void initConfig() throws IOException
	{
		Secimler secimler=new Secimler();
		Gson gson=new Gson();
		Writer writer=new FileWriter(CONFIG_FILE);
		gson.toJson(secimler,writer);
		writer.close();
	}
	
	
	public static Secimler getSecimler() throws IOException
	{
		Gson gson=new Gson();
		Secimler secimler=new Secimler();
		try 
		{
		 secimler=gson.fromJson(new FileReader(CONFIG_FILE), Secimler.class);
		} 
		catch (Exception e) 
		{
			initConfig();
			e.printStackTrace();
		} 
		return secimler;
	}
	
	public static void writeToFile(Secimler secimler) throws IOException
	{
		
		Gson gson=new Gson();
		Writer writer=new FileWriter(CONFIG_FILE);
		gson.toJson(secimler,writer);
		
		Alert alert=new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Ayarlar Kaydedildi");
		alert.setHeaderText(null);
		alert.setContentText("Ayarlarýnýz baþarý ile kaydedildi...");
		alert.showAndWait();
		
		writer.close();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
