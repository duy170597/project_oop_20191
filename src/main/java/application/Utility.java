package application;

import database.IEntityStorage;
import database.IRelationshipStorage;
import entity.*;
import entitygenaration.*;
import database.OrientDBEntityStorage;
import database.OrientDBRelationshipStorage;
import ralationship.Relationship;
import ralationship.RelationshipName;
import relationshipgenaration.RelationshipGenaration;

public class Utility {
    public static void createEntities(int N) {
        int amount = N/Entity.count;
        AgreementGenaration agreementGenaration = new AgreementGenaration().loadFromFile(".\\src\\main\\resources\\agreement_genaration.json");
        Agreement[] agreements = agreementGenaration.genarate(amount);

        CountryGenaration countryGenaration = new CountryGenaration().loadFromFile(".\\src\\main\\resources\\country_genaration.json");
        Country[] countries = countryGenaration.genarate(amount);

        EventGenaration eventGenaration = new EventGenaration().loadFromFile(".\\src\\main\\resources\\event_genaration.json");
        Event[] events = eventGenaration.genarate(amount);

        LocationGenaration locationGenaration = new LocationGenaration().loadFromFile(".\\src\\main\\resources\\location_genaration.json");
        Location[] locations = locationGenaration.genarate(amount);

        OrganizationGenaration organizationGenaration = new OrganizationGenaration().loadFromFile(".\\src\\main\\resources\\organization_genaration.json");
        Organization[] organizations = organizationGenaration.genarate(amount);

        PersonGenaration personGenaration = new PersonGenaration().loadFromFile(".\\src\\main\\resources\\person_genaration.json");
        Person[] people = personGenaration.genarate(N - amount*(Entity.count-1));

        TimeGenaration timeGenaration = new TimeGenaration().loadFromFile(".\\src\\main\\resources\\time_genaration.json");
        Time[] times = timeGenaration.genarate(amount);

        IEntityStorage entityStorage = new OrientDBEntityStorage();
        entityStorage.insertAgreements(agreements);
        entityStorage.insertCountries(countries);
        entityStorage.insertEvents(events);
        entityStorage.insertLocations(locations);
        entityStorage.insertOrganizations(organizations);
        entityStorage.insertPeople(people);
        entityStorage.insertTimes(times);
    }

    public static void createRelationships(int M) {
        RelationshipGenaration relationshipGenaration = new RelationshipGenaration().loadFromFile(".\\src\\main\\resources\\relationship_genaration.json");
        int amount = M/Relationship.count;

        Relationship[] agreementRelationships = relationshipGenaration.genarate(RelationshipName.KY_THOA_THUAN, amount);
        Relationship[] cancelRelationships = relationshipGenaration.genarate(RelationshipName.HUY_BO, amount);
        Relationship[] disagreeRelationships = relationshipGenaration.genarate(RelationshipName.PHAN_DOI, amount);
        Relationship[] expressRelationships = relationshipGenaration.genarate(RelationshipName.PHAT_BIEU_TAI, amount);
        Relationship[] meetingRelationships = relationshipGenaration.genarate(RelationshipName.GAP_GO,  M - amount*(Relationship.count-1));
        Relationship[] negotiateRelationships = relationshipGenaration.genarate(RelationshipName.DAM_PHAN_VOI, amount);
        Relationship[] organizationRelationships = relationshipGenaration.genarate(RelationshipName.TO_CHUC, amount);
        Relationship[] participateRelationships = relationshipGenaration.genarate(RelationshipName.THAM_GIA, amount);
        Relationship[] supportRelationships = relationshipGenaration.genarate(RelationshipName.UNG_HO, amount);
        Relationship[] tightenRelationships = relationshipGenaration.genarate(RelationshipName.CANG_THANG_VOI, amount);
        Relationship[] takesPlaceRelationships = relationshipGenaration.genarate(RelationshipName.DIEN_RA_TAI, amount);

        IRelationshipStorage relationshipStorage = new OrientDBRelationshipStorage();
        relationshipStorage.insertAgreementRelationships(agreementRelationships);
        relationshipStorage.insertCancelRelationships(cancelRelationships);
        relationshipStorage.insertDisagreeRelationships(disagreeRelationships);
        relationshipStorage.insertExpressRelationships(expressRelationships);
        relationshipStorage.insertMeetingRelationships(meetingRelationships);
        relationshipStorage.insertNegotiateRelationships(negotiateRelationships);
        relationshipStorage.insertOrganizationRelationships(organizationRelationships);
        relationshipStorage.insertParticipateRelationships(participateRelationships);
        relationshipStorage.insertSupportRelationships(supportRelationships);
        relationshipStorage.insertTightenRelationships(tightenRelationships);
        relationshipStorage.insertTakesPlaceRelationships(takesPlaceRelationships);
    }


}
