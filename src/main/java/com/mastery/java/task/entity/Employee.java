package com.mastery.java.task.entity;

import lombok.*;

import java.sql.Date; //java.sql.Date -> пришлось использовать именно этот пакет, тк любой другой PostgreSQL не принимает.

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