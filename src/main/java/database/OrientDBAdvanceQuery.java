package database;

import com.orientechnologies.orient.core.sql.executor.OResult;
import com.orientechnologies.orient.core.sql.executor.OResultSet;
import database.IAdvanceQuery;

public class OrientDBAdvanceQuery extends DBConnenction implements IAdvanceQuery{
    // Tìm 3 tổ chức tổ chức nhiều sự kiện nhất
    public void query1() {
        createDBConnection();
        createDBSession();

        String query = "SELECT \n" +
                "  @rid as Organization_RID, \n" +
                "  id, \n" +
                "  label, \n" +
                "  out('HasOrganized').size() AS EventsNumber \n" +
                "FROM `Organization` \n" +
                "ORDER BY EventsNumber DESC \n" +
                "LIMIT 3";
        long start = System.currentTimeMillis();
        OResultSet rs = getDb().query(query);
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

    // Tìm tất cả các đất nước bị căng thẳng bởi các đất nước mà việt nam đàm phán
    public void query2() {
        createDBConnection();
        createDBSession();

        String query = "MATCH {Class: Country, as: country1, where: (label='Thụy Sĩ')}-HasNegotiated->{Class: Country, as: country2}-HasTighten->{Class: Country, as: country3}\n" +
                "RETURN $pathelements";
        long start = System.currentTimeMillis();
        OResultSet rs = getDb().query(query);
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

    // Tìm 3 Agreement được ủng hộ nhiều nhất
    public void query3() {
        createDBConnection();
        createDBSession();

        String query = "SELECT \n" +
                "  @rid as Agreement_RID, \n" +
                "  id, \n" +
                "  label, \n" +
                "  in('HasSupported').size() AS SupportsNumber \n" +
                "FROM `Agreement` \n" +
                "ORDER BY SupportsNumber DESC \n" +
                "LIMIT 3";
        long start = System.currentTimeMillis();
        OResultSet rs = getDb().query(query);
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

    // Những người Nguyễn Phú Trọng gặp gỡ phát biểu tại sự kiện GRAMMY_2018
    public void query4() {
        createDBConnection();
        createDBSession();

        String query = "MATCH {Class: Person, as: person1, where: (label='Nguyễn Phú Trọng')}-HasMet->{Class: Person, as: person2}-HasExpressed->{Class: Event, as: event, where: (label='GRAMMY_2018')}\n" +
                "RETURN $pathelements";
        long start = System.currentTimeMillis();
        OResultSet rs = getDb().query(query);
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

    // Tìm tất cả sự kiện mà được các của nước Mỹ ký thỏa thuận ủng hộ
    public void query5() {
        createDBConnection();
        createDBSession();

        String query = "MATCH {Class: Country, as: country1, where: (label='Mỹ')}-HasAgree->{Class: Country, as: country2}-HasSupported->{Class: Event, as: event}\n" +
                "RETURN $pathelements";
        long start = System.currentTimeMillis();
        OResultSet rs = getDb().query(query);
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

    // Tìm 5 người gặp gỡ nhiều người khác nhất
    public void query6() {
        createDBConnection();
        createDBSession();

        String query = "SELECT \n" +
                "  @rid as Person_RID, \n" +
                "  id, \n" +
                "  label, \n" +
                "  out('HasMet').size() AS MetsNumber \n" +
                "FROM Person \n" +
                "ORDER BY MetsNumber DESC \n" +
                "LIMIT 5";
        long start = System.currentTimeMillis();
        OResultSet rs = getDb().query(query);
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

    // Những người ủng hộ Việt Nam tổ chức sự kiện Talk_show_công_nghệ diễn ra tại Hà Nội
    public void query7() {
        createDBConnection();
        createDBSession();

        String query = "MATCH {Class: Person, as: person}-HasSupported->{Class: Event, as: event, where: (label='Talk_show_công_nghệ')}-TakesPlace->{Class: Location, as: location, where: (label='Hà Nội')}\n" +
                "RETURN $pathelements";
        long start = System.currentTimeMillis();
        OResultSet rs = getDb().query(query);
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

    // Những người phản đối Việt Nam ký thỏa thuận với Trung Quốc
    public void query8() {
        createDBConnection();
        createDBSession();

        String query = "MATCH {Class: Person, as: person}-HasDisagree->{Class: Country, as: country, where: (label='Việt Nam')}-HasAgree->{Class: Country, as: country2, where: (label='Trung Quốc')}\n" +
                "RETURN $pathelements";
        long start = System.currentTimeMillis();
        OResultSet rs = getDb().query(query);
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

    // 3 tổ chức có người + tổ chức tham gia nhiều nhất
    public void query9() {
        createDBConnection();
        createDBSession();

        String query = "SELECT \n" +
                "  @rid as Organization_RID, \n" +
                "  id, \n" +
                "  label, \n" +
                "  in('HasParticipated').size() AS TakesPlacesNumber \n" +
                "FROM `Organization` \n" +
                "ORDER BY TakesPlacesNumber DESC \n" +
                "LIMIT 3";
        long start = System.currentTimeMillis();
        OResultSet rs = getDb().query(query);
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

    // Địa điểm nào diễn ra nhiều sự kiện nhất
    public void query10() {
        createDBConnection();
        createDBSession();

        String query = "SELECT \n" +
                "  @rid as Location_RID, \n" +
                "  id, \n" +
                "  label, \n" +
                "  in('TakesPlace').size() AS TakesPlacesNumber \n" +
                "FROM `Location` \n" +
                "ORDER BY TakesPlacesNumber DESC \n" +
                "LIMIT 1";
        long start = System.currentTimeMillis();
        OResultSet rs = getDb().query(query);
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
