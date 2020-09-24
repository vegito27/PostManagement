package webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/list.do")
public class UserList extends HttpServlet {

    UserDao userdao=new UserDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<User> li=userdao.getUsers("normaluser");

        request.setAttribute("users",li);

        request.getRequestDispatcher("/WEB-INF/usertable.jsp").forward(request, response);

    }

}
