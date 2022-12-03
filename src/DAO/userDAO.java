package DAO;
import java.sql.*;
import dbconnect.userCommon;

//transaction을 전담하는 객체
//2018038006 이정주
public class userDAO {
    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;

    public userDAO(){
        try{
            Class.forName(userCommon.Driver);
            conn = DriverManager.getConnection(userCommon.URL,userCommon.UID,userCommon.UPW);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void close() throws SQLException{
        if(rs != null) rs.close();
        if(pstmt != null)pstmt.close();
        if(conn != null)conn.close();
    }

}
