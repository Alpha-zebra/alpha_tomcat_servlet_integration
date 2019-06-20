package servlet;

import com.sun.net.httpserver.HttpsServer;
import listener.HttpSessionActivation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ActiveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        HttpSessionActivation activation = (HttpSessionActivation) session.getAttribute("Listener");
        String name=activation.getName();
        session.setAttribute("Message",name);
        req.getRequestDispatcher("LoadSuccess.jsp").forward(req,resp);

    }
}
