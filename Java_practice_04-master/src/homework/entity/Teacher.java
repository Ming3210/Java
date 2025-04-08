package homework.entity;

import homework.util.Validator;

import java.util.Scanner;

public class Teacher extends Person implements IApp{
    private int autoId;
    private int teacherId;
    private String subject;

    public Teacher(String subject, int teacherId) {
        this.subject = subject;
        this.teacherId = teacherId;
    }

    public Teacher(String address, int age, String email, String name, String phone, String subject, int teacherId) {
        super(address, age, email, name, phone);
        this.subject = subject;
        this.teacherId = teacherId;
    }

    public Teacher() {
    }

    public Teacher(String address, int age, String email, String name, String phone) {
        super(address, age, email, name, phone);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public void inputData(Scanner scanner) {
        teacherId = ++autoId;
        subject = Validator.checkString("Nhập môn học", scanner, 5, 50);
        setName(Validator.checkString("Nhập tên gv", scanner, 5, 50));
        setEmail(Validator.checkEmail("Nhập email", scanner));
        setPhone(Validator.checkPhone("Nhập sđt", scanner));
        setAge(Validator.checkInt("Nhập tuoi", scanner));
        setAddress(Validator.checkString("Nhập điểm", scanner, 5, 50));
    }
}
