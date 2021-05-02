package com.mastery.java.task.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private int employeeId;
    private String firstName;
    private String lastName;
    private int departmentId;
    private String jobTitle;
    private Date dateOfBirth;

}