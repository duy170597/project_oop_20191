package orientdb;

import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;

public class DBConnenction {
    private OrientDB orient;
    private ODatabaseSession db;

    public OrientDB getDBConnection() {
        orient = new OrientDB("remote:localhost", OrientDBConfig.defaultConfig());
        return orient;
    }

    public void closeDBConnection() {
        orient.close();
    }

    public ODatabaseSession getDBSession() {
        db = orient.open("information_extraction_demo_1", "admin", "admin");
        return db;
    }

    public void closeDBSession() {
        db.close();
    }
}
