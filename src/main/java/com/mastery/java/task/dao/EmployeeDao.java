package com.mastery.java.task.dao;

import com.mastery.java.task.entity.Employee;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface EmployeeDao {

    void setDataSource(DataSource dataSource);

    Optional<Integer>  create(String firstName, String lastName, int departmentId, String jobTitle, Date dateOfBirth);

    Optional<Employee> getById(int id);

    List<Employee> findAll();

    int update(String firstName, String lastName, int departmentId, String jobTitle, int employeeId, Date dateOfBirth);

    void delete(int id);
}