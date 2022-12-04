package DAO;

import DTO.*;
import dbconnect.userCommon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class siinformationDAOImpl implements siinformationDAO{
    private userCommon uComm = userCommon.getInstance();

    //stock information 과 stock invest information과의 join
    @Override
    public List<SiiSiDTO> sinformationJoin() throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;


        List<SiiSiDTO> list = new ArrayList<>();
        try{
            conn = uComm.getConnection();
            String sql = "select * from sinformation s, siinformation si where s.scode = si.scode";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                SiiSiDTO siisidto = new SiiSiDTO();
                siisidto.setScode(rs.getInt("scode"));
                siisidto.setSname(rs.getString("sname"));
                siisidto.setSmarket(rs.getString("smarket"));
                siisidto.setStheme(rs.getString("stheme"));
                siisidto.setDps(rs.getInt("dps"));
                siisidto.setPer(rs.getInt("per"));
                siisidto.setSyear(rs.getString("syear"));

                list.add(siisidto);
            }
        }finally{
            uComm.close(rs,pstmt,conn);
        }
        return list;
    }
    //사용자 관심종목과 stock invest information과의 join

    @Override
    public List<SiiUiDTO> uinterestJoin(String uname) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<SiiUiDTO> list = new ArrayList<>();
        try{
            conn = uComm.getConnection();
            String sql = "select * " +
                    "from uinterest u, sinformation s, siinformation si " +
                    "where u.uname = '"+uname+"' and s.scode = si.scode and u.scode = s.scode";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                SiiUiDTO siiuidto = new SiiUiDTO();

                siiuidto.setScode(rs.getInt("scode"));
                siiuidto.setSname(rs.getString("sname"));
                siiuidto.setSmarket(rs.getString("smarket"));
                siiuidto.setStheme(rs.getString("stheme"));
                siiuidto.setScomment(rs.getString("scomment"));
                siiuidto.setDps(rs.getInt("dps"));
                siiuidto.setPer(rs.getInt("per"));
                siiuidto.setSyear(rs.getString("syear"));

                list.add(siiuidto);
            }
        }finally{
            uComm.close(rs,pstmt,conn);
        }
        return list;
    }

}
