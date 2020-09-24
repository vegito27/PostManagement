package webapp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ValidateUser {

    CloseConnection connection =new CloseConnection();
    GetConnection getConnection=new GetConnection();

    public boolean validate(String useremail, String userpassword) {
        Connection con = null;

        PreparedStatement st = null;

        ResultSet rs = null;

        String usermail;
        String pass;

        boolean login=false; ;

        try {
            con = getConnection.initializeDatabase("postmanagement");

            st = con.prepareStatement("select email,password from users where email=? and password=? ");

            st.setString(1, useremail);
            st.setString(2, userpassword);

            st.executeQuery();

            rs = st.getResultSet();


            while (rs.next()) {

                usermail = rs.getString("email");

                pass = rs.getString("password");

                if (useremail.equals( usermail )&& userpassword.equals( pass)) {

                    login = true;
                    break;

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
        } finally {
            // Close all the connections
            connection.Connectionclose(con,st);
        }

        return login;
    }

    public boolean validatePassword(String userpassword) {
        Connection con = null;

        PreparedStatement st = null;

        ResultSet rs = null;

        String pass;

        boolean login=false; ;

        try {
            con = getConnection.initializeDatabase("postmanagement");

            st = con.prepareStatement("select email,password from users where password=? ");

            st.setString(1, userpassword);

            st.executeQuery();

            rs = st.getResultSet();


            while (rs.next()) {

                pass = rs.getString("password");

                if (userpassword.equals( pass)) {

                    login = true;
                    break;

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
        } finally {
            // Close all the connections
            connection.Connectionclose(con,st);
        }

        return login;
    }

    public boolean validateEmail(String useremail) {
        Connection con = null;

        PreparedStatement st = null;

        ResultSet rs = null;

        String usermail;
        String pass;

        boolean login=false; ;

        try {
            con = getConnection.initializeDatabase("postmanagement");

            st = con.prepareStatement("select email,password from users where email=? ");

            st.setString(1, useremail);

            st.executeQuery();

            rs = st.getResultSet();


            while (rs.next()) {

                usermail = rs.getString("email");

                pass = rs.getString("password");

                if (useremail.equals( usermail )) {

                    login = true;
                    break;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
        } finally {
            // Close all the connections
            connection.Connectionclose(con,st);
        }

        return login;
    }


}