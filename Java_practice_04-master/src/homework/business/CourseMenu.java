package homework.business;

import homework.entity.Course;
import homework.presentation.UniversityManager;
import homework.util.Validator;

import java.util.Comparator;
import java.util.Scanner;

public class CourseMenu {
    public static void courseMenu(Scanner scanner){

       do {
           System.out.println("************************* COURSE MENU ************************* ");
           System.out.println("1. Danh sách khóa học sắp xếp theo tên tăng dần");
           System.out.println("2. Thêm mới khóa học ");
           System.out.println("3. Cập nhật khóa học ");
           System.out.println("4. Xóa khóa học theo ID (Chỉ xóa được khóa học nếu khóa học chưa có lớp học) ");
           System.out.println("5. Thoát ");
           System.out.print("Chọn chức năng: ");
           int choice = scanner.nextInt();
           switch (choice) {
               case 1:
                   UniversityManager.courses.sort(Comparator.comparing(Course::getCourseName));
                   break;
               case 2:
                   Course course = new Course();
                   course.inputData(scanner);
                   UniversityManager.courses.add(course);
                   break;
               case 3:
                   String id = Validator.inputCourseId("Nhập Id cần cập nhật",scanner);
                   Course c = UniversityManager.courses.stream().filter(c1 -> c1.getCourseId().equals(id)).findFirst().orElse(null);
                   if (c != null) {
                       do {
                           System.out.println("Nhập chức năng cần cập nhật: ");
                           System.out.println("1. Nhập tên khóa học");
                           System.out.println("2. Nhập trạng thái (true/false)");
                           System.out.println("3. Quay lại");
                           int choice1 = scanner.nextInt();
                           switch (choice1) {
                               case 1:
                                   c.setCourseName(Validator.checkString("Nhập tên khóa học", scanner, 5, 50));
                                   break;
                               case 2:
                                   c.setStatus(Validator.checkBoolean("Nhập trạng thái (true/false)", scanner));
                                   break;
                               case 3:
                                   break;
                               default:
                                   System.out.println("Vui lòng nhập lại chức năng (1-3)");
                           }
                       } while (true);
                   }
                   break;
               case 4:
                   id = Validator.inputCourseId("Nhập Id cần xóa",scanner);
                   c = UniversityManager.courses.stream().filter(c1 -> c1.getCourseId().equals(id)).findFirst().orElse(null);
                   if (c != null) {
                       UniversityManager.courses.remove(c);
                   }
                   else {
                       System.out.println("Khóa học không tìm thấy");
                   }
                   break;
               case 5:
                   System.out.println("Bạn đã thoát");
                   return;
               default:
                   System.out.println("Vui lòng nhập lại chức năng (1-5)");
           }
       }while (true);
    }
}
