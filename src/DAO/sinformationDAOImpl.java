package DAO;

import DTO.sinformationDTO;
import dbconnect.userCommon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class sinformationDAOImpl implements sinformationDAO {
    private userCommon uComm = userCommon.getInstance();

    @Override
    public List<sinformationDTO> selectAll() throws SQLException {


        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<sinformationDTO> list = new ArrayList<>();
        try{
            conn = uComm.getConnection();
            String sql = "select * from sinformation";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()){
                sinformationDTO sidto = new sinformationDTO();
                sidto.setScode(rs.getInt("scode"));
                sidto.setSname(rs.getString("sname"));
                sidto.setSmarket(rs.getString("smarket"));
                sidto.setStheme(rs.getString("stheme"));
                list.add(sidto);
            }
        }finally{
            uComm.close(rs,pstmt,conn);
        }
        return list;
    }
}
