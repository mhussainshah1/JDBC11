package closing;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ResourceLeak {
    public static void main(String[] args) {
        try {
            bad();
        } catch (SQLException throwables) {
            System.out.println(throwables.getMessage());
            System.out.println(throwables.getSQLState());
            System.out.println(throwables.getErrorCode());
        }
    }

    public static void bad() throws SQLException{
        var url = "jdbc:derby:zoo";
        var sql ="SELECT not_a_column FROM names";
        var conn = DriverManager.getConnection(url);
        var ps = conn.prepareStatement(sql);
        var rs = ps.executeQuery();

        try(conn;ps;rs){
            while (rs.next()){
                System.out.println(rs.getString(1));
            }
        }
    }
}
