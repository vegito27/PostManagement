package webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;


@WebServlet(urlPatterns = "/editpost.do")

public class EditPostServlet extends HttpServlet {

    CloseConnection connection=new CloseConnection() ;
    GetConnection getConnection=new GetConnection();

    UserDao userdao=new UserDao();
    PostDao postdao=new PostDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {

        HttpSession session=request.getSession(false);

        if(session==null){
            response.sendRedirect("login.do");
        }

        int id=Integer.parseInt((String)request.getParameter("id"));

        Post userpost = postdao.getpost(id);

        request.setAttribute("postid",request.getParameter("id"));
        request.setAttribute("title",userpost.getTitle());


        request.setAttribute("post",userpost.getPost());

        request.getRequestDispatcher("WEB-INF/editpost.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {


        request.setAttribute("title",request.getParameter("title"));

        request.setAttribute("post",request.getParameter("post"));

        request.setAttribute("postid",request.getParameter("id"));

        System.out.println(request.getAttribute("postid"));

        Connection con=null;

        PreparedStatement st=null;

        try {

            con = getConnection.initializeDatabase("postmanagement");

            st = con.prepareStatement("update posts set post=? ,title=? where id=?");

            st.setString(1,request.getParameter("post"));

            st.setString(2,request.getParameter("title"));

            st.setInt(3,Integer.parseInt((String) request.getParameter("postid")));


            System.out.println("postp->"+request.getParameter("post"));
            System.out.println("titlea->"+request.getParameter("title"));
            System.out.println("ida->"+request.getParameter("id"));

            st.executeUpdate();
        }
        catch (Exception e) {

            e.printStackTrace();

        }
        finally{
            // Close all the connections
            connection.Connectionclose(con,st);
        }

        request.getRequestDispatcher("/post.do").forward(request,response);

    }

}
