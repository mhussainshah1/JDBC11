package closable;

import java.sql.*;

public class WithOutParameter {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/zoo";
        String user = "root";
        String password = "password";
        String sql = "{call read_e_names()}";
        try (Connection conn = DriverManager.getConnection(url,user,password);
             CallableStatement cs = conn.prepareCall(sql);
             ResultSet rs = cs.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getString(3));
            }
        }
    }
}