package com.mastery.java.task.service;

import com.mastery.java.task.entity.Employee;

import java.sql.Date;
import java.util.List;

public interface EmployeeService {

    Integer create(String firstName, String lastName, int departmentId, String jobTitle, Date dateOfBirth);

    Employee getById(int id);

    List<Employee> findAll();

    int update(String firstName, String lastName, int departmentId, String jobTitle, int employeeId, Date dateOfBirth);

    void delete(int id);
}