package Controller;
import DAO.uinterestDAOImpl;
import DTO.uinterestDTO;


import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

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
    public static void ActionUinterestDelete(String uname) throws SQLException{

        uinterestDAOImpl uidimpl = new uinterestDAOImpl();
        Scanner scan = new Scanner(System.in);
        System.out.println("삭제할 종목코드를 입력하세요 : \n");
        int scode = Integer.parseInt(scan.nextLine());
        if(uidimpl.Delete(uname,scode)){
            System.out.println("삭제되었습니다.");
        }else{
            System.out.println("해당 종목이 없습니다.");
        }

    }

}
