package com.dbs.springmvcapp.model;

import lombok.Data;

import java.time.LocalDate;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table
public class Employee {

    public Employee(){}

    
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String name;
    private LocalDate dateOfBirth;
    private String departmentName;
	public Employee(String name, LocalDate dateOfBirth, String departmentName) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.departmentName = departmentName;
	}

    
}