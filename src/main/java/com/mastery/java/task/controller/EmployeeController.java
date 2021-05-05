package com.mastery.java.task.controller;

import com.mastery.java.task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
@RequestMapping("/")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String getAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "employees";
    }

    @GetMapping("/addEmployee")
    public String createEmployeePage() {
        return "createEmployee";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute("employee") String firstName, String lastName, int departmentId, String jobTitle, Date dateOfBirth) {
        employeeService.create(firstName, lastName, departmentId, jobTitle, dateOfBirth);
        return "redirect:/employees";
    }

    @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute("employee") String firstName, String lastName, int departmentId, String jobTitle, int employeeId, Date dateOfBirth) {
        employeeService.update(firstName, lastName, departmentId, jobTitle, employeeId, dateOfBirth);
        return "redirect:/employees";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", employeeService.getById(id));
        return "editEmployee";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeService.delete(id);
        return "redirect:/employees";
    }
}