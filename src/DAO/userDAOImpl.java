package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import dbconnect.userCommon;
import DTO.userDTO;

public class userDAOImpl implements userDAO{
    // 해당 class는 쿼리를 작성하기 위한 class 입니다.
    private userCommon uComm = userCommon.getInstance();
    private static userDAO userdao = new userDAOImpl();

    @Override
    public int insert(userDTO userdto) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        int ret = 0;

        try{
            conn = uComm.getConnection();
            String sql = "insert into user (uname,comment) values (?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userdto.getUname());
            pstmt.setString(2,userdto.getComment());
            ret = pstmt.executeUpdate();
        }finally{
            uComm.close(pstmt, conn);
        }
        return ret;
    }
    @Override
    public List<userDTO> selectAll() throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<userDTO> list = new ArrayList<>();
        try{
            conn = uComm.getConnection();
            String sql = "select * from user";
            pstmt = conn.prepareStatement(sql);

            //execute query() 반환값이 있을때
            //execute Update() 반환값이 없을때.
            rs = pstmt.executeQuery();
            while(rs.next()){
                userDTO userdto = new userDTO();
                userdto.setUname(rs.getString("uname"));
                userdto.setComment(rs.getString("comment"));
                list.add(userdto);
            }
        }finally{
            uComm.close(rs,pstmt,conn);
        }
        return list;
    }
    @Override
    public int delete(userDTO userdto) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int ret = 0;
        try{
            conn = uComm.getConnection();
            String sql = "delete from user where uname = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userdto.getUname());
            ret = pstmt.executeUpdate();
        }finally{
            uComm.close(pstmt, conn);
        }
        return ret;
    }
    @Override
    public boolean findUser(String Uname) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean bool =false;
        try{
            conn = uComm.getConnection();
            String sql = "select uname from user where uname ='"+ Uname+"';";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            List<userDTO> list = new ArrayList<>();

            while(rs.next()){
                userDTO userdto = new userDTO();
                userdto.setUname(rs.getString("uname"));
                list.add(userdto);
            }
            for(userDTO i:list){
                if(Objects.equals(Uname, i.getUname())){
                    bool = true;
                }else{
                    bool = false;
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
            bool = false;
        }
        finally{
            uComm.close(rs,pstmt,conn);
        }
        return bool;
    }
}
