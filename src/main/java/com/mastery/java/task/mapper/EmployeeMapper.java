package com.mastery.java.task.mapper;

import com.mastery.java.task.entity.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

        Employee employee = new Employee();

        employee.setEmployeeId(rs.getInt("employee_id"));
        employee.setFirstName(rs.getString("first_name"));
        employee.setLastName(rs.getString("last_name"));
        employee.setDepartmentId(rs.getInt("department_id"));
        employee.setJobTitle(rs.getString("job_title"));
        employee.setDateOfBirth(rs.getDate ("date_of_birth"));

        return employee;
    }

}