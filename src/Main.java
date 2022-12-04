import java.sql.*;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import Controller.userController;
import DAO.userDAOImpl;
import DTO.userDTO;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Scanner scan = new Scanner(System.in);

        Integer menu = 0;
        do{
            System.out.println("#################################################");
            System.out.println("WITH Double_J 관심종목 프로그램에 오신 것을 환영합니다.");
            System.out.println("0. 프로그램 종료");
            System.out.println("1. 사용자 생성");
            System.out.println("2. 사용자 목록보기");
            System.out.println("3. 사용자 삭제");
            System.out.println("4. 사용자 선택");
            System.out.println("#################################################");

            menu = Integer.parseInt(scan.nextLine());
            if(menu==0){
                break;
            }else if(menu == 1){
                userController.ActionUserInsert();

            }else if(menu == 2){
                userController.ActionUserShow();
            }else if(menu == 3){
                userController.ActionUserShow();
                userController.ActionUserDelete();
            }else if(menu == 4){
                userController.ActionUserShow();
                String unameTemp = userController.ActionUserSelect();
                if(!Objects.equals(unameTemp, "no")){
                    interestMain.userInterestMain(unameTemp);
                }

            }
        }while(true);

    }


}