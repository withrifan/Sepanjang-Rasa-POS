/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sepanjangrasapos;

/**
 *
 * @author achmadrifan
 */

import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/sepanjangrasadb";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
