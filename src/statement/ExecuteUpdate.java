package statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//java -cp "C:\Program Files\Java\jdk-12.0.2\db\lib\derby.jar" ExecuteUpdate.java

public class ExecuteUpdate {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/zoo";
        String user = "root";
        String password = "password";
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        int result = stmt.executeUpdate("insert into species values(10, 'Deer', 3)");
        System.out.println(result); // 1
        result = stmt.executeUpdate("update species set name = '' where name = 'None'");
        System.out.println(result); // 0
        result = stmt.executeUpdate("delete from species where id = 10");
        System.out.println(result); // 1       
    }
}