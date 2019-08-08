package com.dbs.springmvcapp.controller;

import com.dbs.springmvcapp.model.Employee;
import com.dbs.springmvcapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class UserRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/users/", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<Employee> fetchAllEmployees(){
            return this.employeeService.listAll();
    }
}