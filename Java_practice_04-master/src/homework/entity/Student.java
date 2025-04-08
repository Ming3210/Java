package homework.entity;

import java.util.Scanner;

public class Student extends Person implements IApp{

    private String studentId;
    private double gpa;

    @Override
    public void inputData(Scanner scanner) {

    }

    public Student(String studentId, double gpa) {
        this.studentId = studentId;
        this.gpa = gpa;
    }

    public Student(String address, int age, String email, String name, String phone, String studentId, double gpa) {
        super(address, age, email, name, phone);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    public Student() {
    }

    public Student(String address, int age, String email, String name, String phone) {
        super(address, age, email, name, phone);
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}
