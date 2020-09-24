package webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns="/display.do")

public class DisplayProfileServlet extends HttpServlet
{

    UserDao userdao=new UserDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        User user=userdao.getUserDetails(Integer.parseInt((String)(request.getParameter("id"))));

        int count=userdao.totalpost(Integer.parseInt((String)(request.getParameter("id"))));

        request.setAttribute("id",Integer.parseInt((String)(request.getParameter("id"))));
        request.setAttribute("firstname",user.getFirstname());
        request.setAttribute("lastname",user.getLastname());
        request.setAttribute("address",user.getAddress());
        request.setAttribute("country",user.getCountry());
        request.setAttribute("gender",user.getGender());
        request.setAttribute("pincode",user.getPincode());
        request.setAttribute("mobile",user.getMobile());
        request.setAttribute("email",user.getEmail());
        request.setAttribute("city",user.getCity());
        request.setAttribute("state",user.getState());
        request.setAttribute("postcount",count);

        request.getRequestDispatcher("WEB-INF/profilepage.jsp").forward(request,response);

    }


}
