package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnect {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/zoo";
        String user = "root";
        String password = "password";
        Class.forName("com.mysql.cj.jdbc.ConnectionImpl");
        try (Connection conn = DriverManager.getConnection(url, user, password)) {  //jdbc:mysql://localhost:3306/zoo
            System.out.println(conn);//com.mysql.cj.jdbc.ConnectionImpl@16d04d3d
        }
    }
}
