package KitapEkle;

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

public class AddBookController implements Initializable
{
	@FXML
    private JFXTextField title;
    @FXML
    private JFXTextField id;
    @FXML
    private JFXTextField author;
    @FXML
    private JFXTextField publisher;
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
    private void kitapEkle(ActionEvent event) throws SQLException
    {
    	
    	PreparedStatement preparedStatement=null;
    	ResultSet rs=null;
    	
    	
    	String bookId=id.getText();
    	String bookAuthor=author.getText();
    	String bookTitle=title.getText();
    	String bookPublisher=publisher.getText();
    	
    	if (bookId.isEmpty() || bookAuthor.isEmpty() || bookTitle.isEmpty() || bookPublisher.isEmpty()) 
    	{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Tüm alanlarý doldurunuz");
            alert.showAndWait();
            return;
        }
    	
    	String query="INSERT INTO BOOK(ID,TITLE,AUTHOR,PUBLISHER,ISAVAIL) VALUES(?,?,?,?,?)";
		
		try 
		{
			preparedStatement=conn.prepareStatement(query);
			preparedStatement.setString(1, bookId);
			preparedStatement.setString(2, bookTitle);
			preparedStatement.setString(3, bookAuthor);
			preparedStatement.setString(4, bookPublisher);
			preparedStatement.setString(5, "Yes");
			rs=preparedStatement.executeQuery();
			
			if(rs!=null)
			{
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Kitap Ekleme Ýþlemleri");
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
            alert.setHeaderText("Kitap Ekleme Ýþlemleri");
            alert.setContentText("BAÞARISIZ OLUNDU");
            alert.showAndWait();
			e.printStackTrace();
		}
		finally
		{
			
			preparedStatement.close();
			
			id.setText("");
			author.setText("");
			title.setText("");
			publisher.setText("");
			
		}
		
	}
    			
    					
    	
    	
    
    
    @FXML
    private void kitapIptal(ActionEvent event)
    {
    	( (Node)event.getSource() ).getScene().getWindow().hide();;
    }
    
    
    
    
    
    
}
