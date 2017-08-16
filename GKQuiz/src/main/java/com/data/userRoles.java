package com.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER_ROLES")
public class userRoles {
	
	@Column(name="ROLE")
	private String role;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="NAME")
	private User user;
	
	@Id
	@Column(name="ROLE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int role_id;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	
	

}
