package exam;

import java.sql.*;

/**   Assume ds is a DataSource and the EMP table is defined appropriately.

 Given the data of the EMP table:
 Before:
 ID NAME DEPT
 101 SMITH HR
 102 JONES ENG
 103 WEAVER HR

 After:
 ID NAME DEPT
 101 SMITH HR
 102 JONES ENG
 103 WEAVER HR
 101 SMITH HR
 102 JONES HR

 */
public class UpdateData {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/zoo";
        String user = "root";
        String password = "password";
        try (Connection conn = DriverManager.getConnection(url,user,password);
             PreparedStatement ps = conn.prepareStatement("INSERT INTO EMP VALUES(?, ?, ?)")) {
            ps.setObject(1, 101, JDBCType.INTEGER);
            ps.setObject(2, "SMITH", JDBCType.VARCHAR);
            ps.setObject(3, "HR", JDBCType.VARCHAR);
            System.out.println(ps.executeUpdate());
            ps.setInt(1, 102);
            ps.setString(2, "JONES");
            System.out.println(ps.executeUpdate());
        }
    }
}
/*
   What does executing this code fragment do?
   A) inserts two rows (101, 'SMITH' , 'HR') and (102, 'JONES' , 'HR')
   B) inserts one row (101, 'SMITH', 'HR')
   C) inserts two rows (101, 'SMITH', 'HR') and (102, 'JONES', NULL)
   D) throwsa SQLException

   Answer: A
*/