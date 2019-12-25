import com.mysql.cj.protocol.Resultset;
import org.testng.Assert;

import java.sql.*;

public class ConnectionToMySQL {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String userName = "root";
        String password = "qwerty12";
        String connectionUrl = "jdbc:mysql://localhost:3306";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionUrl, userName, password)) {
            //System.out.println("We're connected");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from mysql.help_category where name = 'WKB'");
            while(resultSet.next()){
                System.out.println(resultSet.getString("name"));
            }


        }

    }
}
