package peaksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private final static String url="jdbc:postgresql://localhost:5432/jdbcusertask1lms";
    private final static String username="postgres";
    private final static String password="postgres";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database!");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return connection;
    }

}
