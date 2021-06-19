package statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteQuery {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/zoo";
        String user = "root";
        String password = "password";
        Connection conn = DriverManager.getConnection(url,user,password);
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery("select * from species");
    }
}