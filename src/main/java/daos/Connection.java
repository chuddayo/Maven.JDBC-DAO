package daos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connection {
    public static final String URL = "jdbc:mysql://localhost:3306/zcdata";
    public static final String USER = "ryan";
    public static final String PASS = "chuddayo";
    public static final Logger demoLog = Logger.getLogger("chuddayoDAO");

    public static void main(String[] args) {
        demoLog.log(Level.INFO, "Connection attempt beginning");

        try {
            Class.forName("daos.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found!!");
        }

        Connection connection;
    }


}
