package resultSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BadCode {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:derby:zoo");
        var sql = "SELECT COUNT(*) AS count FROM EXHIBITS";
        /*try (var ps = conn.prepareStatement(sql);
             var rs = ps.executeQuery()) {
            if (rs.next()) {
                var count = rs.getInt("total");//SQLException: Column 'total' not found.
                System.out.println(count);
            }
        }*/

        /*sql = "SELECT * FROM EXHIBITS WHERE name = 'Not in table'";
        try (var ps = conn.prepareStatement(sql);
             var rs = ps.executeQuery()) {
            rs.next();
            rs.getInt(1);//SQLException: Invalid cursor state - no current row.
        }*/

        /*sql = "SELECT COUNT(*) FROM EXHIBITS";
        try (var ps = conn.prepareStatement(sql);
             var rs = ps.executeQuery()) {
            if (rs.next()) {
                var count = rs.getInt(0);//SQLException:  Column '0' not found.
                System.out.println(count);
            }
        }*/

        sql = "SELECT name FROM EXHIBITS";
        try (var ps = conn.prepareStatement(sql);
             var rs = ps.executeQuery()) {
            if (rs.next()) {
                rs.getInt("badColumn");//SQLException:  Column 'badColumn' not found.
            }
        }

    }
}
