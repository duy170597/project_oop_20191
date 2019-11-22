package application;

import database.IEntityStorage;
import database.IRelationshipStorage;
import entity.*;
import genaration.*;
import orientdb.OrientDBEntityStorage;
import orientdb.OrientDBRelationshipStorage;
import ralationship.Relationship;
import ralationship.RelationshipName;

public class Main {
    public static void main(String[] args) {
        AgreementGenaration agreementGenaration = new AgreementGenaration().loadFromFile(".\\src\\main\\resources\\agreement_genaration.json");
        Agreement[] agreements = agreementGenaration.genarate(2);

        CountryGenaration countryGenaration = new CountryGenaration().loadFromFile(".\\src\\main\\resources\\country_genaration.json");
        Country[] countries = countryGenaration.genarate(2);

        EventGenaration eventGenaration = new EventGenaration().loadFromFile(".\\src\\main\\resources\\event_genaration.json");
        Event[] events = eventGenaration.genarate(2);

        LocationGenaration locationGenaration = new LocationGenaration().loadFromFile(".\\src\\main\\resources\\location_genaration.json");
        Location[] locations = locationGenaration.genarate(2);

        OrganizationGenaration organizationGenaration = new OrganizationGenaration().loadFromFile(".\\src\\main\\resources\\organization_genaration.json");
        Organization[] organizations = organizationGenaration.genarate(2);

        PersonGenaration personGenaration = new PersonGenaration().loadFromFile(".\\src\\main\\resources\\person_genaration.json");
        Person[] people = personGenaration.genarate(2);

        TimeGenaration timeGenaration = new TimeGenaration().loadFromFile(".\\src\\main\\resources\\time_genaration.json");
        Time[] times = timeGenaration.genarate(2);

        RelationshipGenaration relationshipGenaration = new RelationshipGenaration().loadFromFile(".\\src\\main\\resources\\relationship_genaration.json");
        Relationship[] agreementRelationships = relationshipGenaration.genarate(RelationshipName.KY_THOA_THUAN, 2);
        Relationship[] cancelRelationships = relationshipGenaration.genarate(RelationshipName.HUY_BO, 2);
        Relationship[] disagreRelationships = relationshipGenaration.genarate(RelationshipName.PHAN_DOI, 2);
        Relationship[] expressRelationships = relationshipGenaration.genarate(RelationshipName.PHAT_BIEU_TAI, 2);
        Relationship[] meetingRelationships = relationshipGenaration.genarate(RelationshipName.GAP_GO, 2);
        Relationship[] negotiateRelationships = relationshipGenaration.genarate(RelationshipName.DAM_PHAN_VOI, 2);
        Relationship[] organizationRelationships = relationshipGenaration.genarate(RelationshipName.TO_CHUC, 2);
        Relationship[] participateRelationships = relationshipGenaration.genarate(RelationshipName.THAM_GIA, 2);
        Relationship[] supportRelationships = relationshipGenaration.genarate(RelationshipName.UNG_HO, 2);
        Relationship[] tightenRelationships = relationshipGenaration.genarate(RelationshipName.CANG_THANG_VOI, 2);
        Relationship[] takesplaceRelationships = relationshipGenaration.genarate(RelationshipName.DIEN_RA_TAI, 2);


        IEntityStorage entityStorage = new OrientDBEntityStorage();
        entityStorage.insertAgreements(agreements);
        entityStorage.insertCountries(countries);
        entityStorage.insertEvents(events);
        entityStorage.insertLocations(locations);
        entityStorage.insertOrganizations(organizations);
        entityStorage.insertPeople(people);
        entityStorage.insertTimes(times);


        IRelationshipStorage relationshipStorage = new OrientDBRelationshipStorage();
        relationshipStorage.insertAgreementRelationships(agreementRelationships);
        relationshipStorage.insertCancelRelationships(cancelRelationships);
        relationshipStorage.insertDisagreeRelationships(disagreRelationships);
        relationshipStorage.insertExpressRelationships(expressRelationships);
        relationshipStorage.insertMeetingRelationships(meetingRelationships);
        relationshipStorage.insertNegotiateRelationships(negotiateRelationships);
        relationshipStorage.insertOrganizationRelationships(organizationRelationships);
        relationshipStorage.insertParticipateRelationships(participateRelationships);
        relationshipStorage.insertSupportRelationships(supportRelationships);
        relationshipStorage.insertTightenRelationships(tightenRelationships);
        relationshipStorage.insertTakesPlaceRelationships(takesplaceRelationships);
    }
}
