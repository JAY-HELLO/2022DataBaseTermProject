import java.sql.*;
public class Main {
    public static void main(String[] args) {

        Connection con;
        Statement stmt;
        ResultSet rs;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(
                    "jdbc:mysql://192.168.56.3:4567/db_project",
                    "jjlee","root");
            stmt=con.createStatement();
            rs=stmt.executeQuery("SELECT * FROM Book");
            while(rs.next())
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+
                        " "+rs.getString(3));
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}