package preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WrongSQL {
    public static void main(String[] args) throws SQLException {
        var sql = "SELECT * FROM names";
//        try (Connection conn = DriverManager.getConnection("jdbc:derby:zoo");
//             PreparedStatement ps = conn.prepareStatement(sql)) {
//            var result = ps.executeUpdate();
//            //Statement.executeUpdate() cannot be called with a statement that returns a ResultSet.
//        }

        sql = "UPDATE exhibits SET name = '' WHERE name = 'None'";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo", "root", "password");
             PreparedStatement ps = conn.prepareStatement(sql)) {
            var result = ps.executeQuery();
            //Statement.executeQuery() cannot be called with a statement that returns a row count.
        }
    }
}
