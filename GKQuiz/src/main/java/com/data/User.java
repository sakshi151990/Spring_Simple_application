package com.data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;





@Entity
@Table(name="USER")
public class User {
	
	public User(int userid, String name, String email) {
		super();
		this.userid = userid;
		this.name = name;
		this.setEmail(email);
	}
	public User() {

	}
	
	@Column(name="USERID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;
	
	@Id
	@Column(name="NAME")
	private String name;
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="FULLNAME")
	private String fullName;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Set<userRoles> getUseeroles() {
		return useeroles;
	}
	public void setUseeroles(Set<userRoles> useeroles) {
		this.useeroles = useeroles;
	}
	@OneToMany(mappedBy="user")
	private Set<userresult> userresults=new HashSet<userresult>();
	
	@OneToMany(mappedBy="user")
	private Set<userRoles> useeroles=new HashSet<userRoles>();
	public Set<userresult> getUserresults() {
		return userresults;
	}
	public void setUserresults(Set<userresult> userresults) {
		this.userresults = userresults;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	
}
