package Controller;
import java.sql.*;
import java.util.List;
import java.util.Scanner;

import DAO.userDAOImpl;
import DTO.userDTO;
public class userController {
    public static void ActionUserInsert() throws SQLException {
        String uname;
        String comment;

        userDTO udto = new userDTO();
        userDAOImpl dimpl = new userDAOImpl();

        Scanner scan = new Scanner(System.in);

        System.out.println("새로운 사용자 이름을 등록하세요 : ");
        uname = scan.nextLine();
        System.out.println("사용자에 대한 설명을 등록하세요 : ");
        comment = scan.nextLine();

        udto.setUname(uname);
        udto.setComment(comment);

        dimpl.insert(udto);
    }
    public static void ActionUserShow() throws SQLException {
        userDAOImpl dimpl = new userDAOImpl();
        List<userDTO> result;
        result = dimpl.selectAll();
        for(userDTO i:result){
            System.out.print("|| 사용자 이름 : "+i.getUname());
            System.out.print(" || 사용자 설명 : "+i.getComment());
            System.out.println("\n");
        }
    }
    public static void ActionUserDelete() throws SQLException{
        userDAOImpl dimpl = new userDAOImpl();
        userDTO udto = new userDTO();
        Scanner scan = new Scanner(System.in);

        String uname;
        System.out.print("삭제할 사용자 이름을 입력하세요: \n");
        uname = scan.nextLine();
        udto.setUname(uname);

        dimpl.delete(udto);
    }
    public static String ActionUserSelect() throws SQLException{
        System.out.print("원하는 사용자를 선택하세요 : \n");
        Scanner scan = new Scanner(System.in);
        String uname = scan.nextLine();
        userDAOImpl dimpl = new userDAOImpl();
        if(dimpl.findUser(uname)){
            System.out.println(uname + "사용자가 선택되었습니다.");
            return uname;
        }else{
            System.out.println("찾으시는 사용자가 없습니다.");
            return "no";
        }

    }
}
