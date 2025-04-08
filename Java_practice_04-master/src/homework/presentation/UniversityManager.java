package homework.presentation;

import homework.business.*;
import homework.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UniversityManager {
    static public List<Course> courses = new ArrayList<>();

    static public List<Teacher> teachers = new ArrayList<>();

    static public List<Student> students = new ArrayList<>();

    static public List<CourseRegistration> courseRegistrations = new ArrayList<>();

    static public List<ClassRoom> classRooms = new ArrayList<>();

    public static void main(String[] args) {
        do{
            Scanner scanner = new Scanner(System.in);
            System.out.println("************************ UNIVERSITY MENU ********************** ");
            System.out.println("1. Quản lý khóa học ");
            System.out.println("2. Quản lý giảng viên");
            System.out.println("3. Quản lý sinh viên ");
            System.out.println("4. Đăng ký khóa học");
            System.out.println("5. Quản lý lớp học");
            System.out.println("6. Thống kê ");
            System.out.println("7. Thoát ");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    CourseMenu.courseMenu(scanner);
                    break;
                case 2:
                    TeacherMenu.teacherMenu(scanner);
                    break;
                case 3:
                    StudentMenu.studentMenu(scanner);
                    break;
                case 4:
                    CourseRegisterMenu.courseRegisterMenu(scanner);
                    break;
                case 5:
                    ClassMenu.classMenu(scanner);
                    break;
                case 6:
                    Dashboard.dashboardMenu(scanner);
                    break;
                case 7:
                    System.out.println("Bạn đã thoát!");
                    System.exit(0);
                    return;
                default:
            }
        }while (true);
    }
}
