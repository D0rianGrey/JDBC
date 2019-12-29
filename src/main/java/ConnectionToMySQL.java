import com.mysql.cj.protocol.Resultset;
import org.testng.Assert;

import java.sql.*;

public class ConnectionToMySQL {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String userName = "root";
        String password = "qwerty12";
        String connectionUrl = "jdbc:mysql://localhost:3306/mysql";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionUrl, userName, password)) {
            Statement statement = connection.createStatement();
            //ResultSet resultSet = statement.executeQuery("select * from mysql.help_category where name = 'WKB'");
            statement.execute("DROP TABLE mysql.Books");
            statement.executeUpdate("create table if not exists Books" +
                    " (id MEDIUMINT not null auto_increment, name CHAR(30) not null, dt DATE, primary key (id))");
            /*while (resultSet.next()){
                System.out.println(resultSet.getString(2));
            }*/

            /*PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into mysql.Books (name, dt) values ('someName', ?)");

            preparedStatement.setDate(1, new Date(1577295700316L));
            preparedStatement.execute();
            System.out.println(preparedStatement);*/

            /*statement.executeUpdate("insert into mysql.Books (name, dt) values ('someName', '2019-12-25')");
            ResultSet resultSet = statement.executeQuery("select * from mysql.Books");
            while (resultSet.next()){
                System.out.println(resultSet.getDate("dt"));
            }*/

            statement.executeUpdate("insert into mysql.Books (name) values ('Test')");

            /*CallableStatement callableStatement = connection.prepareCall("{call BooksCount(?)}");
            callableStatement.registerOutParameter(1,Types.INTEGER);
            callableStatement.execute();
            System.out.println(callableStatement.getInt(1));
            System.out.println("----");

            CallableStatement callableStatement2 = connection.prepareCall("{call getBooks(?)}");
            callableStatement2.setInt(1,1);

            if(callableStatement2.execute()){
                ResultSet resultSet = callableStatement2.getResultSet();
                while(resultSet.next()){
                    System.out.println(resultSet.getInt("id"));
                    System.out.println(resultSet.getString("name"));
                }
            }*/

            CallableStatement callableStatement3 = connection.prepareCall("{call getCount()}");
            boolean hasResults = callableStatement3.execute();
            while (hasResults) {
                ResultSet resultSet = callableStatement3.getResultSet();
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(1));
                }

                hasResults = callableStatement3.getMoreResults();
            }
        }
    }
}
