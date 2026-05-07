package AAKASH_HOTEL;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String url = "jdbc:mysql://localhost:3306/hotel_db";

    private static final String user = "root";
    private static final String password = "port";

    public static Connection getConnection() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(url, user, password);
    }
}
