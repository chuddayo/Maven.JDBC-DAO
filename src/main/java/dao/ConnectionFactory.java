package dao;

import com.mysql.jdbc.Driver;
import java.sql.SQLException;
import java.sql.*;

public class ConnectionFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/zcdata?verifyServerCertificate=false&useSSL=true";
    private static final String USER = "ryan";
    private static final String PASS = "chuddayo";

    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new Driver());
            System.out.println("Succesful connection");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database");
        }
    }
}
