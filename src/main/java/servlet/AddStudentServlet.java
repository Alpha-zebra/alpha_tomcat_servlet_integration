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

public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String bornday = request.getParameter("bornday");
        Student student = null;
        try {
            student = new Student(name, gender, DateUtils.strConvertDate(bornday, "yyyy-MM-dd'T'HH:mm"));
            StudentDao dao = new StudentDaoImpl();
            dao.save(student);
        } catch (Exception e) {
            e.printStackTrace();
        }


        response.sendRedirect("showStudent.jsp?id=" + student.getId());
    }
}
