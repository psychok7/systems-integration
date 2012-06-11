package util;

import java.io.Serializable;


public class WebUser implements Serializable{
	private static final long serialVersionUID = 1L;
	private String email;
	private String password;
	private String name;
	private String type;
	
	public WebUser (String email,String password,String name,String type){
		this.email=email;
		this.password=password;
		this.name=name;
		this.type=type;
	}
    public WebUser(){
        
    }

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
	
	
}
