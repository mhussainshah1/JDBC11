package closable;

import java.sql.DriverManager;
import java.sql.SQLException;

public class INParameter {

    public static void main(String[] args) throws SQLException {
//        String url = "jdbc:hsqldb:file:zoo_procedure";
        String url = "jdbc:mysql://localhost:3306/zoo";
        String user = "root";
        String password = "password";
        var sql = "{call read_names_by_letter(?)}";
        try (var conn = DriverManager.getConnection(url, user, password);
             var cs = conn.prepareCall(sql)) {
            cs.setString("prefix", "Z");
            //or
//            cs.setString(1, "Z");

            try (var rs = cs.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getString(3));
                }
            }
        }
    }
}