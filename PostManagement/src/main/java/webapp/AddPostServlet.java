package webapp;

import javax.servlet.http.HttpServlet;

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


@WebServlet(urlPatterns = "/addpost.do")

public class AddPostServlet extends HttpServlet {

    GetConnection getConnection=new GetConnection();
    CloseConnection connection=new CloseConnection();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("/WEB-INF/dopost.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

       response.sendRedirect("post.do");
    }

}








