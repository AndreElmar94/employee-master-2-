package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.entity.Employee;
import com.mastery.java.task.exception.EmployeeNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void create(String firstName, String lastName, int departmentId, String jobTitle, Date dateOfBirth) {
        log.info("EmployeeServiceImpl -> employee successfully saved");
        employeeDao.create(firstName, lastName, departmentId, jobTitle, dateOfBirth);
    }


    @Override
    public Employee getById(int id) {
        log.info("EmployeeServiceImpl -> found employee by ID: {}", id);
        return employeeDao.getById(id).orElseThrow(() -> new EmployeeNotFoundException(String.format("Employee was not found by id: %s", id)));
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = employeeDao.findAll();
        log.info("EmployeeServiceImpl -> found {} employees", employees.size());
        return employees;
    }

    @Override
    public void update(String firstName, String lastName, int departmentId, String jobTitle, int employeeId, Date dateOfBirth) {
        log.info("EmployeeServiceImpl -> updated Employee");
        employeeDao.update(firstName, lastName, departmentId, jobTitle, employeeId, dateOfBirth);
    }

    @Override
    public void delete(int id) {
        log.info("EmployeeServiceImpl -> deleted employee by ID: {}", id);
        employeeDao.delete(id);
    }
}