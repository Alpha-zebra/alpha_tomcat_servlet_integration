package servlet;

import jdbc.dao.StudentDao;
import jdbc.dao.StudentDaoImpl;
import jdbc.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sql="select * from student";
        StudentDao dao=new StudentDaoImpl();
        List<Student> students= null;
        try {
            students = dao.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("students",students);
        request.getRequestDispatcher("listStudent.jsp").forward(request,response);

    }
}
