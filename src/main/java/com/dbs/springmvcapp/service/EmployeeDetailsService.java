package com.dbs.springmvcapp.service;

import com.dbs.springmvcapp.model.Employee;
import com.dbs.springmvcapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class EmployeeDetailsService implements UserDetailsService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Employee> optionalEmployee =  this.employeeRepository.findByName(username);
        if(!optionalEmployee.isPresent()){
            throw new IllegalArgumentException("User not found");
        }
        Employee employee = optionalEmployee.get();
        return new org.springframework.security.core.userdetails.User(employee.getName(), employee.getPassword(), getGrantedAuthorities(employee));
    }

    private Collection<GrantedAuthority> getGrantedAuthorities(Employee employee) {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if(employee.getName().equals("admin")) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return grantedAuthorities;
    }

}