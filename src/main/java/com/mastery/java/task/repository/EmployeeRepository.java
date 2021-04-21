package com.mastery.java.task.repository;

import com.mastery.java.task.entity.Employee;

import java.util.List;

public interface EmployeeRepository {

    void save(Employee employee);

    Employee getById(int id);

    List<Employee> findAll() throws Exception;

    void update(Employee employee) throws Exception;

    void delete(int id) throws Exception;
}