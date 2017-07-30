package UyeListele;

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

public class UyeListeleController implements Initializable
{
	@FXML
	private AnchorPane rootPane;
	
	ObservableList<Uye> list=FXCollections.observableArrayList();
	
	@FXML
	private TableView<Uye> tableView;
	
	@FXML
	private TableColumn<Uye,String> idCol;
	@FXML
	private TableColumn<Uye,String> nameCol;
	@FXML
	private TableColumn<Uye,String> mobileCol;
	@FXML
	private TableColumn<Uye,String> emailCol;
	
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
		idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
		nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
		mobileCol.setCellValueFactory(new PropertyValueFactory<>("mobile"));
		emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
		
		
	}
	
	
	private void loadData() 
	{
		
		ResultSet rs=null;
		PreparedStatement ps=null;
		String sorgu="SELECT * FROM MEMBER";
		
		try
		{
			ps=conn.prepareStatement(sorgu);
			rs=ps.executeQuery();
			while(rs.next())
			{
				String idx=rs.getString("ID");//getString içinde yazanlar veritabanýndaki kolon adlarý
				String namex=rs.getString("NAME");
				String mobilex=rs.getString("MOBILE");
				String emailx=rs.getString("MAIL");
				
				
				list.add(new Uye(idx,namex,mobilex,emailx));
			}
			
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		tableView.getItems().addAll(list);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
