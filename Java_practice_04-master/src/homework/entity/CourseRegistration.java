package homework.entity;

import homework.util.Validator;

import java.time.LocalDate;
import java.util.Scanner;

public class CourseRegistration implements IApp{

    private int autoCrId;
    private int crid;
    private String studentId;
    private String courseId;
    private LocalDate registrationDate = LocalDate.now();
    private CourseStatus status = CourseStatus.PENDING;

    public enum CourseStatus {
        PENDING, ENROLLED, DROPPED
    }
    public CourseRegistration(String courseId, int crid, LocalDate registrationDate, String studentId) {
        this.courseId = courseId;
        this.crid = crid;
        this.registrationDate = registrationDate;
        this.studentId = studentId;
    }

    public CourseRegistration() {
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getCrid() {
        return crid;
    }

    public void setCrid(int crid) {
        this.crid = crid;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public void setStatus(CourseStatus status) {
        this.status = status;
    }

    public int getAutoCrId() {
        return autoCrId;
    }

    public void setAutoCrId(int autoCrId) {
        this.autoCrId = autoCrId;
    }

    @Override
    public void inputData(Scanner scanner) {
        crid = ++autoCrId;
        studentId = Validator.inputStudentId("Nhập mã sinh viên", scanner);
        courseId = Validator.inputCourseId("Nhập má khóa học", scanner);
        registrationDate = Validator.checkLocalDate("Nhập ngày dăng ký", scanner, "dd/MM/yyyy");
        status = CourseStatus.PENDING;
    }

}
