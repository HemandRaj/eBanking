package com.hemand.ebanking.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class userEbankingBean {
	public String id,username,password,accountNumber,pin;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name="uname")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
    
	@Column(name="upass")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    @Column(name="account")
    public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	@Column(name="pin")
	public String getPin() {
		return pin;
	}	
	public void setPin(String pin) {
		this.pin = pin;
	}
}
