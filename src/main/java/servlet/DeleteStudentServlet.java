package servlet;

import jdbc.dao.StudentDao;
import jdbc.dao.StudentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        StudentDao dao=new StudentDaoImpl();
        try {
            dao.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("listStudent.do");
    }
}
