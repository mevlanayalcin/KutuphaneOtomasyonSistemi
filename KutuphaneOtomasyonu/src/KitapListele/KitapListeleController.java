package KitapListele;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import DatabaseBaglanti.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class KitapListeleController implements Initializable
{
	@FXML
	private AnchorPane rootPane;
	
	ObservableList<Book> list=FXCollections.observableArrayList();
	
	@FXML
	private TableView<Book> tableView;
	
	@FXML
	private TableColumn<Book,String> idCol;
	@FXML
	private TableColumn<Book,String> titleCol;
	@FXML
	private TableColumn<Book,String> authorCol;
	@FXML
	private TableColumn<Book,String> publisherCol;
	@FXML
	private TableColumn<Book,String> availableCol;
	Connection conn=null;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		initCol();
		conn=DatabaseConnection.BaglantiKur();
        if(conn==null)
        {
        	System.out.println("Baðlantý Kurulamadý");
        }
        loadData();
		
	}

	

	private void initCol() 
	{
		titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
		idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
		publisherCol.setCellValueFactory(new PropertyValueFactory<>("publisher"));
		availableCol.setCellValueFactory(new PropertyValueFactory<>("available"));
		
	}
	
	
	private void loadData() 
	{
		
		ResultSet rs=null;
		PreparedStatement ps=null;
		String sorgu="SELECT * FROM BOOK";
		
		try
		{
			ps=conn.prepareStatement(sorgu);
			rs=ps.executeQuery();
			while(rs.next())
			{
				String titlex=rs.getString("TITLE");//getString içinde yazanlar veritabanýndaki kolon adlarý
				String idx=rs.getString("ID");
				String authorx=rs.getString("AUTHOR");
				String publisherx=rs.getString("PUBLISHER");
				String availablex=rs.getString("ISAVAIL");
				
				list.add(new Book(idx,titlex,authorx,publisherx,availablex));
			}
			
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		tableView.getItems().addAll(list);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
