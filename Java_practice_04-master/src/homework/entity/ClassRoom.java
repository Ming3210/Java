package homework.entity;

import homework.util.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ClassRoom implements IApp {
    private static int autoIdClass;
    private int classroomId;
    private String classRoomName;
    private String courseId;
    private String teacherId;
    private List<Student> listStudents;
    private LocalDate created;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private ClassStatus status;

    public enum ClassStatus {
        PENDING, PROGRESS, CLOSE
    }

    public ClassRoom(int classroomId, String classRoomName, String courseId, LocalDate created,
                     List<Student> listStudents, ClassStatus status, String teacherId) {
        this.classroomId = classroomId;
        this.classRoomName = classRoomName;
        this.courseId = courseId;
        this.created = created;
        this.listStudents = listStudents;
        this.status = status;
        this.teacherId = teacherId;
    }

    public ClassRoom() {
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    // Other getters and setters remain the same
    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public String getClassRoomName() {
        return classRoomName;
    }

    public void setClassRoomName(String classRoomName) {
        this.classRoomName = classRoomName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public List<Student> getListStudents() {
        return listStudents;
    }

    public void setListStudents(List<Student> listStudents) {
        this.listStudents = listStudents;
    }

    public ClassStatus getStatus() {
        return status;
    }

    public void setStatus(ClassStatus status) {
        this.status = status;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public void inputData(Scanner scanner) {
        classroomId = ++autoIdClass;
        classRoomName = Validator.checkString("Nhập tên phòng", scanner, 5, 50);
        courseId = Validator.inputCourseId("Nhập mã khóa học", scanner);
        teacherId = Validator.checkString("Nhập mã giáo viên", scanner, 5, 50);
        created = Validator.checkLocalDate("Nhập ngày tạo", scanner, "dd/MM/yyyy");
        status = ClassStatus.PENDING;
    }
}