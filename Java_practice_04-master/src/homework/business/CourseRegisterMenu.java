package homework.business;

import homework.entity.CourseRegistration;
import homework.presentation.UniversityManager;
import homework.util.Validator;

import java.util.Scanner;

public class CourseRegisterMenu {
    public static void courseRegisterMenu(Scanner scanner) {
        do {
            System.out.println("*******************COURSE REGISTRATION MENU***************** ");
            System.out.println("1. Đăng ký khóa học cho sinh viên");
            System.out.println("2. Hủy đăng ký học cho sinh viên (Chỉ được hủy nếu trạng thái là PENDING)");
            System.out.println("3. Duyệt đăng ký học sinh viên (PENDING → ENROLLED) ");
            System.out.println("4. Xem danh sách sinh viên đăng ký từng khóa học");
            System.out.println("5. Thoát ");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    CourseRegistration courseRegistration = new CourseRegistration();
                    courseRegistration.inputData(scanner);
                    UniversityManager.courseRegistrations.add(courseRegistration);
                    break;
                case 2:
                    int id = Validator.checkInt("Nhập Id cần hủy", scanner);
                    CourseRegistration cr = UniversityManager.courseRegistrations.stream().filter(cr1 -> cr1.getCrid() == id).findFirst().orElse(null);
                    if (cr != null) {
                        if (cr.getStatus() == CourseRegistration.CourseStatus.PENDING) {
                            UniversityManager.courseRegistrations.remove(cr);
                        } else {
                            System.out.println("Khóa học nay khong duoc huy");
                        }
                    }
                    break;
                case 3:
                    id = Validator.checkInt("Nhập Id cần duyet", scanner);
                    cr = UniversityManager.courseRegistrations.stream().filter(cr1 -> cr1.getCrid() == id).findFirst().orElse(null);
                    if (cr != null) {
                        if (cr.getStatus() == CourseRegistration.CourseStatus.PENDING) {
                            cr.setStatus(CourseRegistration.CourseStatus.ENROLLED);
                        } else {
                            System.out.println("Khóa học nay khong duoc duyet");
                        }
                    }
                    break;
                case 4:
                    id = Validator.checkInt("Nhập Id cần xem", scanner);
                    cr = UniversityManager.courseRegistrations.stream().filter(cr1 -> cr1.getCrid() == id).findFirst().orElse(null);
                    if (cr != null) {
                        System.out.println(cr);
                    }
                    else {
                        System.out.println("Khóa học nay khong ton tai");
                    }
                    break;
                case 5:
                    return;
            }
        }while (true);
    }
}
