package DAO;
import DTO.uinterestDTO;

import java.sql.SQLException;
import java.util.List;

public interface uinterestDAO {
    List<uinterestDTO> selectAll(String uname) throws SQLException;
    boolean Delete(String uname, int scode) throws  SQLException;
    int Insert(uinterestDTO uidto) throws SQLException;
}
