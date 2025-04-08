package jdbc.bussiness.dao.student;


import jdbc.bussiness.dao.AppDAO;
import jdbc.bussiness.model.Student;

public interface StudentDAO extends AppDAO<Student> {
    int getCountStudentByStatus(boolean status);

    Student findById(int id);
}