-- drop database if exists employeedb2;

drop table if exists employee;

create table employee
(
    employee_id   serial
        constraint employee_pk
            primary key,
    first_name    VARCHAR(255),
    last_name     VARCHAR(255),
    department_id int,
    job_title     VARCHAR(255),
    date_of_birth date
);

INSERT INTO employee
    (first_name, last_name, department_id, job_title, date_of_birth)
VALUES ('Olga', 'Paromovich',
        5, 'Back-end Developer',
        '1986-12-10');

INSERT INTO employee
    (first_name, last_name, department_id, job_title, date_of_birth)
VALUES ('Peter', 'Ivanov',
        4, 'Back-end Developer',
        '1988-05-02');

INSERT INTO employee
    (first_name, last_name, department_id, job_title, date_of_birth)
VALUES ('Maria', 'Petrova',
        1, 'Front-end Developer',
        '1996-08-03');

INSERT INTO employee
    (first_name, last_name, department_id, job_title, date_of_birth)
VALUES ('Egor', 'Lapin',
        3, 'QA',
        '1990-03-08');