package databaseimpl;

import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;
import com.orientechnologies.orient.core.sql.executor.OResult;
import com.orientechnologies.orient.core.sql.executor.OResultSet;
import database.IQuery;

public class OrientDBQuery implements IQuery {
    public void executeAQuery1() {
        OrientDB orient = new OrientDB("remote:localhost", OrientDBConfig.defaultConfig());
        ODatabaseSession db = orient.open("information_extraction", "admin", "admin");

        String query = "SELECT expand(out('RelationShip')) from Entity where name = ?";
        OResultSet rs = db.query(query, "Italy");

        while (rs.hasNext()) {
            OResult item = rs.next();
            System.out.println("Italy quan hệ tới: " + item.getProperty("name"));
        }

        rs.close(); //REMEMBER TO ALWAYS CLOSE THE RESULT SET!!!

        db.close();
        orient.close();
    }

    public static void main(String[] args) {
        OrientDBQuery query = new OrientDBQuery();
        query.executeAQuery1();
    }
}
