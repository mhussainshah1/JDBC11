package preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Parameter {
    public static void main(String[] args) throws SQLException {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo", "root", "password")) {
//            register(conn);
//            register(conn,7,1,"Meshoo");
//            registerMore(conn,8,1,"Nika");
            registerLess(conn,9,1, "Brunoo");
        }
    }

    public static void register(Connection conn) throws SQLException {
        var sql = "INSERT INTO names VALUES (6,1, 'Edith')";
        try (var ps = conn.prepareStatement(sql)) {
            int result = ps.executeUpdate();
            System.out.println(result);//1
        }
    }
    //Alternatively
    public static void register(Connection conn, int key, int type, String name) throws SQLException {
        var sql = "INSERT INTO names VALUES (?, ?, ?)";
        try (var ps = conn.prepareStatement(sql)) {
            ps.setInt(1,key);
            ps.setString(3,name);
            ps.setInt(2,type);

         /*   ps.setObject(1,key);
            ps.setObject(2,type);
            ps.setObject(3,name);*/

            int result = ps.executeUpdate();
            System.out.println(result);//1
        }
    }

    public static void registerMore(Connection conn, int key, int type, String name) throws SQLException {
        var sql = "INSERT INTO names VALUES (?, ?)";
        try (var ps = conn.prepareStatement(sql)) {
            ps.setInt(1,key);
            ps.setInt(2,type);
            ps.setString(3,name);

            int result = ps.executeUpdate();
            System.out.println(result);
        }
    }

    public static void registerLess(Connection conn, int key, int type, String name) throws SQLException {
        var sql = "INSERT INTO names VALUES (?, ?, ?)";
        try (var ps = conn.prepareStatement(sql)) {
            ps.setInt(1,key);
            ps.setInt(2,type);

            int result = ps.executeUpdate();
            System.out.println(result);
        }
    }
}
