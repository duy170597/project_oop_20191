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

    public void query4() {

    }

    public void query5() {

    }

    public void query6() {

    }

    public void query7() {

    }

    public void query8() {

    }

    public void query9() {

    }

    public void query10() {

    }
}
