package KitapListele;

import javafx.beans.property.SimpleStringProperty;

public class Book 
{
	private SimpleStringProperty title;
	private SimpleStringProperty id;
	private SimpleStringProperty author;
	private SimpleStringProperty publisher;
	private SimpleStringProperty available;
	
	public Book(String id,String title,String author,String publisher,String available)
	{
		this.id=new SimpleStringProperty(id);
		this.title=new SimpleStringProperty(title);
		this.author=new SimpleStringProperty(author);
		this.publisher=new SimpleStringProperty(publisher);
		this.available=new SimpleStringProperty(available);
	}
	
	public String getTitle() 
	{
		return title.get();
	}


	public String getId() {
		return id.get();
	}


	public String getAuthor() {
		return author.get();
	}


	public String getPublisher() {
		return publisher.get();
	}


	public String getAvailable() {
		return available.get();
	}
}
