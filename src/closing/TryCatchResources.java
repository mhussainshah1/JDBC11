package closing;

import java.sql.DriverManager;
import java.sql.SQLException;

public class TryCatchResources {
    public static void main(String[] args) throws SQLException {

        var url = "jdbc:derby:zoo";
        var sql = "SELECT COUNT(*) FROM names WHERE id = ?";
        try (var conn = DriverManager.getConnection(url);    //1 - open conn
             var ps = conn.prepareStatement(sql)) {     //2 - open ps
            ps.setInt(1, 1);

            var rs1 = ps.executeQuery();
            while (rs1.next()) {                                        //3 - open rs1
                System.out.println("Count: " + rs1.getInt(1));
            }

            ps.setInt(1, 2);
            var rs2 = ps.executeQuery();
            while (rs2.next()) {                                        //4 - close rs1  , 5 - open rs2
                System.out.println("Count: " + rs2.getInt(1));
            }
            rs2.close();                                                //6 - close rs2
        }                                                               //7 - close ps
                                                                        //8 - close conn
    }
}
