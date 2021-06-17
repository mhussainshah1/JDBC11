package resultSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BindVariables {
    public static void main(String[] args) throws SQLException {
        var sql = "SELECT id FROM exhibits where name = ?";

        try( var conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo", "root", "password");
             var ps = conn.prepareStatement(sql)){

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
