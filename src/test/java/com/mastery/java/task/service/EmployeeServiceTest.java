package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.sql.Date;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class EmployeeServiceTest {

    @MockBean
    EmployeeDao employeeDao;

    @Autowired
    EmployeeService employeeService;

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
    @Test
    public void testGetById_happyPath() {
        // given
        Employee existingEmployee = createEntity();
        when(employeeDao.getById(1)).thenReturn(Optional.of(existingEmployee));

        // when
        Employee foundEmployee = employeeService.getById(existingEmployee.getEmployeeId());

        //then
        assertEquals(foundEmployee.getEmployeeId(), existingEmployee.getEmployeeId());
    }
}
