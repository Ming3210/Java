package homework.business;

import homework.entity.Student;
import homework.presentation.UniversityManager;
import homework.util.Validator;

import java.util.Comparator;
import java.util.Scanner;

public class StudentMenu {
    public static void studentMenu(Scanner scanner) {
        do {
            System.out.println("************************STUDENT MENU***************************");
            System.out.println("1. Danh sách sinh viên được sắp xếp theo tên tăng dần ");
            System.out.println("2. Thêm mới sinh viên ");
            System.out.println("3. Cập nhật sinh viên ");
            System.out.println("4. Xóa sinh viên (chỉ xóa nếu sinh viên chưa đăng ký khóa học nào) ");
            System.out.println("5. Thoát ");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    UniversityManager.students.sort(Comparator.comparing(Student::getName));
                    break;
                case 2:
                    Student student = new Student();
                    student.inputData(scanner);
                    UniversityManager.students.add(student);
                    break;
                case 3:
                    String id = Validator.checkString("Nhập Id cần cập nhật", scanner, 5, 50);
                    Student s = UniversityManager.students.stream().filter(s1 -> s1.getStudentId().equals(id)).findFirst().orElse(null);
                    if (s != null) {
                        do {
                            System.out.println("Nhập chức năng cần cập nhật: ");
                            System.out.println("1. Nhập tên sinh viên");
                            System.out.println("2. Nhập điểm trung bình");
                            System.out.println("3. Nhập email");
                            System.out.println("4. Nhập sđt");
                            System.out.println("5. Quay lại");
                            int choice1 = scanner.nextInt();
                            scanner.nextLine();
                            switch (choice1) {
                                case 1:
                                    s.setName(Validator.checkString("Nhập tên sinh viên", scanner, 5, 50));
                                    break;
                                case 2:
                                    s.setGpa(Validator.checkDouble("Nhập tên sinh viên", scanner));
                                    break;
                                case 3:
                                    s.setEmail(Validator.checkString("Nhập email", scanner, 5, 50));
                                    break;
                                case 4:
                                    s.setPhone(Validator.checkString("Nhập sđt", scanner, 5, 50));
                                    break;
                                case 5:
                                    break;
                            }
                        } while (true);
                    } else {
                        System.out.println("Không tìm thấy sinh viên nây");
                    }
                    break;
                case 4:
                    String id1 = Validator.checkString("Nhập Id cần xóa", scanner, 5, 50);
                    Student s1 = UniversityManager.students.stream().filter(s2 -> s2.getStudentId().equals(id1)).findFirst().orElse(null);
                    if (s1 != null) {
                        UniversityManager.students.remove(s1);
                    } else {
                        System.out.println("Không tìm thấy sinh viên nây");
                    }
                    break;
                case 5:
                    return;
            }
        }while (true);
    }
}
