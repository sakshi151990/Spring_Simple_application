package com.data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Id
	
	@Column(name="USERID")
	private int userid;
	@Column(name="NAME")
	private String name;
	@Column(name="EMAIL")
	private String email;
	
	@OneToMany(mappedBy="user")
	private Set<userresult> userresults=new HashSet<userresult>();
	
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
