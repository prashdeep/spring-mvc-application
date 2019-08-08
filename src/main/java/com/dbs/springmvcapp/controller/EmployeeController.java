package com.dbs.springmvcapp.controller;

import com.dbs.springmvcapp.model.Dependent;
import com.dbs.springmvcapp.model.Employee;
import com.dbs.springmvcapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Arrays;


@Controller
@RequestMapping("/users")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/login")
    public String login(Model model){
        System.out.println("Came inside the login method ");
        List<Employee> listOfAllEmployees  = employeeService.listAll();
        listOfAllEmployees.forEach(employee ->  System.out.println(employee));
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(
            @RequestParam("username")String username,
            @RequestParam("password") String password,
            Model model){
        System.out.println("Inside the POST method of login user");
        System.out.println("Username is "+username + " password is "+ password);
        if(username.equalsIgnoreCase(password)){
            model.addAttribute("user", username);
            return "success";
        }
        return "login";
    }

    @GetMapping("/listAll")
    public String listAllEmployees(Model model){
        List<Employee> employees = this.employeeService.listAll();
        model.addAttribute("employees", employees);
        return "list";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("employee", new Employee());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser( @Valid @ModelAttribute("employee") Employee employee,
                                BindingResult bindingResult) throws IOException {
        if(bindingResult.hasErrors()){
            //System.out.println("Error "+bindingResult.toString());
            //throw new IOException("Exception while registering employee");
            return "register";
            //throw  new NullPointerException("DOB cannot be null");
        }
        Employee employee1 = new Employee();
        employee1.setAge(23);
        employee1.setSalary(50000);
        employee1.setDateOfBirth("19-05-2019");
        employee1.setName("Ganesh");

        Dependent dependent = new Dependent();
        dependent.setName("Shivaji");
        dependent.setEmployee(employee1);
        employee1.getDependents().add(dependent);
        this.employeeService.saveEmployee(employee1);
        return "dashboard";
    }

    @ExceptionHandler(IOException.class)
    public String handleException(HttpServletRequest request, Exception ex){
        return "error";
    }
}