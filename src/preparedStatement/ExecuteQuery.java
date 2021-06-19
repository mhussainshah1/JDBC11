package preparedStatement;

import java.sql.*;

public class ExecuteQuery {
    public static void main(String[] args) throws SQLException {

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo", "root", "password");
             PreparedStatement ps = conn.prepareStatement("SELECT * from names");
             ResultSet rs = ps.executeQuery()) {

            while(rs.next()){
                System.out.println(rs.getString(1)+ ", " + rs.getString(2)+ ", " + rs.getString(3));
            }
        }
    }
}
