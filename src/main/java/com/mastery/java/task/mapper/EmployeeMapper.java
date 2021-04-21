package com.mastery.java.task.mapper;

import com.mastery.java.task.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface EmployeeMapper {

    Employee mapToEntity(ResultSet rs) throws SQLException;
}