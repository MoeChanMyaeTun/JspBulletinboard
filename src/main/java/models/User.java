package models;

import java.security.MessageDigest;

public class User {
	private int id;
	private String name;
	private String email;
	private String password;
		
	public User(int id, String name, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password =password;
	}
	
	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
        this.password = passwordHash(password);
    }
	
	public static String passwordHash(String password) {
		try
		{
		MessageDigest md= MessageDigest.getInstance("SHA");
		md.update (password.getBytes ());
		byte[] rbt=md.digest();
		StringBuilder sb=new StringBuilder();
		for(byte b: rbt)
		sb.append(String.format("$02x", b));
		return sb.toString();
		}
		catch (Exception e) {
			return null;
		}
		
}
}
