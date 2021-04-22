package com.mastery.java.task.service;

import com.mastery.java.task.entity.Employee;
import com.mastery.java.task.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    public EmployeeRepository employeeRepository;

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public Employee getById(int id) {
        return employeeRepository.getById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll() throws Exception {
        return employeeRepository.findAll();
    }

    @Override
    @Transactional
    public void update(Employee employee) throws Exception {
        employeeRepository.update(employee);
    }

    @Override
    @Transactional
    public void delete(int id) throws Exception {
        employeeRepository.delete(id);
    }
}