package resultSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Reading {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:derby:zoo");

        var sql = "SELECT id, name from exhibits";
        Map<Integer, String> idToNameMap = new HashMap<>();
        try (var ps = conn.prepareStatement(sql);
             var rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");

       /*         int id = rs.getInt(1);
                String name = rs.getString(2);*/

                idToNameMap.put(id, name);
            }
            System.out.println(idToNameMap);
        }

        //one row
        sql = "SELECT COUNT(*) FROM EXHIBITS";
        try (var ps = conn.prepareStatement(sql);
             var rs = ps.executeQuery()) {
            if(rs.next()){
                int count = rs.getInt(1);//2
                System.out.println(count);
            }
        }

        //or

        sql = "SELECT COUNT(*) AS count FROM EXHIBITS";
        try (var ps = conn.prepareStatement(sql);
             var rs = ps.executeQuery()) {
            if(rs.next()){
                var count = rs.getInt("count");//2
                System.out.println(count);//2
            }
        }

    }
}
