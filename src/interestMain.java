import java.sql.SQLException;
import java.util.Scanner;

import Controller.uinterestController;
import Controller.sinformationController;
import Controller.siinformationController;
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
            System.out.println("3. 관심종목 상세 정보 보기");
            System.out.println("4. 관심종목 삭제");
            System.out.println("5. 모든 종목 보기");
            System.out.println("#################################################");

            menu = Integer.parseInt(scan.nextLine());
            if(menu==0){
                break;
            }else if(menu == 1){
                uinterestController.ActionUinterestSelect(uname);
            }else if(menu ==2) {
                uinterestController.ActionUinterestInsert(uname);
            }else if(menu ==3){
                siinformationController.ActionUinformationJoin(uname);
            }
            else if(menu ==4){
                uinterestController.ActionUinterestSelect(uname);
                uinterestController.ActionUinterestDelete(uname);
            }else if(menu ==5){
                sinformationController.ActionSinformationSelectAll();
            }
        }while(true);

    }
}
