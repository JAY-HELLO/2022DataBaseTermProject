package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dbconnect.userCommon;
import DTO.userDTO;

public class userDAOImpl implements userDAO{

    private userCommon uComm = userCommon.getInstance();
    private static userDAO userdao = new userDAOImpl();

    private userDAO getUserdao(){
        return userdao;
    }

    @Override
    public int insert(userDTO userdto) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        int ret = 0;

        try{
            conn = uComm.getConnection();
            String sql = "insert into user (uname,comment) values (?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userdto.getName());
            pstmt.setString(2,userdto.getComment());
            ret = pstmt.executeUpdate();
        }finally{
            uComm.close(pstmt, conn);
        }
        return ret;
    }
    @Override
    public List<userDTO> select() throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<userDTO> list = new ArrayList<>();
        try{
            conn = uComm.getConnection();
            String sql = "select * from user";
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();
            while(rs.next()){
                userDTO userdto = new userDTO();
                userdto.setUssn(rs.getInt("ussn"));
                userdto.setName(rs.getString("uname"));
                userdto.setComment(rs.getString("comment"));
                list.add(userdto);
            }
        }finally{
            uComm.close(rs,pstmt,conn);
        }
        return list;
    }
    @Override
    public int delete(userDTO userDTO) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        int ret = 0;
        try{
            conn = uComm.getConnection();
            String sql = "delete from user where ussn = ? and uname = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userDTO.getUssn());
            pstmt.setString(2, userDTO.getName());
            ret = pstmt.executeUpdate();
        }finally{
            uComm.close(pstmt, conn);
        }
        return ret;
    }
}
