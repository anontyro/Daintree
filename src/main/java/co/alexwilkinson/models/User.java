package co.alexwilkinson.models;

import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import co.alexwilkinson.auth.repository.model.Role;

@Entity
@Table(name= "mainuseraccess")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idmainuser;
	
	@NotNull @Email @NotEmpty
	private String email;
	
	@NotNull @NotEmpty
	private String username;
	
	@NotNull @NotEmpty
	private String password;
	
	private Set<Role> roles;
	
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
	
	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	public Set<Role> getRoles(){
		return roles;
	}
	
	public void setRoles(Set<Role>roles){
		this.roles = roles;
	}
	

}
