package servlet;

import listener.HttpSessionActivation;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class PassivateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session=req.getSession();
        HttpSessionActivation activation=new HttpSessionActivation();
        activation.setId(req.getParameter("id"));
        activation.setName(req.getParameter("name"));
        session.setAttribute("Listener",activation);

    }
}
