package DatabaseBaglanti;

import java.sql.*;


public class DatabaseConnection 
{
	
	private static Connection conn=null;
	private static DatabaseConnection databaseConnection=null;
	
	
	
	public  static Connection BaglantiKur()
	{
		try 
		{
		 conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##yalcin","Root1234");
		 return conn;
		} 
		catch (Exception e) 
		{
			return null;
		}
	}
	
	
	
	
	
	
	

	   
	
	
}
