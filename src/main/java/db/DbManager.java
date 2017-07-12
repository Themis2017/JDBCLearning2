package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 10195 on 2017/7/12.
 */
public class DbManager {
    private Connection conn;
    private PreparedStatement pstat;
    private ResultSet rs;

    public DbManager() {
       conn = DbUtil.getConnection();
    }
    public  int update(String sql,Object [] params){
        int count = 0;
        try {
            pstat = conn.prepareStatement(sql);
            for (int i = 0; i <params.length ; i++) {
                pstat.setObject(i+1,params[i]);
            }
            count = pstat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    public  ResultSet query(String sql,Object [] params){
        try {
            pstat = conn.prepareStatement(sql);
            for (int i = 0; i <params.length ; i++) {
                pstat.setObject(i+1,params[i]);
            }
            rs = pstat.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
