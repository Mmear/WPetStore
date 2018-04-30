package org.csu.wpetstore.persistence;
import com.sun.org.apache.regexp.internal.RE;

import javax.xml.transform.Result;
import java.sql.*;

/**
 * 数据库操作类
 * Created by WZF on 2018/4/25.
 */
public class DBUtil {
    private static String driverString = "com.mysql.jdbc.Driver";
    private static String connectionString = "jdbc:mysql://localhost:3306/wpetstore";
    private static String userName = "root";
    private static String userPassword = "123456";

    public static Connection getConnection() throws Exception {
        Connection conn = null;
        try {
            Class.forName(driverString);
            conn = DriverManager.getConnection(connectionString, userName, userPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeStatement(Statement stmt) throws Exception {
        if(stmt != null)
            stmt.close();
    }

    public static void closePrepareStatement(PreparedStatement preparedStmt) throws Exception {
        if(preparedStmt != null)
            preparedStmt.close();
    }
    public static void closeResultSet(ResultSet rs) throws Exception {
        if(rs != null)
            rs.close();
    }
    public static void closeConnection(Connection conn) throws Exception {
        if(conn != null)
            conn.close();
    }
    public static void closeAll(Statement stmt, PreparedStatement preparedStmt, ResultSet rs, Connection conn) throws Exception {
        closeStatement(stmt);
        closePrepareStatement(preparedStmt);
        closeResultSet(rs);
        closeConnection(conn);
    }
    //TODO 为PrepareStatement语句写一个方法
    public static ResultSet preparedResult(String sql, Object...param) {
        return null;
    }
//    public static void main(String[] args) {
//        try{
//            Connection conn = getConnection();
//            if(conn != null) {
//                System.out.println("Connection is established");
//                Statement stmt = conn.createStatement();
//                String sql = "SELECT * FROM category";
//                ResultSet rs = stmt.executeQuery(sql);
//                while(rs.next()){
//                    System.out.println("CategoryID:" + rs.getString(1) + " " +
//                            "CategoryName:" + rs.getString(2));
//                }
//                closeAll(stmt, null, rs, conn);
//            }else {
//                System.out.println("Connection failed");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
