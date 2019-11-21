package orientdb;

import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;
import com.orientechnologies.orient.core.record.OVertex;
import database.IStorage;
import entity.Entity;
import entity.Organization;
import ralationship.Relationship;

public class OrientDBStorage extends DBConnenction implements IStorage {
    public void insertEntity(Entity[] entity) {

    }

    private OVertex insertOrganization(ODatabaseSession db, Organization organization) {
        OVertex result = db.newVertex("Organization");
        result.setProperty("id", organization.getId());
        result.setProperty("label", organization.getLabel());
        result.setProperty("description", organization.getDescription());
        result.setProperty("headquarter", organization.getHeadquarter());
        result.save();
        return result;
    }

    public void insertOrganizations(Organization[] organizations) {
        OrientDB orient = getDBConnection();
        ODatabaseSession db = getDBSession();

        for (Organization organization: organizations
             ) {
            insertOrganization(db, organization);
        }

        closeDBSession();
        closeDBConnection();
    }

    public void insertRelationship(Entity[] subject, Relationship relationship, Entity[] object) {

    }
}
