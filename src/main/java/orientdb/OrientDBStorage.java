package orientdb;

import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.db.OrientDB;
import com.orientechnologies.orient.core.db.OrientDBConfig;
import com.orientechnologies.orient.core.record.OVertex;
import database.IStorage;
import entity.*;
import ralationship.Relationship;

public class OrientDBStorage extends DBConnenction implements IStorage {
    public void insertEntity(Entity[] entity) {

    }

    public void insertAggrements(Aggrement[] aggrements) {

    }

    public void insertCountries(Country[] countries) {

    }

    public void insertEvents(Event[] events) {

    }

    public void insertLocations(Location[] locations) {

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

    public void insertPeople(Person[] people) {

    }

    public void insertTimes(Time[] times) {

    }

    public void insertAgreementRelationships(Relationship[] agreementRelationships) {
        
    }

    public void insertCancelRelationships(Relationship[] cancelRelationships) {

    }

    public void insertDisagreeRelationships(Relationship[] disagreeRelationships) {

    }

    public void insertExpressRelationships(Relationship[] expressRelationships) {

    }

    public void insertMeetingRelationships(Relationship[] meetingRelationships) {

    }

    public void insertNegotiateRelationships(Relationship[] negotiateRelationships) {

    }

    public void insertOrganizationRelationships(Relationship[] organizationRelationships) {

    }

    public void insertParticipateRelationships(Relationship[] participateRelationships) {

    }

    public void insertSupportRelationships(Relationship[] supportRelationships) {

    }

    public void insertTightenRelationships(Relationship[] tightenRelationships) {

    }

    public void insertTakesPlaceRelationships(Relationship[] takesPlaceRelationships) {

    }
}
