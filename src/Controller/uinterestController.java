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

    public static void ActionUinterestInsert(String uname)throws SQLException{

        uinterestDAOImpl uidimpl = new uinterestDAOImpl();
        uinterestDTO uidto = new uinterestDTO();
        int scode = 0;
        String scomment = null;
        Scanner scan = new Scanner(System.in);

        System.out.println("추가할 종목 코드를 입력하세요 : ");
        scode = Integer.parseInt(scan.nextLine());
        System.out.println("추가할 종목 코멘트를 입력하세요 : ");
        scomment = scan.nextLine();

        uidto.setUname(uname);
        uidto.setScode(scode);
        uidto.setScomment(scomment);
        if(uidimpl.Insert(uidto)!=0){
            System.out.println("정상적으로 추가되었습니다.");
        }else{
            System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
        }
    }


}
