package preparedStatement;

import java.sql.*;

public class Execute {
    public static void main(String[] args) throws SQLException {

        try (Connection conn = DriverManager.getConnection("jdbc:derby:zoo");
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
