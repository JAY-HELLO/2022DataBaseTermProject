package DAO;
import DTO.uinterestDTO;
import DTO.userDTO;
import dbconnect.userCommon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class uinterestDAOImpl implements uinterestDAO {

    private userCommon uComm = userCommon.getInstance();
    private static uinterestDAO useridao = new uinterestDAOImpl();

    @Override
    public List<uinterestDTO> selectAll(String uname) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<uinterestDTO> list = new ArrayList<>();
        try{
            conn = uComm.getConnection();
            String sql = "select * from uinterest";
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
    public int Delete(uinterestDTO userDTO) throws SQLException {
        return 0;
    }

    @Override
    public int Insert(uinterestDTO userDTO) throws SQLException {
        return 0;
    }
}
