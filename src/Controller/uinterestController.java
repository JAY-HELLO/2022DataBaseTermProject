package Controller;
import DAO.uinterestDAOImpl;
import DTO.uinterestDTO;


import java.sql.SQLException;
import java.util.List;

public class uinterestController {
    public static void ActionUinterestShow(String uname) throws SQLException {

        uinterestDAOImpl uidimpl = new uinterestDAOImpl();

        List<uinterestDTO> result;
        result = uidimpl.selectAll(uname);
        for(uinterestDTO i:result){
            System.out.print(" || 종목코드 : "+i.getScode());
            System.out.print(" || 종목설명 : "+i.getScomment());
            System.out.println("\n");
        }
    }
}
