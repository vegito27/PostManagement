package webapp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

// This class can be used to initialize the database connection
public class GetConnection {
    protected Connection initializeDatabase(String database)
            throws SQLException, ClassNotFoundException
    {
        // Initialize all the information regarding
        // Database Connection
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql:// localhost:3306/"+database;
        // Database name to access
        String dbUsername = "root";
        String dbPassword = "root";

        Class.forName(dbDriver);
        Connection con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
        System.out.println(con);
        return con;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        GetConnection get=new GetConnection();
        Connection connect=get.initializeDatabase("postmanagement");
        System.out.println(connect);
    }


}