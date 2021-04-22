package com.mastery.java.task.service;

import com.mastery.java.task.entity.Employee;
import com.mastery.java.task.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    public EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public void save(Employee employee) {
        log.info("EmployeeServiceImpl -> employee successfully saved");
        employeeRepository.save(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public Employee getById(int id) {
        log.info("EmployeeServiceImpl -> found employee by ID: {}", id);
        return employeeRepository.getById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll() throws Exception {
        List<Employee> employees = employeeRepository.findAll();
        log.info("EmployeeServiceImpl -> found {} employees", employees.size());
        return employees;
    }

    @Override
    @Transactional
    public void update(Employee employee) throws Exception {
        log.info("EmployeeServiceImpl -> updated Employee");
        employeeRepository.update(employee);
    }

    @Override
    @Transactional
    public void delete(int id) throws Exception {
        log.info("EmployeeServiceImpl -> deleted employee by ID: {}", id);
        employeeRepository.delete(id);
    }
}