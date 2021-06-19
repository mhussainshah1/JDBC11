package preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExecuteUpdate {
    public static void main(String[] args) throws SQLException {

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo", "root", "password");) {
            var insertSql = "INSERT INTO exhibits VALUES (10, 'Deer' , 3)";
            var updateSql = "UPDATE exhibits SET name = '' WHERE name = 'None'";
            var deleteSql = "DELETE FROM exhibits WHERE id = 10";

            try (var ps = conn.prepareStatement(insertSql)) {
                int result = ps.executeUpdate();
                System.out.println(result);//1
            }
            try (var ps = conn.prepareStatement(updateSql)) {
                int result = ps.executeUpdate();
                System.out.println(result);//0
            }
            try (var ps = conn.prepareStatement(deleteSql)) {
                int result = ps.executeUpdate();
                System.out.println(result);//1
            }
        }
    }
}
