package database;

import com.orientechnologies.orient.core.sql.executor.OResult;
import com.orientechnologies.orient.core.sql.executor.OResultSet;

public class OrientDBBasicQuery extends DBConnenction implements IBasicQuery {
    // 1. Đưa ra tất cả các sự kiện mà UPU tổ chức
    public void query1() {
        createDBConnection();
        createDBSession();

        String query = "SELECT expand(out('HasOrganized')) from Organization where label = ?";
        long start = System.currentTimeMillis();
        OResultSet rs = getDb().query(query, "UPU");
        long end = System.currentTimeMillis();

        while (rs.hasNext()) {
            OResult item = rs.next();
            System.out.println(item.getProperty("label"));
        }
        System.out.println("Thời gian truy vấn: " + (end - start));

        rs.close(); //REMEMBER TO ALWAYS CLOSE THE RESULT SET!!!

        closeDBSession();
        closeDBConnection();
    }

    // 2. Đưa ra thông tin về sự kiện Giao_lưu_sinh_viên
    public void query2() {
        createDBConnection();
        createDBSession();

        String query = "SELECT from Event where label = ?";
        long start = System.currentTimeMillis();
        OResultSet rs = getDb().query(query, "Giao_lưu_sinh_viên");
        long end = System.currentTimeMillis();

        while (rs.hasNext()) {
            OResult item = rs.next();
            System.out.println(item.getProperty("description"));
        }
        System.out.println("Thời gian truy vấn: " + (end - start));

        rs.close(); //REMEMBER TO ALWAYS CLOSE THE RESULT SET!!!

        closeDBSession();
        closeDBConnection();
    }

    // 3. Đưa ra thông tin về thành phố Đà Nẵng
    public void query3() {
        createDBConnection();
        createDBSession();

        String query ="SELECT from Location where label = ?";
        long start = System.currentTimeMillis();
        OResultSet rs = getDb().query(query, "Đà Nẵng");
        long end = System.currentTimeMillis();

        while(rs.hasNext()){
            OResult item = rs.next();
            System.out.println(item.getProperty("description"));
        }
        System.out.println("Thời gian truy vấn: " + (end - start));

        rs.close();
        closeDBSession();
        closeDBConnection();
    }

    // 4. Mỹ đang đàm phán với các quốc gia nào
    public void query4() {
        createDBConnection();
        createDBSession();

        String query = "SELECT  expand(out('HasNegotiated')) from Country where label = ?";
        long start = System.currentTimeMillis();
        OResultSet rs = getDb().query(query, "Mỹ");
        long end = System.currentTimeMillis();

        while (rs.hasNext()) {
            OResult item = rs.next();
            System.out.println(item.getProperty("label"));
        }
        System.out.println("Thời gian truy vấn: " + (end - start));

        rs.close();

        closeDBSession();
        closeDBConnection();
    }

    // 5. Chủ_nhật_đỏ diễn ra tại đâu
    public void query5() {
        createDBConnection();
        createDBSession();

        String query1 = "SELECT distinct expand(out('TakesPlace')) from Event where label = ?";
        long start = System.currentTimeMillis();
        OResultSet rs = getDb().query(query1, "Chủ_nhật_đỏ");
        long end = System.currentTimeMillis();

        while (rs.hasNext()){
            OResult item = rs.next();
            System.out.println(item.getProperty("label"));
        }
        System.out.println("Thời gian truy vấn: " + (end - start));

        rs.close();
        closeDBSession();
        closeDBConnection();
    }

    // 6. Việt Nam ký thỏa thuận với những quốc gia nào
    public void query6() {
        createDBConnection();
        createDBSession();

        String query ="SELECT expand(out('HasAgree')) from Country where label =?";
        long start = System.currentTimeMillis();
        OResultSet rs = getDb().query(query, "Việt Nam");
        long end = System.currentTimeMillis();

        while (rs.hasNext()){
            OResult item = rs.next();
            System.out.println(item.getProperty("label"));
        }
        System.out.println("Thời gian truy vấn: " + (end - start));

        rs.close();
        closeDBSession();
        closeDBConnection();
    }

    // Những người tham gia sự kiện Ra mắt iphone 8
    public void query7() {
        createDBConnection();
        createDBSession();

        String query = "SELECT distinct expand(in('HasParticipated')) from Event where label = ?";
        long start = System.currentTimeMillis();
        OResultSet rs = getDb().query(query, "Ra_mắt_Iphone_8");
        long end = System.currentTimeMillis();

        while (rs.hasNext()) {
            OResult item = rs.next();
            System.out.println(item.getProperty("label"));
        }
        System.out.println("Thời gian truy vấn: " + (end - start));

        rs.close(); //REMEMBER TO ALWAYS CLOSE THE RESULT SET!!!
        closeDBSession();
        closeDBConnection();
    }
    // Những ai đã phát biểu tại sự kiện Ra mắt Bphone 3
    public void query8() {
        createDBConnection();
        createDBSession();

        String query = "SELECT distinct expand(in('HasExpressed')) from Event where label = ?";
        long start = System.currentTimeMillis();
        OResultSet rs = getDb().query(query, "Ra mắt Bphone 3");
        long end = System.currentTimeMillis();

        while (rs.hasNext()) {
            OResult item = rs.next();
            System.out.println(item.getProperty("label"));
        }
        System.out.println("Thời gian truy vấn: " + (end - start));

        rs.close(); //REMEMBER TO ALWAYS CLOSE THE RESULT SET!!!
        closeDBSession();
        closeDBConnection();
    }
    //Nguyễn Phú Trọng đã gặp những ai
    public void query9() {
        createDBConnection();
        createDBSession();

        String query = "SELECT distinct expand(out('HasMet')) from Person where label = ?";
        long start = System.currentTimeMillis();
        OResultSet rs = getDb().query(query, "Nguyễn Phú Trọng");
        long end = System.currentTimeMillis();

        while (rs.hasNext()) {
            OResult item = rs.next();
            System.out.println(item.getProperty("label"));
        }
        System.out.println("Thời gian truy vấn: " + (end - start));

        rs.close(); //REMEMBER TO ALWAYS CLOSE THE RESULT SET!!!
        closeDBSession();
        closeDBConnection();
    }
    // Những ai sẽ tham gia sự kiện Đạp xe vì môi trường
    public void query10() {
        createDBConnection();
        createDBSession();

        String query = "SELECT distinct expand(in('HasParticipated')) from Event where label = ?";
        long start = System.currentTimeMillis();
        OResultSet rs = getDb().query(query, "Đạp xe vì môi trường");
        long end = System.currentTimeMillis();

        while (rs.hasNext()) {
            OResult item = rs.next();
            System.out.println(item.getProperty("label"));
        }
        System.out.println("Thời gian truy vấn: " + (end - start));

        rs.close(); //REMEMBER TO ALWAYS CLOSE THE RESULT SET!!!
        closeDBSession();
        closeDBConnection();
    }
}
