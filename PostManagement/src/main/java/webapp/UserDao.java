package webapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    CloseConnection connection=new CloseConnection();
    GetConnection getConnection=new GetConnection();

    public String getUserType(String email) {

        Connection con = null;

        PreparedStatement st = null;

        ResultSet rs = null;

        String usertype1 = null;


        try {
            con = getConnection.initializeDatabase("postmanagement");

            st = con.prepareStatement("select usertype,email from users where email=?");

            st.setString(1,email);

            st.executeQuery();

            rs = st.getResultSet();


            while (rs.next()) {

                usertype1 = rs.getString("usertype");

            }

        } catch (
                SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close all the connections
            connection.Connectionclose(con,st);
        }

        return usertype1;

    }

    public List<User> getUsers(String usertype){

        List<User> userlist = new ArrayList<User>();

        Connection con = null;

        PreparedStatement st = null;

        ResultSet rs = null;


        try {
            con =getConnection.initializeDatabase("postmanagement");


            st = con.prepareStatement("select * from users where usertype=? ");

            st.setString(1, usertype);

            st.executeQuery();

            rs = st.getResultSet();


            while (rs.next()) {

                User user = new User();

                user.setId(rs.getInt("id"));
                user.setFirstname((rs.getString("firstname")));
                user.setLastname(rs.getString("lastname"));
                user.setEmail(rs.getString("email"));
               user.setMobile(rs.getString("mobile"));
                user.setCity((rs.getString("city")));
                user.setAddress(rs.getString("address"));
                user.setGender(rs.getString("gender"));
                user.setState(rs.getString("state"));
                user.setCountry(rs.getString("country"));
                user.setPincode(rs.getString("pincode"));
                user.setPassword(rs.getString("password"));

                userlist.add(user);
            }


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close all the connections
            connection.Connectionclose(con,st);
        }
        return userlist;
    }

    public User getUser(String email,String password){

        User user = new User();

        Connection con = null;

        PreparedStatement st = null;

        ResultSet rs = null;


        try {
            con =getConnection.initializeDatabase("postmanagement");

            st = con.prepareStatement("select * from users where email=? and password=? ");

            st.setString(1, email);
            st.setString(2, password);


            st.executeQuery();

            rs = st.getResultSet();


            while (rs.next()) {

                user.setId(rs.getInt("id"));
                user.setFirstname((rs.getString("firstname")));
                user.setLastname(rs.getString("lastname"));
                user.setEmail(rs.getString("email"));
                user.setMobile(rs.getString("mobile"));
                user.setCity((rs.getString("city")));
                user.setAddress(rs.getString("address"));
                user.setGender(rs.getString("gender"));
                user.setState(rs.getString("state"));
                user.setCountry(rs.getString("country"));
                user.setPincode(rs.getString("pincode"));
                user.setPassword(rs.getString("password"));

            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close all the connections
           connection.Connectionclose(con,st);
        }
        return user;
    }

    public  int totalpost(int id){

        int count=0;
        Connection con = null;

        PreparedStatement st = null;
        PreparedStatement st2 = null;

        ResultSet rs = null;


        try {
            con =getConnection.initializeDatabase("postmanagement");

            st = con.prepareStatement("select count(userid) tpost from posts where userid="+id);

            System.out.println(st);
            st.executeQuery();

            rs = st.getResultSet();

            while (rs.next()) {
                count=rs.getInt("tpost");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close all the connections
            connection.Connectionclose(con,st);

        }
        return count;

    }

    public User getUserDetails(int id){

        User user = new User();

        Connection con = null;

        PreparedStatement st = null;
        PreparedStatement st2 = null;

        ResultSet rs = null;


        try {
            con =getConnection.initializeDatabase("postmanagement");

            st = con.prepareStatement("select * from users where id="+id);


            st.executeQuery();

            rs = st.getResultSet();

            while (rs.next()) {

                user.setId(rs.getInt("id"));
                user.setFirstname((rs.getString("firstname")));
                user.setLastname(rs.getString("lastname"));
                user.setEmail(rs.getString("email"));
                user.setMobile(rs.getString("mobile"));
                user.setCity((rs.getString("city")));
                user.setAddress(rs.getString("address"));
                user.setGender(rs.getString("gender"));
                user.setState(rs.getString("state"));
                user.setCountry(rs.getString("country"));
                user.setPincode(rs.getString("pincode"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close all the connections
            connection.Connectionclose(con,st);

        }

        return user;
    }

    public int getadminId(String email){

        int number=0;

        Connection con = null;

        PreparedStatement st = null;

        ResultSet rs = null;


        try {
            con =getConnection.initializeDatabase("postmanagement");

            st = con.prepareStatement("select id from users where email=?");

            st.setString(1,email);

            st.executeQuery();

            rs = st.getResultSet();

            while (rs.next()) {
                number=rs.getInt("id");
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Close all the connections
            connection.Connectionclose(con,st);

        }
        return number;

    }





    public static void main(String[] args) {
        UserDao dao=new UserDao();


     //   int count=dao.totalpost(5);

//        System.out.println(count);

        int count1=dao.getadminId("trishabh885@gmail.com");

        System.out.println(count1);



    }




    }




