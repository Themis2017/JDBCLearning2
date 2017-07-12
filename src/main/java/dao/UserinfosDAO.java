package dao;

import db.DbManager;
import entity.Userinfos;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;

/**
 * Created by 10195 on 2017/7/12.
 */
public class UserinfosDAO {
    private DbManager dbm;

    public UserinfosDAO() {
        dbm = new DbManager();
    }
    public void saveUser(Userinfos user){
        String sql = "insert into userinfos values(seq_userid.nextval,?,to_date(?,'yyyy-MM-dd',?,?)";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        dbm.update(sql,new Object[]{
                user.getUsername(),
                sdf.format(user.getBirthday()),
                user.getAge(),
                user.getUserphoto()
        });
    }
    public void deleteUser(int userid){
        String sql = "delete from userinfos where userid=?";
        dbm.update(sql,new Object[]{userid});
    }
    public void updateUser(Userinfos user){
        String sql = "update userinfos set username=?,birthday=to_date(?,'yyyy-MM-dd'),age=?,userphoto=? where userid=?";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        dbm.update(sql,new Object[]{
                user.getUsername(),
                sdf.format(user.getBirthday()),
                user.getAge(),
                user.getUserphoto(),
                user.getUserid()
        });

    }
    //根据id查找结果，查询出来的是一个结果集
    public ResultSet findById(int userid){
        String sql = "select * from userinfos where userid=?";
        return dbm.query(sql,new Object[]{userid});
    }
    //查询所有，查询出来的是一个结果集，在jsp页面使用java代码进行循环展示
    public ResultSet findAll(){
        String sql = "select * from userinfos ";
        return dbm.query(sql,new Object[]{});
    }
}
