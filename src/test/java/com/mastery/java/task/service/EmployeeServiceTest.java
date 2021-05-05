package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    EmployeeService employeeService;

    @Test
    public void testFindAll() {
        List<Employee> employees = employeeDao.findAll();

        List<Employee> allEmployees = employeeService.findAll();

        assertEquals(4, employees.size());
        assertEquals(employees.size(), allEmployees.size());
    }


    @Test
    void testGetById_happyPath() {
        Employee existingEmployee = createEntity();

        Employee foundEmployee = employeeService.getById(existingEmployee.getEmployeeId());

        assertNotNull(foundEmployee);
        assertEquals(foundEmployee.getEmployeeId(), existingEmployee.getEmployeeId());
    }

    @Test
    void create_happyPath() {
        Employee employee = new Employee(5, "Masha", "Apapa", 2, "Dev", new Date(1986, 5, 4));

        Optional<Integer> savedEmployee = employeeDao.create("Anna", "Lala", 4, "Dev", new Date(1990, 12, 10));

        assertNotNull(savedEmployee);
        assertEquals(Optional.of(employee.getEmployeeId()), savedEmployee);
        assertEquals(Optional.of(5), savedEmployee);
    }

    @Test
    void update_happyPath() {
        Employee employee = new Employee(5, "Masha", "Apapa", 2, "Dev", new Date(1990, 12, 10));

        int updateEmployee = employeeDao.update("Katya", "Lala", 2, "Dev", 5, new Date(1990, 12, 10));

        assertEquals(employee.getEmployeeId(), updateEmployee);
        assertEquals(5, updateEmployee);

    }

    @Test
    void delete_happyPath() {
        List<Employee> allEmployees = employeeService.findAll();

        employeeService.delete(1);
        List<Employee> updatedListEmployees = employeeService.findAll();


        assertEquals(4, allEmployees.size());
        assertEquals(3, updatedListEmployees.size());

    }

    private Employee createEntity() {
        return Employee.builder()
                .employeeId(1)
                .firstName("Anna")
                .lastName("Lala")
                .departmentId(4)
                .jobTitle("Dev")
                .dateOfBirth(new Date(1994 - 12 - 10))
                .build();
    }
}