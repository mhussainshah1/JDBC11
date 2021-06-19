package preparedStatement;

import java.sql.*;

public class Execute {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/zoo";
        String user = "root";
        String password = "password";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement("SELECT * from names")) {
            boolean isResultSet = ps.execute();
            if (isResultSet) {
                try (ResultSet rs = ps.getResultSet()) {
                    System.out.println("ran a query");
                }
            } else {
                int result = ps.getUpdateCount();
                System.out.println("rows effected" + result);
            }
        }
    }
}
