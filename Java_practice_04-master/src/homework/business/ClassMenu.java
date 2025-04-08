package homework.business;

import homework.entity.ClassRoom;
import homework.entity.Student;
import homework.presentation.UniversityManager;
import homework.util.Validator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class ClassMenu {
    public static void classMenu(Scanner scanner) {
        do {
            System.out.println("********************** CLASS ROOM MENU **********************");
            System.out.println("1. Danh sách lớp học sắp xếp theo ngày tạo giảm dần");
            System.out.println("2. Thêm mới lớp học ");
            System.out.println("3. Cập nhật thông tin lớp học (Chỉ cập nhật được thông tin nếu trạng thái khác CLOSE)");
            System.out.println("4. Xóa lớp học (Chỉ xóa được nếu lớp học chưa có sinh viên và giảng viên)");
            System.out.println("5. Phân công giảng viên cho lớp  ");
            System.out.println("6. Thêm sinh viên vào cho lớp ");
            System.out.println("7. Tạo lịch học cho lớp  ");
            System.out.println("8. Cập nhật trạng thái lớp (PENDING → PROGESS → CLOSE) ");
            System.out.println("9. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    UniversityManager.classRooms.sort(Comparator.comparing(ClassRoom::getCreated).reversed());
                    break;
                case 2:
                    ClassRoom classRoom = new ClassRoom();
                    classRoom.inputData(scanner);
                    UniversityManager.classRooms.add(classRoom);
                    break;
                case 3:
                    int id = Validator.checkInt("Nhập Id cần cập nhật", scanner);
                    ClassRoom c = UniversityManager.classRooms.stream().filter(c1 -> c1.getClassroomId() == id).findFirst().orElse(null);

                    if (c != null) {
                        if (c.getStatus() != ClassRoom.ClassStatus.CLOSE) {
                            do {
                                System.out.println("Nhập chức năng cần cập nhật: ");
                                System.out.println("1. Thay tên lớp học");
                                System.out.println("2. Thoát");
                                int choice1 = scanner.nextInt();
                                scanner.nextLine();
                                switch (choice1) {
                                    case 1:
                                        String name = Validator.checkString("Nhập tên lớp học", scanner, 5, 50);
                                        c.setClassRoomName(name);
                                        break;
                                    case 2:
                                        return;
                                    default:
                                        break;
                                }
                            } while (true);
                        }

                    }
                    break;
                case 4:
                    int idDel = Validator.checkInt("Nhập Id cần xóa",scanner);
                    ClassRoom cDel = UniversityManager.classRooms.stream().filter(c1 -> c1.getClassroomId() == idDel).findFirst().orElse(null);
                    if (cDel != null) {
                        if (!cDel.getListStudents().isEmpty() && !cDel.getTeacherId().isEmpty()) {
                            UniversityManager.classRooms.remove(cDel);
                        }
                    }
                    break;
                case 5:
                    String teacherId = Validator.checkString("Nhập Id giảng viên", scanner, 0, 50);
                    String classRoomId = Validator.checkString("Nhập Id lớp học", scanner, 0, 50);

                    boolean isUpdated = UniversityManager.classRooms.stream()
                            .filter(cl -> cl.getClassroomId() == Integer.parseInt(classRoomId))
                            .findFirst()
                            .map(classroom -> {
                                classroom.setTeacherId(teacherId);
                                return true;
                            })
                            .orElse(false);

                    if (isUpdated) {
                        System.out.println("Cập nhật giảng viên thành công!");
                    } else {
                        System.out.println("Không tìm thấy lớp học với ID " + classRoomId);
                    }
                    break;
                case 6:
                    String classRoomId1 = Validator.checkString("Nhập Id lớp học", scanner, 0, 50);
                    String studentId = Validator.checkString("Nhập Id sinh viên", scanner, 0, 50);

                    boolean isAdded = UniversityManager.classRooms.stream()
                            .filter(cl -> cl.getClassroomId() == Integer.parseInt(classRoomId1))
                            .findFirst()
                            .map(classroom -> {
                                Student student = new Student();
                                student.setStudentId(studentId);
                                if (classroom.getListStudents() == null) {
                                    classroom.setListStudents(new ArrayList<>());
                                }
                                classroom.getListStudents().add(student);
                                return true;
                            })
                            .orElse(false);

                    if (isAdded) {
                        System.out.println("Thêm sinh viên vào lớp thành công!");
                    } else {
                        System.out.println("Không tìm thấy lớp học với ID " + classRoomId1);
                    }
                case 7:
                    LocalDate date = Validator.checkLocalDate("Nhập ngày học", scanner, "dd/MM/yyyy");
                    String classRoomId2 = Validator.checkString("Nhập Id lớp học", scanner, 0, 50);

                    boolean isCreated = UniversityManager.classRooms.stream()
                            .filter(cl -> cl.getClassroomId() == Integer.parseInt(classRoomId2))
                            .findFirst()
                            .map(classroom -> {
                                classroom.setCreated(date);
                                return true;
                            })
                            .orElse(false);

                    if (isCreated) {
                        System.out.println("Tạo lớp học thanh cong!");
                    } else {
                        System.out.println("Không tìm thấy lớp học với ID " + classRoomId2);
                    }
                    break;
                case 8:
                    LocalDate date1 = Validator.checkLocalDate("Nhập ngày học", scanner, "dd/MM/yyyy");
                    String classRoomId3 = Validator.checkString("Nhập Id lớp học", scanner, 0, 50);

                    boolean isUpdated1 = UniversityManager.classRooms.stream()
                            .filter(cl -> cl.getClassroomId() == Integer.parseInt(classRoomId3))
                            .findFirst()
                            .map(classroom -> {
                                classroom.setCreated(date1);
                                return true;
                            })
                            .orElse(false);

                    if (isUpdated1) {
                        System.out.println("Cập nhật ngày học thanh cong!");
                    } else {
                        System.out.println("Không tìm thấy lớp học với ID " + classRoomId3);
                    }
                    break;
                case 9:
                    return;
            }
        }while (true);
    }
}
