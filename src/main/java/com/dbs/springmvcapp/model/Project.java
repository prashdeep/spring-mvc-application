package com.dbs.springmvcapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Project {

    @Id
    @GeneratedValue
    @Column(name="project_id")
    private long projectId;

    @Setter @Getter
    private String name;

    @Setter @Getter
    private String clientName;

    @ManyToMany
    @JoinTable(name="employee_projects", joinColumns={@JoinColumn(name = "project_id")}
            , inverseJoinColumns={@JoinColumn(name = "id")})
    @Setter @Getter
    private Set<Employee> employees = new HashSet<>();

}