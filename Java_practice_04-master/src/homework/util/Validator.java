package homework.util;

import homework.presentation.UniversityManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Validator {
    public static int checkInt(String message, Scanner scanner) {
        boolean checkInt = false;
        System.out.println(message);
        while (!checkInt) {
            try {
                int num = scanner.nextInt();
                scanner.nextLine();
                checkInt = true;
                return num;
            } catch (Exception e) {
                System.out.println("Giá trị nhập ko hợp lệ, vui lòng nhập số nguyên");
                scanner.nextLine();
            }
        }
        return 0;
    }

    public static float checkFloat(String message, Scanner scanner) {
        boolean checkFloat = false;
        System.out.println(message);
        while (!checkFloat) {
            try {
                float num = scanner.nextFloat();
                scanner.nextLine();
                checkFloat = true;
                return num;
            } catch (Exception e) {
                System.out.println("Giá trị nhập ko hợp lệ, vui lòng nhập float");
                scanner.nextLine();
            }
        }
        return 0;
    }

    public static double checkDouble(String message, Scanner scanner) {
        boolean checkDouble = false;
        System.out.println(message);
        while (!checkDouble) {
            try {
                double num = scanner.nextDouble();
                scanner.nextLine();
                checkDouble = true;
                return num;
            } catch (Exception e) {
                System.out.println("Giá trị nhập ko hợp lệ, vui lòng nhập số th phân");
                scanner.nextLine();
            }
        }
        return 0;
    }

    public static boolean checkBoolean(String message, Scanner scanner) {
        boolean checkBoolean = false;
        System.out.println(message);
        while (!checkBoolean) {
            try{
                String input = scanner.nextLine();
                if(input.isEmpty()){
                    throw new Exception("Giá trị nhập ko hop lệ, vui lòng nhập true hoặc false");

                }
                if(input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")){
                    return Boolean.parseBoolean(input);
                }
                checkBoolean = true;
            }catch (Exception e){
                System.out.println("Giá trị nhập ko hợp lệ, vui lòng nhập true hoặc false");
            }
        }
        return false;
    }

    public static String checkString(String message, Scanner scanner, int min, int max){
        boolean checkString = false;
        System.out.println(message);
        while (!checkString) {
            try {
                String input = scanner.nextLine();
                if(input.isEmpty() || input.length() < min || input.length() > max){
                    throw new Exception("Giá trị nhập ko hợp lệ, vui lòng nhập chuỗi từ " + min + " đến " + max + " ký tự và không có chuỗi rỗng");
                }
                return input.trim();
            } catch (Exception e) {
                System.out.println("Giá trị nhập ko hợp lệ, vui lòng nhập chuỗi từ " + min + " đến " + max + " ký tự và không có khoảng trắng đầu và cuối");
            }
        }
        return "";
    }

    public static String checkEmail(String message, Scanner scanner){
        boolean checkEmail = false;
        System.out.println(message);
        while (!checkEmail) {
            try {
                String input = scanner.nextLine();
                if (!input.matches("^[A-Za-z0-9+_.-]+@gmail.com+$")) {
                    throw new Exception("Giá trị nhập ko hợp lệ, hãy lập định dạnh email");
                }
                checkEmail = true;
                return input;
            } catch (Exception e) {
                System.out.println("Giá trị nhập ko hợp lệ, hãy lập định dạnh email");
            }
        }
        return "";
    }

    public static String checkPhone(String message, Scanner scanner){
        boolean checkPhone = false;
        System.out.println(message);
        while (!checkPhone) {
            try {
                String input = scanner.nextLine();
                if (!input.matches("(03|09|08)\\d{8}")) {
                    throw new Exception("Giá trị nhập ko hợp lệ, hãy lập định dạnh số điện thoại");
                }
                checkPhone = true;
                return input;
            } catch (Exception e) {
                System.out.println("Giá trị nhập ko hợp lệ, hãy lập định dạnh số điện thoại");
            }
        }
        return "";
    }

    public static String inputCourseId(String message, Scanner scanner){
        System.out.println(message);
        boolean isValidId =false;
        String id =null;

        while (!isValidId){
            try {

                id = scanner.nextLine();
                String finalId = id;
                boolean isCourseExist = UniversityManager.courses.stream().anyMatch(students -> students.getCourseId().equals(finalId));
                if (!isCourseExist){
                    isValidId = true;
                } else {
                    throw new Exception("Id đã tồn tại");
                }

                if (id.matches("^C\\w{4}")){
                    isValidId = true;
                } else {
                    System.err.println("Id bắt đầu bằng chữ “C” và kết hợp với 4 kí tự số phía sau");
                }
            }catch (Exception e){
                System.err.println("Giá trị ko hợp lệ, hãy nhập đúng định dạng ID hoặc id đã bị trùng");
            }
        }
        return id;
    }
    public static String inputStudentId(String message, Scanner scanner){
        System.out.println(message);
        boolean isValidId =false;
        String id =null;

        while (!isValidId){
            try {

                id = scanner.nextLine();
                String finalId = id;

                boolean isStudentExist = UniversityManager.students.stream().anyMatch(students -> students.getStudentId().equals(finalId));
                if (!isStudentExist){
                    isValidId = true;
                } else {
                    throw new Exception("Id đã tồn tại");
                }
                if (id.matches("^ST\\w{3}")){
                    isValidId = true;
                } else {
                    System.err.println("Id bắt đầu bằng chữ “ST” và kết hợp với 3 kí tự số phía sau");
                }
            }catch (Exception e){
                System.err.println("Giá trị ko hợp lệ, hãy nhập đúng định dạng ID hoặc id đã bị trùng");
            }
        }
        return id;
    }

    public static LocalDate checkLocalDate(String message, Scanner scanner, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        while (true) {
            System.out.println(message + " (" + pattern + "): ");
            String input = scanner.nextLine();
            try {
                return LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Ngày không hợp lệ. Vui lòng nhập đúng định dạng " + pattern);
            }
        }
    }

}
