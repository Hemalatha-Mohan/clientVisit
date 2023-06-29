package com.example.SearchEmployee.Controller;


import com.example.SearchEmployee.Service.EmployeeService;
import com.example.SearchEmployee.model.Employee;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService service;


    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Return the login.html template
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
        // Validate the username and password (e.g., check against a database)
        if (username.equals("admin") && password.equals("password")) {
            session.setAttribute("loggedIn", true); // Set a session attribute to indicate the user is logged in
            return "redirect:/add"; // Redirect to the employee list page
        } else {
            return "redirect:/"; // Redirect back to the login page with an error parameter
        }
    }

    @GetMapping("/employee-list")
    public String showEmployeeList(Model model) {
        // Retrieve and populate the necessary data for the employee list page
        return "index"; // Return the index.html template
    }

    @GetMapping("/add")
    public String add(Model model) {
        List<Employee> listemployee = service.listAll();
        model.addAttribute("employee", new Employee());
        return "index";
    }


   /* @RequestMapping("/search")
    public String doSearchEmployee(@ModelAttribute("employeeSearchFormData") Employee formData, Model model) {
        Employee emp = service.get(formData.getId());
        model.addAttribute("employee", emp);
        return "index";
    }*/


    @RequestMapping("/search")
    public String doSearchEmployee(@ModelAttribute("employeeSearchFronData") Employee formData , Model model){
        Employee employee = service.getByEname(formData.getEname());
        model.addAttribute("employee",employee);
        return "index";
    }


}