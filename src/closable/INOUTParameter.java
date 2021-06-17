package closable;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class INOUTParameter {
    public static void main(String[] args) throws SQLException {
//        String url = "jdbc:hsqldb:file:zoo_procedure";
        String url = "jdbc:mysql://localhost:3306/zoo";
        String user = "root";
        String password = "password";
        var sql = "{call double_number(?)}";
        try (var conn = DriverManager.getConnection(url, user, password);
             var cs = conn.prepareCall(sql)) {
            cs.setInt(1, 8);
            cs.registerOutParameter(1, Types.INTEGER);
            cs.execute();
            System.out.println(cs.getInt("num"));
        }
    }
}