package orientdb;

import com.orientechnologies.orient.core.sql.executor.OResult;
import com.orientechnologies.orient.core.sql.executor.OResultSet;
import database.IBasicQuery;

public class OrientDBBasicQuery extends DBConnenction implements IBasicQuery {
    // 1. Đưa ra tất cả các sự kiện mà Apple tổ chức
    public void query1() {
        createDBConnection();
        createDBSession();

        String query = "SELECT expand(out('HasOrganized')) from Organization where label = ?";
        OResultSet rs = getDb().query(query, "Apple");

        while (rs.hasNext()) {
            OResult item = rs.next();
            System.out.println(item.getProperty("label"));
        }

        rs.close(); //REMEMBER TO ALWAYS CLOSE THE RESULT SET!!!

        closeDBSession();
        closeDBConnection();
    }

    // 2. Đưa ra thông tin về sự kiện ra mắt iphone 8
    public void query2() {

    }

    // 3. Đưa ra thông tin về thành phố Đà Nẵng
    public void query3() {

    }

    // 4. Nguyễn Xuân Phúc ủng hộ những thỏa thuận nào
    public void query4() {

    }

    // 5. Chung_kết_Lễ_hội_pháo_hoa_quốc_tế_2018 diễn ra tại đâu
    public void query5() {

    }

    // Việt Nam ký thỏa thuận với những quốc gia nào
    public void query6() {

    }

    // Những người tham gia sự kiện Ra mắt iphone 8
    public void query7() {

    }

    public void query8() {

    }

    public void query9() {

    }

    public void query10() {

    }

//    public static void main(String[] args) {
//        OrientDBBasicQuery query = new OrientDBBasicQuery();
//        query.query1();
//    }
}
