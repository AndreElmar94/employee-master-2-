package com.mastery.java.task.mapper;

import com.mastery.java.task.entity.Employee;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public Employee mapToEntity(ResultSet rs) throws SQLException {

        int employeeId = rs.getInt("employee_id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        int departmentId = rs.getInt("department_id");
        String jobTitle = rs.getString("job_title");
        Date dateOfBirth = rs.getDate("date_of_birth");

        Employee employee = new Employee(employeeId, firstName,
                lastName, departmentId, jobTitle, dateOfBirth);
        return employee;
    }
}