package jdbc.dao;

import jdbc.commons.DBHelper;
import jdbc.commons.DateUtils;
import jdbc.pojo.Student;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public void save(Student student) throws Exception {
        String sql = "insert into student(name,gender,bornday) values(?,?,?)";
        List params = new ArrayList();
        params.add(student.getName());
        params.add(student.getGender());
        params.add(student.getBornday());

        try {
            DBHelper.openConnection();
            DBHelper.execute(sql, params);
            sql = "select last_insert_id() as id";
            DBHelper.executeQuery(sql, null, rs1 -> {
                if (rs1.next()) {
                    student.setId(rs1.getInt("id"));
                }
            });
            DBHelper.close();
        } catch (Exception e) {
            throw new Exception("data operate exception", e);
        }

    }

    @Override
    public Student get(int id) throws Exception {
        String sql = "select * from student where id=?";
        Student student = new Student();
        List params = new ArrayList();
        params.add(id);
        try {
            DBHelper.openConnection();
            DBHelper.executeQuery(sql, params, rs -> {

                if (rs.next()) {
                    student.setId(id);
                    student.setName(rs.getString("name"));
                    student.setGender(rs.getString("gender"));
                    student.setBornday(rs.getTimestamp("bornday"));
                }

            });

            DBHelper.close();

        } catch (Exception e) {
            throw new Exception("data operate exception", e);
        }
        return student;
    }

    @Override
    public List<Student> list() throws Exception {
        String sql="select * from student";
        List<Student> students=new ArrayList<>();
        DBHelper.openConnection();
        DBHelper.executeQuery(sql,null,rs -> {
            while (rs.next()){
                students.add(new Student(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getTimestamp(4)
                ));
            }
        });
        return students;
    }

    @Override
    public void delete(int id) throws Exception {
        String sql="delete from student where id=?";
        List params=new ArrayList();
        params.add(id);
        DBHelper.openConnection();
        DBHelper.execute(sql,params);
        DBHelper.close();
    }

    @Override
    public void update(Student student) throws Exception {
        String sql="update student set name=?,gender=?,bornday=? where id=?";
        List params=new ArrayList();
        params.add(student.getName());
        params.add(student.getGender());
        params.add(student.getBornday());
        params.add(student.getId());
        DBHelper.openConnection();
        DBHelper.execute(sql,params);
        DBHelper.close();

    }
}