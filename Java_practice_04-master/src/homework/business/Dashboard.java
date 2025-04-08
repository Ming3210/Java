package homework.business;

import homework.presentation.UniversityManager;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Dashboard {
    public static void dashboardMenu(Scanner scanner) {
        do {
            System.out.println("**************************DASHBOARD*********************** ");
            System.out.println("1. Thống kê số sinh viên, giảng viên, khóa học, lớp học");
            System.out.println("2. Top 3 khóa học có nhiều sinh viên nhất ");
            System.out.println("3. Top 3 lớp học có nhiều sinh viên nhất  ");
            System.out.println("4. Top 3 giảng viên dạy nhiều sinh viên nhất  ");
            System.out.println("5. Top 3 sinh viên đăng ký học nhiều nhất ");
            System.out.println("6. Thoát ");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    int resultSts = UniversityManager.students.size();
                    int resultTch = UniversityManager.teachers.size();
                    int resultCrs = UniversityManager.courses.size();
                    int resultCls = UniversityManager.classRooms.size();
                    System.out.println("Số sinh viên: " + resultSts);
                    System.out.println("Số giảng viên: " + resultTch);
                    System.out.println("Số khóa học: " + resultCrs);
                    System.out.println("Số lớp học: " + resultCls);
                    break;
                case 2:
                    UniversityManager.classRooms.stream()
                            .sorted((c1, c2) -> Integer.compare(
                                    c2.getListStudents() != null ? c2.getListStudents().size() : 0,
                                    c1.getListStudents() != null ? c1.getListStudents().size() : 0
                            ))
                            .limit(3)
                            .forEach(c -> System.out.println("Lớp: " + c.getClassRoomName()
                                    + " - Số sinh viên: " + (c.getListStudents() != null ? c.getListStudents().size() : 0)));
                    break;
                case 3:
                    UniversityManager.classRooms.stream()
                            .sorted((c1, c2) -> Integer.compare(
                                    c2.getListStudents() != null ? c2.getListStudents().size() : 0,
                                    c1.getListStudents() != null ? c1.getListStudents().size() : 0
                            ))
                            .limit(3)
                            .forEach(c -> System.out.println("Lớp: " + c.getClassRoomName()));

                    break;
                case 4:
                    UniversityManager.classRooms.stream().sorted((c1, c2) -> Integer.compare(
                        c2.getListStudents() != null ? c2.getListStudents().size() : 0,
                        c1.getListStudents() != null ? c1.getListStudents().size() : 0
                )) .limit(3)
                            .forEach(c -> System.out.println("Id Giảng viên: " + c.getTeacherId()));

                    break;
                case 5:
                    UniversityManager.courseRegistrations.stream()
                            .collect(Collectors.groupingBy(cr -> cr.getStudentId(), Collectors.counting()))
                            .entrySet().stream()
                            .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                            .limit(3)
                            .forEach(entry -> {
                                String studentId = entry.getKey();
                                long count = entry.getValue();

                                UniversityManager.students.stream()
                                        .filter(s -> s.getStudentId().equals(studentId))
                                        .findFirst()
                                        .ifPresent(student -> System.out.println(
                                                "Tên sinh viên: " + student.getName() +
                                                        " | Mã SV: " + studentId +
                                                        " | Số lượt đăng ký: " + count));
                            });
                    break;

                case 6:
                    return;
                default:
                    System.out.println("Chọn chức năng khóa học không hợp lệ!");
            }
        }while (true);
    }
}
