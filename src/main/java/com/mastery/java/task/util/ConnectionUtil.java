package com.mastery.java.task.util;

import java.sql.*;

public class ConnectionUtil {

    private static final String URL = "jdbc:postgresql://localhost:5432/employeedb2?serverTimezone=UTC";
    private static final String USERNAME = "rita";
    private static final String PASSWORD = "1234";

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}