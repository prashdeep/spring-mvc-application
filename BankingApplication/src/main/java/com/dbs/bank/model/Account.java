package com.dbs.bank.model;

import javax.persistence.*;



import lombok.Data;

@Data
@Entity
@Table
public class Account {
	
	@Id
	private long accountNum;
	private String accountType;
	
	@ManyToOne
	@JoinColumn(name="cust_id", nullable = false)
	private Customer customer;
	
	private String branch;
	private String ifsc;
	
	
	public Account(long accountNum, String accountType, Customer customer) {
		super();
		this.accountNum = accountNum;
		this.accountType = accountType;
		this.customer = customer;
	}

	public Account(long accountNum, String accountType, Customer customer, String branch, String ifsc) {
		this.accountNum = accountNum;
		this.accountType = accountType;
		this.customer = customer;
		this.branch = branch;
		this.ifsc = ifsc;
	}

	
}
