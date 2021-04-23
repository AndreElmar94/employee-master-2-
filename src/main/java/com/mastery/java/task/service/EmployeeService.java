package com.mastery.java.task.service;

import com.mastery.java.task.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeService {

    void save(Employee employee);

    Employee getById(int id);

    List<Employee> findAll() throws SQLException;

    void update(Employee employee) throws SQLException;

    void delete(int id) throws SQLException;
}