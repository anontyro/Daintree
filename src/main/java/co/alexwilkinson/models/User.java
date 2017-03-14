package co.alexwilkinson.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name= "mainuseraccess")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idmainuser;
	
	@NotNull
	private String email;
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
	public User(String username, String email, String password){
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	public User(){
		
	}

	public long getIdmainuser() {
		return idmainuser;
	}

	public void setIdmainuser(long idmainuser) {
		this.idmainuser = idmainuser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
