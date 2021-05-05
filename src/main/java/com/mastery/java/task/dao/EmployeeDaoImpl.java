package com.mastery.java.task.dao;

import com.mastery.java.task.entity.Employee;
import com.mastery.java.task.mapper.EmployeeMapper;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
@NoArgsConstructor
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

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

    private static final String SELECT_LAST_INSERT_ID =
            "SELECT CURRVAL(pg_get_serial_sequence('employee','employee_id'));";

    @Override
    public Optional<Integer> create(String firstName, String lastName, int departmentId, String jobTitle, Date dateOfBirth) {
        jdbcTemplate.update(INSERT_EMPLOYEE_QUERY, firstName, lastName, departmentId, jobTitle, dateOfBirth);
        return Optional.ofNullable(jdbcTemplate.queryForObject(SELECT_LAST_INSERT_ID, Integer.class));
    }

    @Override
    public Optional<Employee> getById(int id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SELECT_EMPLOYEE_BY_ID_QUERY, new EmployeeMapper(), id));
    }

    @Override
    public List<Employee> findAll() {
        return jdbcTemplate.query(SELECT_ALL_EMPLOYEE_QUERY, new EmployeeMapper());
    }

    @Override
    public int update(String firstName, String lastName, int departmentId, String jobTitle, int employeeId, Date dateOfBirth) {
        jdbcTemplate.update(UPDATE_EMPLOYEE_QUERY, firstName, lastName, departmentId, jobTitle, dateOfBirth, employeeId);
        return employeeId;
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE_EMPLOYEE_QUERY, id);
    }
}