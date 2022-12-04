package DAO;
import DTO.uinterestDTO;

import java.sql.SQLException;
import java.util.List;

public interface uinterestDAO {
    List<uinterestDTO> selectAll(String uname) throws SQLException;
    int Delete(uinterestDTO userDTO) throws  SQLException;
    int Insert(uinterestDTO userDTO) throws SQLException;
}
