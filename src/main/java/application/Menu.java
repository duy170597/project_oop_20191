package application;

import database.IAdvanceQuery;
import database.IBasicQuery;
import database.OrientDBAdvanceQuery;
import database.OrientDBBasicQuery;

import java.util.Scanner;

public class Menu {
    public static void mainMenu(Scanner scanner) {
        System.out.println("HỆ THỐNG TRÍCH RÚT VÀ LƯU TRỮ CÁC THỰC THỂ");
        System.out.println("\t1. Sinh giả lập dữ liệu thực thể và quan hệ");
        System.out.println("\t2. Các câu truy vấn cơ bản");
        System.out.println("\t3. Các câu truy vấn nâng cao");
        System.out.print("Nhập lựa chọn của bạn: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                genarationMenu(scanner);
                break;
            case 2:
                basicQueryMenu(scanner);
                break;
            case 3:
                advanceQueryMenu(scanner);
                break;
        }
    }

    public static void genarationMenu(Scanner scanner) {
        int N, M;
        System.out.println("Sinh giả lập dữ liệu thực thể và quan hệ");
        System.out.print("\tNhập số thực thể: ");
        N = scanner.nextInt();
        System.out.print("\tNhập số quan hệ: ");
        M = scanner.nextInt();

        Utility.createEntities(N);
        Utility.createRelationships(M);
    }

    public static void basicQueryMenu(Scanner scanner) {
        System.out.println("Các câu truy vấn cơ bản");
        System.out.println("\t1. Đưa ra tất cả các sự kiện mà Apple tổ chức");
        System.out.println("\t2. ...");
        System.out.println("\t3. ...");
        System.out.println("\t4. ...");
        System.out.println("\t5. ...");
        System.out.println("\t6. ...");
        System.out.println("\t7. ...");
        System.out.println("\t8. ...");
        System.out.println("\t9. ...");
        System.out.println("\t10. ...");
        System.out.print("Nhập lựa chọn của bạn: ");
        int choice = scanner.nextInt();

        IBasicQuery basicQuery = new OrientDBBasicQuery();
        switch (choice) {
            case 1:
                basicQuery.query1();
                break;
            case 2:
                basicQuery.query2();
                break;
            case 3:
                basicQuery.query3();
                break;
            case 4:
                basicQuery.query4();
                break;
            case 5:
                basicQuery.query5();
                break;
            case 6:
                basicQuery.query6();
                break;
            case 7:
                basicQuery.query7();
                break;
            case 8:
                basicQuery.query8();
                break;
            case 9:
                basicQuery.query9();
                break;
            case 10:
                basicQuery.query10();
                break;
        }
    }

    public static void advanceQueryMenu(Scanner scanner) {
        System.out.println("Các câu truy vấn nâng cao");
        System.out.println("\t1. ...");
        System.out.println("\t2. ...");
        System.out.println("\t3. ...");
        System.out.println("\t4. ...");
        System.out.println("\t5. ...");
        System.out.println("\t6. ...");
        System.out.println("\t7. ...");
        System.out.println("\t8. ...");
        System.out.println("\t9. ...");
        System.out.println("\t10. ...");
        System.out.print("Nhập lựa chọn của bạn: ");
        int choice = scanner.nextInt();

        IAdvanceQuery advanceQuery = new OrientDBAdvanceQuery();
        switch (choice) {
            case 1:
                advanceQuery.query1();
                break;
            case 2:
                advanceQuery.query2();
                break;
            case 3:
                advanceQuery.query3();
                break;
            case 4:
                advanceQuery.query4();
                break;
            case 5:
                advanceQuery.query5();
                break;
            case 6:
                advanceQuery.query6();
                break;
            case 7:
                advanceQuery.query7();
                break;
            case 8:
                advanceQuery.query8();
                break;
            case 9:
                advanceQuery.query9();
                break;
            case 10:
                advanceQuery.query10();
                break;
        }
    }
}
