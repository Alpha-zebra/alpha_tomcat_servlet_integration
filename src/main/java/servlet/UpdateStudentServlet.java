package servlet;

import jdbc.commons.DateUtils;
import jdbc.dao.StudentDao;
import jdbc.dao.StudentDaoImpl;
import jdbc.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        Student student= null;
        try {
            student = new Student(
                    Integer.parseInt(request.getParameter("id")) ,
                    request.getParameter("name"),
                    request.getParameter("gender"),
                    DateUtils.strConvertDate(request.getParameter("bornday"),"yyyy-MM-dd'T'HH:mm")
            );
            StudentDao dao=new StudentDaoImpl();
            dao.update(student);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("listStudent.do");
    }
}
