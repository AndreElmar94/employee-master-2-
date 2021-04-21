package com.mastery.java.task.util;

import java.sql.*;

public class ConnectionUtil {

    private static final String URL = "jdbc:postgresql://localhost:5432/employeedb2?serverTimezone=UTC";
    private static final String USERNAME = "rita";
    private static final String PASSWORD = "1234";

    public static Connection getConnection() throws SQLException {

        Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return con;
    }

        public static void closeResources(Connection con, PreparedStatement pstmt, ResultSet rs) {

        if (rs != null) {
            try {
                rs.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}