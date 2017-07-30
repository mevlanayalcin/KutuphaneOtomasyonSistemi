package UyeEkle;

import java.net.URL;
import javafx.scene.Node;
import java.sql.*;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import DatabaseBaglanti.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

public class UyeEkleController implements Initializable
{
	@FXML
    private JFXTextField id;
    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField mobile;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXButton ekleButonu;
    @FXML
    private JFXButton iptalButonu;

    @FXML
    private AnchorPane rootPane;
    
   Connection conn;

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        conn=DatabaseConnection.BaglantiKur();
        if(conn==null)
        {
        	System.out.println("Baðlantý Kurulamadý");
        }
    }
    
    @FXML
    private void uyeEkle(ActionEvent event) throws SQLException
    {
    	
    	PreparedStatement preparedStatement=null;
    	ResultSet rs=null;
    	
    	
    	String uyeId=id.getText();
    	String uyeIsim=name.getText();
    	String uyeMobile=mobile.getText();
    	String uyeEmail=email.getText();
    	
    	if (uyeId.isEmpty() || uyeId.isEmpty() || uyeMobile.isEmpty() || uyeEmail.isEmpty()) 
    	{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Tüm alanlarý doldurunuz");
            alert.showAndWait();
            return;
        }
    	
    	String query="INSERT INTO MEMBER(ID,NAME,MOBILE,MAIL) VALUES(?,?,?,?)";
		
		try 
		{
			preparedStatement=conn.prepareStatement(query);
			preparedStatement.setString(1, uyeId);
			preparedStatement.setString(2, uyeIsim);
			preparedStatement.setString(3, uyeMobile);
			preparedStatement.setString(4, uyeEmail);
			rs=preparedStatement.executeQuery();
			
			if(rs!=null)
			{
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Üye Ekleme Ýþlemleri");
            alert.setContentText("Ekleme Baþarýyla Sonuçlandý");
            alert.showAndWait();
			}
			
			
		} 
		catch (Exception e) 
		{
			/*Burada ekleme iþleminde baþarýsýzlýk varsa o mesaj yazdýrýlýyor.Örneðin veritabanýnda
			 * id alaný primary key ve ayný id den eklemeye çalýþýrsanýz ekleme yapmaz ve rs null döner
			 * ama try catch çalýþtýracaðý için try içinde rs=preparedStatement.executeQuery(); bu kod çalýþmadýðý an
			 * direk olarak catch bloðuna atlar o yüzden baþarýsýzlýk hatasýný yukarýda rs==null diye if oluþturmadan
			 * burada kullandýk
			*/
			Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Üye Ekleme Ýþlemleri");
            alert.setContentText("BAÞARISIZ OLUNDU");
            alert.showAndWait();
			e.printStackTrace();
		}
		finally
		{
			
			preparedStatement.close();
			
			id.setText("");
			name.setText("");
			mobile.setText("");
			email.setText("");
			
		}
		
	}
    			
    					
    	
    	
    
    
    @FXML
    private void UyeIptal(ActionEvent event)
    {
    	( (Node)event.getSource() ).getScene().getWindow().hide();;
    }
    
    
    
    
    
    
}
