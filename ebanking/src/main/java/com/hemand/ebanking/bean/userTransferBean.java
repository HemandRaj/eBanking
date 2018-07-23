package com.hemand.ebanking.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trans")
public class userTransferBean {

	public String id,accountNumber,credit,debit,bal,date;
    
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name="acc")
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	@Column(name="credit")
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	
	@Column(name="debit")
	public String getDebit() {
		return debit;
	}
	public void setDebit(String debit) {
		this.debit = debit;
	}
	
	@Column(name="bal")
	public String getBal() {
		return bal;
	}
	public void setBal(String bal) {
		this.bal = bal;
	}
	
	@Column(name="date")
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	

}
