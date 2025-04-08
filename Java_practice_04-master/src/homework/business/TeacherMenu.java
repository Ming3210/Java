package homework.business;

import homework.entity.Teacher;
import homework.presentation.UniversityManager;
import homework.util.Validator;

import java.util.Comparator;
import java.util.Scanner;

public class TeacherMenu {
    public static void teacherMenu(Scanner scanner) {
        do {
            System.out.println("*************************TEACHER MENU**************************");
            System.out.println("1. Danh sách giảng viên sắp xếp theo mã giảm dần");
            System.out.println("2. Thêm mới giảng viên ");
            System.out.println("3. Cập nhật giảng viên ");
            System.out.println("4. Xóa giảng viên (chỉ xóa được nếu giảng viên chưa được xếp lớp)");
            System.out.println("5. Thoát ");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    UniversityManager.teachers.sort(Comparator.comparing(Teacher::getTeacherId).reversed());
                    break;
                case 2:
                    Teacher teacher = new Teacher();
                    teacher.inputData(scanner);
                    UniversityManager.teachers.add(teacher);
                    break;
                case 3:
                    int id = Validator.checkInt("Nhập Id cần cập nhật",scanner);
                    Teacher t = UniversityManager.teachers.stream().filter(t1 -> t1.getTeacherId() == id).findFirst().orElse(null);
                    if (t != null) {
                        do {
                            System.out.println("Nhập chức năng cần cập nhật: ");
                            System.out.println("1. Nhập môn học");
                            System.out.println("2. Nhập tên gv");
                            System.out.println("3. Nhập email");
                            System.out.println("4. Nhập sđt");
                            System.out.println("5. Nhập tuoi");
                            System.out.println("6. Nhập điểm");
                            System.out.println("7. Quay lại");
                            int choice1 = scanner.nextInt();
                            scanner.nextLine();
                            switch (choice1) {
                                case 1:
                                    t.setSubject(Validator.checkString("Nhập môn học", scanner, 5, 50));
                                    break;
                                case 2:
                                    t.setName(Validator.checkString("Nhập tên gv", scanner, 5, 50));
                                    break;
                                case 3:
                                    t.setEmail(Validator.checkEmail("Nhập email", scanner));
                                    break;
                                case 4:
                                    t.setPhone(Validator.checkPhone("Nhập sđt", scanner));
                                    break;
                                case 5:
                                    t.setAge(Validator.checkInt("Nhập tuoi", scanner));
                                    break;
                                case 6:
                                    t.setAddress(Validator.checkString("Nhập điểm", scanner, 5, 50));
                                    break;
                                case 7:
                                    return;
                                default:
                                    System.err.println("Chọn không hợp lệ");
                            }
                        } while (true);
                    } else {
                        System.err.println("Không tìm thấy giảng viên cần cập nhật");
                    }
                    break;
                case 4:
                    id = Validator.checkInt("Nhập Id cần xóa",scanner);
                    t = UniversityManager.teachers.stream().filter(t1 -> t1.getTeacherId() == id).findFirst().orElse(null);
                    if (t != null) {
                        UniversityManager.teachers.remove(t);
                        System.out.println("Xóa giảng viên thanh công");
                    } else {
                        System.err.println("Không tìm thấy giảng viên cần xóa");
                    }
                    break;
                case 5:
                    return;
                default:
                    System.err.println("Chọn không hợp lệ");
            }
        }while (true);
    }
}
