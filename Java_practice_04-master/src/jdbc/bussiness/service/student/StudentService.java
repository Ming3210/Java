package jdbc.bussiness.service.student;


import jdbc.bussiness.model.Student;
import jdbc.bussiness.service.AppService;

public interface StudentService extends AppService<Student> {
    Student findById(int id);

    int getCountStudentByStatus(boolean status);
}