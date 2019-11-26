package database;

import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;

public class DBConnenction {
    private OrientDB orient;
    private ODatabaseSession db;

    public OrientDB getOrient() {
        return orient;
    }

    public void setOrient(OrientDB orient) {
        this.orient = orient;
    }

    public ODatabaseSession getDb() {
        return db;
    }

    public void setDb(ODatabaseSession db) {
        this.db = db;
    }

    public OrientDB createDBConnection() {
        orient = new OrientDB("remote:localhost", OrientDBConfig.defaultConfig());
        return orient;
    }

    public void closeDBConnection() {
        orient.close();
    }

    public ODatabaseSession createDBSession() {
        db = orient.open("information_extraction_demo_1", "admin", "admin");
        return db;
    }

    public void closeDBSession() {
        db.close();
    }
}
