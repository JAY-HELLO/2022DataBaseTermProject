package Controller;
import DAO.sinformationDAOImpl;
import DTO.sinformationDTO;
import DTO.uinterestDTO;

import java.sql.SQLException;
import java.util.List;

public class sinformactionController {
    public static void ActionSinformationSelectAll()throws SQLException {
        sinformationDAOImpl sidimpl = new sinformationDAOImpl();
        sinformationDTO sidto = new sinformationDTO();

        List<sinformationDTO> result;
        result = sidimpl.selectAll();
        for(sinformationDTO i:result){
            System.out.print(" || 종목코드 : "+i.getScode());
            System.out.print(" || 종목명 : "+i.getSname());
            System.out.print(" || 상장지수 : "+i.getSmarket());
            System.out.print(" || 종목테마 : "+i.getStheme());
            System.out.println("\n");
        }
    }
}
