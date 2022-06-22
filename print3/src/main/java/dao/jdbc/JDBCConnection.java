package dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    public final static String URL = "jdbc:mysql://localhost:3306/CriminalEvidence";
    public final static String USER_NAME = "root";
    public final static String PASSWORD = "root";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection (URL, USER_NAME, PASSWORD);
    }
}
