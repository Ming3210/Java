package jdbc.bussiness.service.student;



import jdbc.bussiness.dao.student.StudentDAO;
import jdbc.bussiness.dao.student.StudentDAOImp;
import jdbc.bussiness.model.Student;

import java.util.List;

public class StudentServiceImp implements StudentService {
    private final StudentDAO studentDAO;

    public StudentServiceImp() {
        studentDAO = new StudentDAOImp();
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public boolean save(Student student) {
        return studentDAO.save(student);
    }

    @Override
    public boolean update(Student student) {
        return studentDAO.update(student);
    }

    @Override
    public boolean delete(Student student) {
        return studentDAO.delete(student);
    }

    @Override
    public Student findById(int id) {
        return studentDAO.findById(id);
    }

    @Override
    public int getCountStudentByStatus(boolean status) {
        return studentDAO.getCountStudentByStatus(status);
    }
}