package webapp;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

    ValidateUser user=new ValidateUser();
    UserDao userdao=new UserDao();
    PostDao postdao=new PostDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }


    @Override
    protected  void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{

        request.setAttribute("email",request.getParameter("email"));
        request.setAttribute("password",request.getParameter("password"));

        String useremail= (String) request.getAttribute("email");
        String userpassword=(String)request.getAttribute("password");


        boolean isvalid=user.validate(useremail,userpassword);

        String Usertype=userdao.getUserType(useremail);

        if(isvalid){

            if("admin".equals(Usertype)) {

                response.sendRedirect("list.do");
            }

            else{

               User use=userdao.getUser((String)request.getAttribute("email"),(String)request.getAttribute("password"));

                request.setAttribute("id",Integer.toString(use.getId()));
                request.setAttribute("firstname",request.getParameter("firstname"));
                request.setAttribute("lastname",request.getParameter("lastname"));
                request.setAttribute("email",request.getParameter("email"));
                request.setAttribute("password",request.getParameter("password"));
                request.setAttribute("mobile",request.getParameter("mobile"));
                request.setAttribute("state",request.getParameter("state"));
                request.setAttribute("city",request.getParameter("city"));
                request.setAttribute("country",request.getParameter("country"));
                request.setAttribute("gender",request.getParameter("gender"));
                request.setAttribute("pincode",request.getParameter("pincode"));
                request.setAttribute("address",request.getParameter("address"));

                HttpSession session=request.getSession();
                session.setAttribute("id",Integer.toString(use.getId()));
                session.setAttribute("firstname",use.getFirstname());
                session.setAttribute("lastname",use.getLastname());
                session.setAttribute("email",use.getEmail());
                session.setAttribute("mobile",use.getMobile());
                session.setAttribute("state",use.getState());
                session.setAttribute("city",use.getCity());
               session.setAttribute("userid",use.getId());

               response.sendRedirect("post.do");

            }

        }
        else{
            request.setAttribute("errormessage","Invalid Credentials!!");
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }

}
