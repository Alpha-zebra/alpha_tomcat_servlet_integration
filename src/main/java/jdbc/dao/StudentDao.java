package jdbc.dao;

import jdbc.pojo.Student;

import java.util.List;

public interface StudentDao {

    void save(Student student) throws Exception;

    Student get(int id) throws Exception;

    List<Student> list() throws Exception;

    void delete(int id)throws Exception;

    void update(Student student)throws Exception;
}
