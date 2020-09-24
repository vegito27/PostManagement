package webapp;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class CloseConnection {

    public void Connectionclose(Connection con, PreparedStatement stmnt){

        if (stmnt != null) {
            try {
                stmnt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
