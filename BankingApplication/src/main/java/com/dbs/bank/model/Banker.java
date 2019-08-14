package com.dbs.bank.model;


import javax.persistence.*;



import lombok.Data;

@Data
@Entity
@Table
public class Banker {
	
	@Id
	private long id=1234;
	private String password="dbs@1234";
	
	@Override
	public String toString() {
		return "Banker [id=" + id + ", password=" + password + "]";
	}
	public Banker(long id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
}
