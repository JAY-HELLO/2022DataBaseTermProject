package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import DAO.siinformationDAOImpl;
import DTO.SiiSiDTO;
import DTO.SiiUiDTO;


public class siinformationController {

    public static void ActionSinformationJoin()throws SQLException {
        siinformationDAOImpl siidimpl = new siinformationDAOImpl();

        List<SiiSiDTO> result;
        result = siidimpl.sinformationJoin();
        for(SiiSiDTO i:result){
            System.out.print(" || 종목코드 : "+i.getScode());
            System.out.print(" || 종목명 : "+i.getSname());
            System.out.print(" || 상장지수 : "+i.getSmarket());
            System.out.print(" || 종목테마 : "+i.getStheme());
            System.out.print(" || 종목 기준년도 : "+i.getSyear());
            System.out.print(" || 배당 : "+i.getDps());
            System.out.print(" || PER : "+i.getPer());
            System.out.println("\n");
        }

    }
    public static void ActionUinformationJoin(String uname)throws SQLException {
        siinformationDAOImpl siidimpl = new siinformationDAOImpl();

        List<SiiUiDTO> result = siidimpl.uinterestJoin(uname);
        for(SiiUiDTO j:result){
            System.out.print(" || 종목코드 : "+j.getScode());
            System.out.print(" || 종목명 : "+j.getSname());
            System.out.print(" || 상장지수 : "+j.getSmarket());
            System.out.print(" || 종목테마 : "+j.getStheme());
            System.out.print(" || 종목 기준년도 : "+j.getSyear());
            System.out.print(" || 배당 : "+j.getDps());
            System.out.print(" || PER : "+j.getPer());
            System.out.print(" || 사용자 코멘트 : "+j.getScomment());
            System.out.println("\n");
        }

    }
}
