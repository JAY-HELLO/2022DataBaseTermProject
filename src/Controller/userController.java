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

        udto.setName(uname);
        udto.setComment(comment);

        dimpl.insert(udto);
    }
    public static void ActionUserSelect() throws SQLException {
        userDAOImpl dimpl = new userDAOImpl();
        List<userDTO> result;
        result = dimpl.select();
        for(userDTO i:result){
            System.out.print("사용자 고유번호 : "+i.getUssn());
            System.out.print(" || 사용자 이름 : "+i.getName());
            System.out.print(" || 사용자 설명 : "+i.getComment());
            System.out.println("\n");
        }
    }
    public static void ActionUserDelete() throws SQLException{
        userDAOImpl dimpl = new userDAOImpl();
        userDTO udto = new userDTO();
        Scanner scan = new Scanner(System.in);

        int ussn;
        String uname;

        System.out.print("삭제할 사용자 고유번호를 입력하세요: \n");
        ussn = Integer.parseInt(scan.nextLine());
        System.out.print("삭제할 사용자 이름을 입력하세요: \n");
        uname = scan.nextLine();
        udto.setUssn(ussn);
        udto.setName(uname);

        dimpl.delete(udto);
    }
}
