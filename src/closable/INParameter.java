package closable;

import java.sql.DriverManager;
import java.sql.SQLException;

public class INParameter {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:hsqldb:file:zoo_procedure";
        var sql = "{call read_names_by_letter(?)}";
        try (var conn = DriverManager.getConnection(url);
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