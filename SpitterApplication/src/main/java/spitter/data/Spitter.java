package spitter.data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Spitter {
	
	public Spitter() {
		
		
		
	}
	 
	
	private Long id;
	
	@NotNull
	@Size(min=5, max=16)
	private String username;
	private String password;
	public Spitter(Long id, String username, String password, String firstName, String lastName) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	private String firstName;
	private String lastName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Spitter(String username, String password, String firstName, String lastName) {
		super();
		
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
}
