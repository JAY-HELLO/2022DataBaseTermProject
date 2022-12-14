package DAO;
import DTO.uinterestDTO;
import dbconnect.userCommon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class uinterestDAOImpl implements uinterestDAO {

    private userCommon uComm = userCommon.getInstance();

    @Override
    public List<uinterestDTO> selectAll(String uname) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<uinterestDTO> list = new ArrayList<>();
        try{
            conn = uComm.getConnection();
            String sql = "select * from uinterest where uname ='"+uname+"';";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()){
                uinterestDTO uidto = new uinterestDTO();
                uidto.setScode(rs.getInt("scode"));
                uidto.setScomment(rs.getString("scomment"));
                list.add(uidto);
            }
        }finally{
            uComm.close(rs,pstmt,conn);
        }
        return list;
    }

    @Override
    public boolean Delete(String uname,int scode) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean bool=false;
        int ret=0;

        try{
            conn = uComm.getConnection();
            String sql = "delete from uinterest where uname = '"+uname+"' and scode = '"+scode+"';";
            pstmt = conn.prepareStatement(sql);
            ret = pstmt.executeUpdate();
            bool = true;
        }catch (Exception e){
            e.printStackTrace();
            bool = false;
        }
        finally{
            uComm.close(pstmt, conn);
        }
        return bool;
    }

    @Override
    public int Insert(uinterestDTO uidto) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int ret = 0;
        try{
            conn = uComm.getConnection();
            String sql = "insert into uinterest (uname, scode, scomment) values (?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,uidto.getUname());
            pstmt.setInt(2,uidto.getScode());
            pstmt.setString(3,uidto.getScomment());
            ret = pstmt.executeUpdate();
        }finally{
            uComm.close(pstmt, conn);
        }
        return ret;
    }
}
