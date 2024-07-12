package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    protected Connection connection;
    public DataBaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Set up your database connection details
            String username = "root";

            String dbUrl = "jdbc:mysql://localhost:3306/logindetails?autoReconnect=true&useSSL=false";
            //Database Password
            String password = "Usr@2712";

            connection = DriverManager.getConnection(dbUrl, username, password);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
