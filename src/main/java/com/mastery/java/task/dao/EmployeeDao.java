package com.mastery.java.task.dao;

import com.mastery.java.task.entity.Employee;

import javax.sql.DataSource;

import java.sql.Date; // java.sql.Date -> пришлось использовать именно этот пакет, тк любой другой PostgreSQL не принимает.
import java.util.List;
import java.util.Optional;

public interface EmployeeDao {

     void setDataSource(DataSource dataSource);

     void create(String firstName, String lastName, int departmentId, String jobTitle, Date dateOfBirth);

    Optional<Employee> getById(int id);

    List<Employee> findAll();

    void update(String firstName, String lastName, int departmentId, String jobTitle, int employeeId, Date dateOfBirth);

    void delete(int id);

}