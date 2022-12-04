package DAO;

import DTO.SiiSiDTO;
import DTO.SiiUiDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface siinformationDAO {

    List<SiiSiDTO> sinformationJoin() throws SQLException;

    List<SiiUiDTO> uinterestJoin() throws  SQLException;

}
