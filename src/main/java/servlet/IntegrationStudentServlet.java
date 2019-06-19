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
import java.util.List;

public class IntegrationStudentServlet extends HttpServlet {
    private StudentDao dao=new StudentDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uri=req.getRequestURI();
        System.out.println(uri);
        String option = uri.substring(uri.lastIndexOf("/")+1);
        System.out.println(option);
        switch (option) {
            case "add":
                add(req, resp);
                break;
            case "update":
                update(req, resp);
                break;
            case "list":
                list(req, resp);
                break;
            case "delete":
                delete(req, resp);
            case "show":
                show(req, resp);
                break;
                default:
                    System.out.println("default---------------->");

        }
    }

    private void show(HttpServletRequest request, HttpServletResponse response) {
        int id=Integer.parseInt(request.getParameter("id"));
        try {
            Student student = dao.get(id);
            request.setAttribute("student",student);
            request.getRequestDispatcher("show.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id=Integer.parseInt(request.getParameter("id"));

        try {
            dao.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("list");
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> students=null;
        try {
             students=dao.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("students",students);
        req.getRequestDispatcher("list.jsp").forward(req,resp);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String idStr = request.getParameter("id");
        if (idStr != null && idStr.matches("\\d")) {
            try {
                Student  student = new Student(
                        Integer.parseInt(request.getParameter("id")),
                        request.getParameter("name"),
                        request.getParameter("gender"),
                        DateUtils.strConvertDate(request.getParameter("bornday"), "yyyy-MM-dd'T'HH:mm")
                );
                dao.update(student);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                Student student = new Student(
                        request.getParameter("name"),
                        request.getParameter("gender"),
                        DateUtils.strConvertDate(request.getParameter("bornday"), "yyyy-MM-dd'T'HH:mm")
                );
                dao.save(student);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        response.sendRedirect("list");
    }

    public void add(HttpServletRequest request,HttpServletResponse response) {

        String idStr = request.getParameter("id");
        if (idStr != null && idStr.matches("\\d")) {
            request.setAttribute("title", "修改");
            int id = Integer.parseInt(idStr);
            try {
                request.setAttribute("student",dao.get(id));
            } catch (Exception e) {
                e.printStackTrace();
            }


        }else {
            request.setAttribute("title","新增");
        }

        try {
            request.getRequestDispatcher("edit.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
