package DAO;

import DTO.sinformationDTO;
import java.sql.SQLException;
import java.util.List;

public interface sinformationDAO {
    List<sinformationDTO> selectAll() throws SQLException;
}
