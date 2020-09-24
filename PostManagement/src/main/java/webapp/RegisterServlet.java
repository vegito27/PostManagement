package webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/register.do")
public class RegisterServlet extends HttpServlet {

     CloseConnection connection=new CloseConnection();
     GetConnection getConnect=new GetConnection();
      boolean flag;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("/WEB-INF/registrationform.jsp").forward(request, response);

    }

    @Override
    public  void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{

        request.setAttribute("firstname",request.getParameter("firstname"));
        request.setAttribute("lastname",request.getParameter("lastname"));
        request.setAttribute("email",request.getParameter("email"));
        request.setAttribute("password",request.getParameter("password"));
        request.setAttribute("confirmpassword",request.getParameter("confirmpassword"));
        request.setAttribute("mobile",request.getParameter("mobile"));
        request.setAttribute("state",request.getParameter("state"));
        request.setAttribute("city",request.getParameter("city"));
        request.setAttribute("country",request.getParameter("country"));
        request.setAttribute("gender",request.getParameter("gender"));
        request.setAttribute("pincode",request.getParameter("pincode"));
        request.setAttribute("address",request.getParameter("address"));


        Connection con=null;

        PreparedStatement st=null;

        try {

            // Initialize the database

            con = getConnect.initializeDatabase("postmanagement");

            System.out.println(con);


            // Create a SQL query to insert data into demo table
            // demo table consists of two columns, so two '?' is used

            st = con.prepareStatement("insert into users(firstname,lastname,email,mobile,gender,address,city,pincode,state,country,password) values(?,?,?,?,?,?,?,?,?,?,?)");

            System.out.println(st);
            // For the first parameter,
            // get the data using request object
            // sets the data to st pointer

            // Same for second parameter

            st.setString(1, (String)request.getParameter("firstname"));
            st.setString(2, (String)request.getParameter("lastname"));

            st.setString(3,(String)request.getParameter("email"));
            st.setString(4,(String)request.getParameter("mobile"));
            st.setString(5,(String)request.getParameter("gender"));
            st.setString(6,(String)request.getParameter("address"));

            st.setString(7, (String)request.getParameter("city"));
            st.setString(8, (String)request.getParameter("pincode"));
            st.setString(9,(String)request.getParameter("state"));
            st.setString(10,(String)request.getParameter("country"));

            st.setString(11,(String)request.getParameter("password"));

            // Execute the insert command using executeUpdate()
            // to make changes in database
            st.executeUpdate();

           flag=true;
            System.out.println(flag);

        }
        catch (Exception e) {
            e.printStackTrace();

        }finally{
            // Close all the connections
            connection.Connectionclose(con,st);

        }
        System.out.println(flag);

        if(flag==true) {

            request.getRequestDispatcher("/WEB-INF/success.jsp").forward(request, response);
        }else{
            response.sendRedirect("register.do");

        }


    }
}