package UyeListele;

import javafx.beans.property.SimpleStringProperty;

public class Uye 
{
	private SimpleStringProperty id;
	private SimpleStringProperty name;
	private SimpleStringProperty mobile;
	private SimpleStringProperty email;

	
	public Uye(String id,String name,String mobile,String email)
	{
		this.id=new SimpleStringProperty(id);
		this.name=new SimpleStringProperty(name);
		this.mobile=new SimpleStringProperty(mobile);
		this.email=new SimpleStringProperty(email);
		
	}
	
	public String getName() 
	{
		return name.get();
	}


	public String getId() {
		return id.get();
	}


	public String getMobile() {
		return mobile.get();
	}


	public String getEmail() {
		return email.get();
	}


	
}
