package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Driver;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
    public static final String driver="com.mysql.jdbc.Driver";
    public static final String url="jdbc:mysql://localhost:3306/webmysql1?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8";
    public static final String username="root";
    public static final String password="22dd66cc";
    public static Connection con=null;
    static{
        try {
            Class.forName(driver);//得到DriverManager，在下面建立连接时使用
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getCon(){

        if(con == null){
            try {
                con = DriverManager.getConnection(url, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return con;
    }
    public static void main(String args[]){
            new DBUtil().getCon();
        }
}