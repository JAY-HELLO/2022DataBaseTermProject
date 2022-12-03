import java.sql.*;
import java.util.List;
import java.util.Scanner;

import DAO.userDAOImpl;
import DTO.userDTO;

public class Main {
    static userDAOImpl dimpl = new userDAOImpl();
    static userDTO udto = new userDTO();
    static List<userDTO> result;
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Scanner scan = new Scanner(System.in);

        Integer menu = 0;
        do{
            System.out.println("#################################################");
            System.out.println("WITH Double_J 관심종목 프로그램에 오신 것을 환영합니다.");
            System.out.println("1. 사용자 생성");
            System.out.println("2. 사용자 목록보기");
            System.out.println("#################################################");

            menu = scan.nextInt();
            if(menu==0){
                break;
            }else if(menu == 1){
                ActionUserInsert();

            }else if(menu == 2){
                result = dimpl.select();
                for(userDTO i:result){
                    System.out.print("사용자 고유번호 : "+i.getUssn());
                    System.out.print(" || 사용자 이름 : "+i.getName());
                    System.out.print(" || 사용자 설명 : "+i.getComment());
                    System.out.println("\n");
                }
            }
        }while(true);

    }
    public static void ActionUserInsert() throws SQLException {
        String uname;
        String comment;
        userDTO udto = new userDTO();
        userDAOImpl dimpl = new userDAOImpl();
        Scanner scan = new Scanner(System.in);
        System.out.println("새로운 사용자 이름을 등록하세요 : ");
        uname = scan.nextLine().toString();
        System.out.println("사용자에 대한 설명을 등록하세요 : ");
        comment = scan.nextLine().toString();
        udto.setName(uname);
        udto.setComment(comment);
        dimpl.insert(udto);
    }
}