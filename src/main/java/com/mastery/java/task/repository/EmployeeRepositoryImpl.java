package com.mastery.java.task.repository;

import com.mastery.java.task.entity.Employee;
import com.mastery.java.task.exception.EmployeeNotFoundException;
import com.mastery.java.task.mapper.EmployeeMapperImpl;
import com.mastery.java.task.util.ConnectionUtil;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final EmployeeMapperImpl employeeMapper = new EmployeeMapperImpl();

    private static final String INSERT_EMPLOYEE_QUERY =
            "INSERT INTO employee (first_name, last_name, department_id, job_title, date_of_birth) " +
                    "VALUES (?, ?, ?, ?, ?);";

    private static final String SELECT_EMPLOYEE_BY_ID_QUERY =
            "SELECT * FROM employee " +
                    "WHERE employee_id = ?;";

    private static final String SELECT_ALL_EMPLOYEE_QUERY =
            "SELECT * FROM employee;";

    private static final String UPDATE_EMPLOYEE_QUERY =
            "UPDATE employee " +
                    "SET first_name = ?, last_name = ?, " +
                    "department_id = ?, job_title = ?, " +
                    "date_of_birth = ? " +
                    "WHERE employee_id = ?;";

    private static final String DELETE_EMPLOYEE_QUERY =
            "DELETE FROM employee " +
                    "WHERE employee_id = ?;";

    @Override
    public void save(Employee employee) {
        try (Connection con = ConnectionUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(INSERT_EMPLOYEE_QUERY)) {

            pstmt.setString(1, employee.getFirstName());
            pstmt.setString(2, employee.getLastName());
            pstmt.setInt(3, employee.getDepartmentId());
            pstmt.setString(4, employee.getJobTitle());
            pstmt.setDate(5, employee.getDateOfBirth());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getById(int id) {
        try (Connection con = ConnectionUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(SELECT_EMPLOYEE_BY_ID_QUERY)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                Employee foundEmployee = null;
                while (rs.next()) {
                    foundEmployee = employeeMapper.mapToEntity(rs);
                }
                return foundEmployee;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        try (Connection con = ConnectionUtil.getConnection();
             PreparedStatement pstmt = con.prepareStatement(SELECT_ALL_EMPLOYEE_QUERY)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Employee employee = employeeMapper.mapToEntity(rs);
                    employees.add(employee);
                }
                return employees;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Employee employee) throws Exception {

        if (employee.getEmployeeId() == 0) {
            throw new EmployeeNotFoundException("У сотрудника нет ID!!!");
        }
        Connection con = ConnectionUtil.getConnection();
        PreparedStatement pstmt = con.prepareStatement(UPDATE_EMPLOYEE_QUERY);
        pstmt.setString(1, employee.getFirstName());
        pstmt.setString(2, employee.getLastName());
        pstmt.setInt(3, employee.getDepartmentId());
        pstmt.setString(4, employee.getJobTitle());
        pstmt.setDate(5, employee.getDateOfBirth());

        pstmt.setInt(6, employee.getEmployeeId());

        int updatedRows = pstmt.executeUpdate();
        System.out.println("Обновлено: " + updatedRows + " строк!");

        pstmt.close();
        con.close();
    }

    @Override
    public void delete(int id) throws Exception {
        Connection con = ConnectionUtil.getConnection();
        PreparedStatement pstmt = con.prepareStatement(DELETE_EMPLOYEE_QUERY);
        pstmt.setInt(1, id);

        int rows = pstmt.executeUpdate();
        System.out.println("Удалено " + rows + " строк!");

        pstmt.close();
        con.close();
    }
}