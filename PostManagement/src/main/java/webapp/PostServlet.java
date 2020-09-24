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
import java.sql.ResultSet;
import java.util.List;


@WebServlet(urlPatterns="/post.do")
public class PostServlet extends HttpServlet {

    CloseConnection connection=new CloseConnection() ;
    GetConnection getConnection=new GetConnection();

    UserDao userdao=new UserDao();
    PostDao postdao=new PostDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession(false);

        if (session == null) {
            response.sendRedirect("login.do");
        }
        int id = (Integer)session.getAttribute("userid");

        System.out.println("id of post.do method->()"+id);

        List<Post> list = postdao.getPost(id);
        System.out.println(list.size());

        request.setAttribute("posts", list);

        request.getRequestDispatcher("/WEB-INF/postlist.jsp").forward(request, response);

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session=request.getSession(false);

        int Id=Integer.parseInt((String)session.getAttribute("id"));
        request.setAttribute("title", request.getParameter("title"));
        request.setAttribute("post", request.getParameter("post"));

        Connection con = null;

        PreparedStatement st = null;

        ResultSet rs=null;

        try {
            con = getConnection.initializeDatabase("postmanagement");

            st = con.prepareStatement("insert into posts(userid,title,post) values(?,?,?)");

            st.setInt(1,Id);
            st.setString(2, (String)request.getParameter("title"));
            st.setString(3, (String)request.getParameter("post"));

            st.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            // Close all the connections
          connection.Connectionclose(con,st);
        }

        List<Post> list =postdao.getPost(Id);

        request.setAttribute("posts",list);

        request.getRequestDispatcher("/WEB-INF/postlist.jsp").forward(request,response);

    }

}
