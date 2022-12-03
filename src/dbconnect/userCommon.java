package dbconnect;
import java.sql.*;

public class userCommon {
    public static final String Driver = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://192.168.56.3:4567/db_project";
    public static final String UID = "jjlee";
    public static final String UPW = "root";

    public static final String USER_INSERT =
            "INSERT INTO user"
                    + "(ussn, uname, uphone)"
                    + "VALUES(?,?,?)";


}
