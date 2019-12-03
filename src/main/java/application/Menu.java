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

        long start = System.currentTimeMillis();
        DataGeneration.createEntities(N);
        DataGeneration.createRelationships(M);
        long end = System.currentTimeMillis();
        System.out.println("Thời gian sinh thực thể và quan hệ: " + (end - start));
    }

    public static void basicQueryMenu(Scanner scanner) {
        System.out.println("Các câu truy vấn cơ bản");
        System.out.println("\t1. Đưa ra tất cả các sự kiện mà UPU tổ chức");
        System.out.println("\t2. Đưa ra thông tin về sự kiện Giao_lưu_sinh_viên");
        System.out.println("\t3. Đưa ra thông tin về thành phố Đà Nẵng");
        System.out.println("\t4. Mỹ đang đàm phán với các quốc gia nào");
        System.out.println("\t5. Chủ_nhật_đỏ diễn ra tại đâu");
        System.out.println("\t6. Việt Nam ký thỏa thuận với những quốc gia nào");
        System.out.println("\t7. Những người tham gia sự kiện Ra mắt iphone 8");
        System.out.println("\t8. Những ai đã phát biểu tại sự kiện Ra mắt Bphone 3");
        System.out.println("\t9. Nguyễn Phú Trọng đã gặp những ai");
        System.out.println("\t10. Những ai sẽ tham gia sự kiện Đạp xe vì môi trường");
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
        System.out.println("\t1. Tìm 3 tổ chức tổ chức nhiều sự kiện nhất");
        System.out.println("\t2. Tìm tất cả các đất nước bị căng thẳng bởi các đất nước mà việt nam đàm phán");
        System.out.println("\t3. Tìm 3 Agreement được ủng hộ nhiều nhất");
        System.out.println("\t4. Những người Nguyễn Phú Trọng gặp gỡ phát biểu tại sự kiện GRAMMY_2018");
        System.out.println("\t5. Tìm tất cả sự kiện mà được các của nước Mỹ ký thỏa thuận ủng hộ");
        System.out.println("\t6. Tìm 5 người gặp gỡ nhiều người khác nhất");
        System.out.println("\t7. Những người ủng hộ Việt Nam tổ chức sự kiện Talk_show_công_nghệ diễn ra tại Hà Nội");
        System.out.println("\t8. Những người phản đối Việt Nam ký thỏa thuận với Trung Quốc");
        System.out.println("\t9. 3 tổ chức có người + tổ chức tham gia nhiều nhất");
        System.out.println("\t10. Địa điểm nào diễn ra nhiều sự kiện nhất");
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
