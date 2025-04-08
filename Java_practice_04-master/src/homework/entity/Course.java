package homework.entity;

import homework.util.Validator;

import java.util.Scanner;

public class Course implements IApp{
    private String courseId;
    private String courseName;
    private boolean status;

    public Course(String courseId, String courseName, boolean status) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.status = status;
    }

    public Course() {
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        courseId = Validator.inputCourseId("Nhập mã khóa học",scanner);
        courseName = Validator.checkString("Nhập tên khóa học", scanner, 5, 50);
        status = Validator.checkBoolean("Nhập trạng thái (true/false)", scanner);
    }

}
