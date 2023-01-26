package hello.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 서블릿 -> jsp
        String viewPath = "/WEB-INF/views/new-form.jsp";

        // 컨트롤러 -> 뷰
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);

        // 서블릿에서 jsp호출
        dispatcher.forward(request, response);
    }
}
