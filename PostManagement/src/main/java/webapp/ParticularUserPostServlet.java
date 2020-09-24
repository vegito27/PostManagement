package webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/particularpost.do")

public class ParticularUserPostServlet extends HttpServlet {

    PostDao postdao=new PostDao();
    UserDao dao=new UserDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int id=Integer.parseInt((String)request.getParameter("id"));
        int count1=dao.totalpost(id);

         List<Post> postlist= postdao.getPost(id);

         User user=dao.getUserDetails(id);
         request.setAttribute("firstname",user.getFirstname());
         request.setAttribute("lastname",user.getLastname());

         request.setAttribute("userpost",postlist);
         request.setAttribute("postcount",count1);

         request.getRequestDispatcher("WEB-INF/userposts.jsp").forward(request,response);

    }


}
