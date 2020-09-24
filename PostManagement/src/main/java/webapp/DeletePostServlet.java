package webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns="/deletepost.do")

public class DeletePostServlet extends HttpServlet {

    PostDao postdao=new PostDao();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id=Integer.parseInt((String)request.getParameter("id"));

        postdao.deletepost(id);

        request.getRequestDispatcher("/post.do").forward(request,response);
    }
}
