package com.hemand.ebanking.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class employeeLoginBean {
	
public String id,username,password,type;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name="name")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
    
	@Column(name="pass")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
