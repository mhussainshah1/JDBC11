package connection;
import java.sql.*;

public class TestConnect {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.apache.derby.impl.jdbc.EmbedConnection");
        Connection conn = DriverManager.getConnection("jdbc:derby:zoo");//jdbc:derby://localhost:1527/zoo
        System.out.println(conn);
        //org.apache.derby.impl.jdbc.EmbedConnection@406765571 (XID = 826), (SESSIONID = 1), (DATABASE = zoo), (DRDAID = null)
    }
}
