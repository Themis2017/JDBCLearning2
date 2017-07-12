package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by 10195 on 2017/7/12.
 */
public class DbUtil {
    private static  final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:@127.0.0.1:1521:orcl";
    private static final String USERNAME = "zsy";
    private static final String PASSWORD = "zsy";
    private static Connection conn;
    static{
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private DbUtil() {
    }

    public static Connection getConnection(){
        return conn;
    }
}
