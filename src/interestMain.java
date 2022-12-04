import java.sql.SQLException;
import java.util.Scanner;

import Controller.uinterestController;


public class interestMain {
    public static void userInterestMain(String uname) throws SQLException{

        Scanner scan = new Scanner(System.in);

        Integer menu = 0;

        do{
            System.out.println("#################################################");
            System.out.println("WITH Double_J 관심종목 프로그램에 오신 것을 환영합니다.");
            System.out.println("0. 뒤로가기");
            System.out.println("1. 관심종목 목록보기");
            System.out.println("2. 관심종목 추가");
            System.out.println("3. 관심종목 삭제");
            System.out.println("#################################################");

            menu = Integer.parseInt(scan.nextLine());
            if(menu==0){
                break;
            }else if(menu == 1){
                uinterestController.ActionUinterestShow(uname);
            }else if(menu ==2){

            }else if(menu ==3){
                uinterestController.ActionUinterestShow(uname);

                uinterestController.ActionUinterestDelete(uname);
            }
        }while(true);

    }
}
