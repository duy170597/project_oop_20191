package orientdb;

import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;
import com.orientechnologies.orient.core.sql.executor.OResult;
import com.orientechnologies.orient.core.sql.executor.OResultSet;
import database.IQuery;

public class OrientDBQuery extends DBConnenction implements IQuery {
    public void executeAQuery1() {
        OrientDB orient = getDBConnection();
        ODatabaseSession db = getDBSession();

        String query = "SELECT expand(out('RelationShip')) from Entity where name = ?";
        OResultSet rs = db.query(query, "Italy");

        while (rs.hasNext()) {
            OResult item = rs.next();
            System.out.println("Italy quan hệ tới: " + item.getProperty("name"));
        }

        rs.close(); //REMEMBER TO ALWAYS CLOSE THE RESULT SET!!!

        closeDBSession();
        closeDBConnection();
    }

    public static void main(String[] args) {
        OrientDBQuery query = new OrientDBQuery();
        query.executeAQuery1();
    }
}
