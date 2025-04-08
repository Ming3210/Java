package jdbc;

import jdbc.presentation.StudentUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("***************STUDENT MENU**************");
            System.out.println("1. Quản lý sinh viên");
            System.out.println("2. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    StudentUI.displayStudentMenu(scanner);
                    break;
                case 2:
                    System.exit(0);
            }
        } while (true);
    }
}