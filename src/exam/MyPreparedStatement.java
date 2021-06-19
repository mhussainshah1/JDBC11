package exam;

import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.SQLException;
/**
 * create database exam;
 * use exam;
 * create table EMP (ID INTEGER, Name_of_employee VARCHAR(20), DEPT VARCHAR(20));
 * INSERT into EMP VALUES(101,'SMITH','HR');
 * INSERT into EMP VALUES(102,'JONES','ENG');
 * INSERT into EMP VALUES(103,'WEAVER','HR');
 * select * from EMP;
 */

/**
 Given the data of the EMP table:
 ID NAME DEPT
 101 SMITH HR
 102 JONES ENG
 103 WEAVER HR

 Assuming that ds refers to a DataSource:
 */
public class MyPreparedStatement {

    public static void main(String[] args) throws SQLException {
        try (var conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam", "root", "password");
             // var delete = conn.prepareStatement("DELETE FROM RECRUITING");
             var query = conn.prepareStatement("SELECT ID, NAME FROM EMP WHERE DEPT = ?");//return 2 rows
             var update = conn.prepareStatement("INSERT INTO RECRUITING (ID , NAME) VALUES(?, ?)")) {//return 1 row

            query.setString(1, "HR");
            var rs = query.executeQuery();
            while (rs.next()) {
                update.setObject(1, rs.getObject(1, Integer.class), JDBCType.INTEGER);
                update.setObject(2, rs.getObject(2, String.class), JDBCType.VARCHAR);
                update.execute();
                System.out.println("run");
            }
        }
    }
}

/**
 Which two happen upon execution?
 A) Three PreparedStatement objects are created.
 B) TWO PreparedStatement objects are created.
 C) Two SQL statements are executed.
 D) Three SQL statements are executed.
 E) A SQLException is thrown because the ResultSet is not closed.
 F) Memory leaks because the Connection, PreparedStatements, and ResultSet are not closed.

 Answer: B , D
 */