package bai2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    // Kết nối vào ORACLE.
    public static Connection getOracleConnection() throws SQLException {
        String hostName = "localhost";
        String sid = "orcl";
        String userName = "SYSTEM";
        String password = "123456";

        // Cấu trúc URL Connection dành cho Oracle
        // Ví dụ: jdbc:oracle:thin:@localhost:1521:db11g
        String connectionURL = "jdbc:oracle:thin:@" + hostName + ":1521:" + sid;
        Connection conn = DriverManager.getConnection(connectionURL, userName, password);

        return conn;
    }
}
