package database;


import entity.*;
import ralationship.Relationship;

public interface IStorage {

    public void insertEntity(Entity[] entity);

    public void insertAggrements(Aggrement[] aggrements);

    public void insertCountries(Country[] countries);

    public void insertEvents(Event[] events);

    public void insertLocations(Location[] locations);

    public void insertOrganizations(Organization[] organizations);

    public void insertPeople(Person[] people);

    public void insertTimes(Time[] times);

    public void insertAgreementRelationships(Relationship[] agreementRelationships);

    public void insertCancelRelationships(Relationship[] cancelRelationships);

    public void insertDisagreeRelationships(Relationship[] disagreeRelationships);

    public void insertExpressRelationships(Relationship[] expressRelationships);

    public void insertMeetingRelationships(Relationship[] meetingRelationships);

    public void insertNegotiateRelationships(Relationship[] negotiateRelationships);

    public void insertOrganizationRelationships(Relationship[] organizationRelationships);

    public void insertParticipateRelationships(Relationship[] participateRelationships);

    public void insertSupportRelationships(Relationship[] supportRelationships);

    public void insertTightenRelationships(Relationship[] tightenRelationships);

    public void insertTakesPlaceRelationships(Relationship[] takesPlaceRelationships);
}
