package resultSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BindVariables {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:derby:zoo");
        var sql = "SELECT id FROM exhibits where name = ?";

        try(var ps = conn.prepareStatement(sql)){

            ps.setString(1, "Zebra");//set in between ps and rs

            try(var rs = ps.executeQuery()){
                while (rs.next()){
                    int id = rs.getInt("id");
                    System.out.println(id);
                }
            }
        }

    }
}
