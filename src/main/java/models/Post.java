package models;

public class Post {
	private int id;
	private String book_name;
	private String author;
	private String price;
	private String description;
	private String image;
	
	public Post(int id, String book_name, String author, String price, String description, String image) {
		super();
		this.id = id;
		this.book_name = book_name;
		this.author = author;
		this.price = price;
		this.description = description;
		this.image = image;
	}
	public Post(String book_name, String author, String price, String description, String image) {
		super();
		this.book_name = book_name;
		this.author = author;
		this.price = price;
		this.description = description;
		this.image = image;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
		
}
