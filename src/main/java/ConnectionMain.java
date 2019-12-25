import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionMain {
    public Statement connectionToDB() throws SQLException {
        String userName = "root";
        String password = "qwerty12";
        String connectionUrl = "jdbc:mysql://localhost:3306";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(connectionUrl, userName, password)) {
            //System.out.println("We're connected");
            Statement statement = connection.createStatement();

            return statement;

        }

    }
}
