package co.alexwilkinson.models;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "employee")
public class Employee {
	
	private long id;
	private String email;
	private String position;
	private String firstname;
	private String lastname;
	private String address;
	private String employeecode;
	private String country;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getEmployeecode() {
		
		Random rand = new Random();
		
		int num = rand.nextInt(999999) + 1000;
		
		employeecode = firstname.substring(0, 3) + num 
				+ lastname.substring(lastname.length()-4, lastname.length()-2);
		
		return employeecode;
	}
	
	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
	}
	

}
