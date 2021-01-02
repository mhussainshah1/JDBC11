package closable;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class OUTParameter {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:hsqldb:file:zoo_procedure";
        var sql = "{?= call magic_number(?) }";
        try (var conn = DriverManager.getConnection(url);
             var cs = conn.prepareCall(sql)) {
            cs.registerOutParameter(1, Types.INTEGER);
            cs.execute();
            System.out.println(cs.getInt("num"));
        }
    }
}