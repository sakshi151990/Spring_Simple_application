package com.data;

import javax.annotation.Generated;
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
@Table(name="RESULT")
public class userresult {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RESULTID")
	private int resultid;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="NAME")
	private User user;
	
	@Column(name="USERESULT")
	private int useresult;
	@Column(name="CORRECT")
	private int correct;
	@Column(name="INCORRECT")
	private int incorrect;
	public userresult(User userid, int result, int correct, int incorrect) {
		super();
		this.user = userid;
		this.useresult = result;
		this.correct = correct;
		this.incorrect = incorrect;
	}
	public userresult() {
		// TODO Auto-generated constructor stub
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getResult() {
		return useresult;
	}
	public void setResult(int result) {
		this.useresult = result;
	}
	public int getCorrect() {
		return correct;
	}
	public void setCorrect(int correct) {
		this.correct = correct;
	}
	public int getIncorrect() {
		return incorrect;
	}
	public void setIncorrect(int incorrect) {
		this.incorrect = incorrect;
	}
	
}
