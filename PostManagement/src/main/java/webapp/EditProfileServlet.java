package webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;


@WebServlet(urlPatterns = "/editprofile.do")

public class EditProfileServlet extends HttpServlet {
    CloseConnection close=new CloseConnection();
    GetConnection connection=new GetConnection();

    UserDao dao=new UserDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email=(String)request.getAttribute("email");

        User user=dao.getUserDetails(dao.getadminId(email));

        request.setAttribute("firstname",user.getFirstname());
        request.setAttribute("lastname",user.getLastname());
        request.setAttribute("address",user.getAddress());
        request.setAttribute("state",user.getState());
        request.setAttribute("city",user.getCity());
        request.setAttribute("pincode",user.getPincode());
        request.setAttribute("gender",user.getGender());

        request.getRequestDispatcher("/WEB-INF/editform.jsp");

    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {


       /* request.setAttribute("firstname", request.getParameter("firstname"));
        request.setAttribute("lastname", request.getParameter("lastname"));
        request.setAttribute("address", request.getParameter("address"));
        request.setAttribute("state", request.getParameter("state"));
        request.setAttribute("city", request.getParameter("city"));
        request.setAttribute("pincode", request.getParameter("pincode"));
        request.setAttribute("gender", request.getParameter("gender"));


        Connection con=null;

        PreparedStatement st=null;

        try {

            con = connection.initializeDatabase("postmanagement");

            st = con.prepareStatement("update users set firstname=? ,lastname=? address=? state=? city=? pincode=? gender=? where id=?");

            st.setString(1,request.getParameter("addpost"));
            st.setString(2,request.getParameter("title"));

            System.out.println(request.getParameter("addpost"));
            System.out.println(request.getParameter("title"));
            System.out.println(st);

            st.executeUpdate();
        }
        catch (Exception e) {

            e.printStackTrace();

        }
        finally{
            // Close all the connections
         close.Connectionclose();
        }

        request.getRequestDispatcher("/post.do").forward(request,response);

    }*/


    }
}
