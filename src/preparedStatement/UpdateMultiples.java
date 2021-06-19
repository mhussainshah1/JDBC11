package preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UpdateMultiples {
    public static void main(String[] args) throws SQLException {
        var sql = "INSERT INTO names VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo", "root", "password");
             var ps = conn.prepareStatement(sql)) {

            ps.setInt(1, 20);
            ps.setInt(2, 1);
            ps.setString(3, "Ester");
            ps.executeUpdate();

            ps.setInt(1, 21);
            ps.setString(3, "Elias");
            ps.executeUpdate();
        }
    }
}
