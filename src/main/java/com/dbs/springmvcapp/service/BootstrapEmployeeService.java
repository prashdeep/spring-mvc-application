package com.dbs.springmvcapp.service;

import com.dbs.springmvcapp.model.Employee;
import com.dbs.springmvcapp.model.Role;
import com.dbs.springmvcapp.repository.EmployeeRepository;
import com.dbs.springmvcapp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class BootstrapEmployeeService implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        insertRoles();
        insertUser();
    }

    private void insertRoles() {
        if(roleRepository.findAll().size() == 0) {
            List<Role> roles = new ArrayList<>();
            Role roleAdmin = new Role();
            roleAdmin.setName("admin");
            roles.add(roleAdmin);

            Role roleUser = new Role();
            roleUser.setName("user");
            roles.add(roleUser);
            roleRepository.saveAll(roles);
        }
    }

    private void insertUser() {
        if(employeeRepository.findAll().size() == 0) {
            Employee employee = new Employee();
            employee.setName("Dhanush");
            employee.setAge(34);
            employee.setDateOfBirth("23-05-1975");
            employee.setPassword(new BCryptPasswordEncoder().encode("password"));
            employee.setId(56);
            employee.setRole(roleRepository.getOne(1L));

            employeeRepository.save(employee);
        }
    }
}