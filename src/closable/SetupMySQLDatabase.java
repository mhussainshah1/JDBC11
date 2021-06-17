package closable;

import java.sql.*;

public class SetupMySQLDatabase {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/zoo";
        String user = "root";
        String password = "password";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            run(conn, "DROP PROCEDURE IF EXISTS read_e_names");
            run(conn, "DROP PROCEDURE IF EXISTS read_names_by_letter");
            run(conn, "DROP PROCEDURE IF EXISTS magic_number");
            run(conn, "DROP PROCEDURE IF EXISTS double_number");
            run(conn, "DROP TABLE IF EXISTS names");
            run(conn, "DROP TABLE IF EXISTS exhibits");

            run(conn, """
                        CREATE TABLE exhibits (
                        id INTEGER PRIMARY KEY, 
                        name VARCHAR(255), 
                        num_acres DECIMAL(4,1))            
                    """);

            run(conn, "CREATE TABLE names ("
                    + "id INTEGER PRIMARY KEY, "
                    + "species_id integer REFERENCES exhibits (id), "
                    + "name VARCHAR(255))");

            run(conn, "INSERT INTO exhibits VALUES (1, 'African Elephant', 7.5)");
            run(conn, "INSERT INTO exhibits VALUES (2, 'Zebra', 1.2)");

            run(conn, "INSERT INTO names VALUES (1, 1, 'Elsa')");
            run(conn, "INSERT INTO names VALUES (2, 2, 'Zelda')");
            run(conn, "INSERT INTO names VALUES (3, 1, 'Ester')");
            run(conn, "INSERT INTO names VALUES (4, 1, 'Eddie')");
            run(conn, "INSERT INTO names VALUES (5, 2, 'Zoe')");

            String noParams = """
                        CREATE PROCEDURE read_e_names()
                            READS SQL DATA
                        BEGIN
                            select * from names;
                        END
                    """;

            String inParam = """
                        CREATE PROCEDURE read_names_by_letter(IN prefix VARCHAR(10))
                            READS SQL DATA
                        BEGIN
                            SELECT * FROM names WHERE name LIKE CONCAT(prefix, '%');
                        END
                    """;

            String inOutParam = """
                        CREATE PROCEDURE double_number(INOUT num INT)
                            READS SQL DATA
                        BEGIN
                            SET num = num * 2;
                        END
                    """;

            String outParam = """
                        CREATE PROCEDURE magic_number(OUT num INT)
                               READS SQL DATA
                        BEGIN
                           	SET num = 42;
                        END
                    """;

            run(conn, noParams);
            run(conn, inParam);
            run(conn, outParam);
            run(conn, inOutParam);

            printCount(conn, "SELECT count(*) FROM names");
        }
    }

    private static void run(Connection conn, String sql) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.executeUpdate();
        }
    }

    private static void printCount(Connection conn, String sql) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            rs.next();
            System.out.println(rs.getInt(1));
        }
    }
}
