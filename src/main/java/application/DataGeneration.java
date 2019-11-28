package application;

import database.IEntityStorage;
import database.IRelationshipStorage;
import entity.*;
import entitygeneration.*;
import database.OrientDBEntityStorage;
import database.OrientDBRelationshipStorage;
import ralationship.Relationship;
import ralationship.RelationshipName;
import relationshipgenaration.RelationshipGenaration;

public class DataGeneration {
    private static IEntityStorage entityStorage = new OrientDBEntityStorage();
    private static IRelationshipStorage relationshipStorage = new OrientDBRelationshipStorage((OrientDBEntityStorage) entityStorage);

    public static void createEntities(int N) {
        int amount = N/Entity.numberTypeEntity;
        AgreementGeneration agreementGeneration = new AgreementGeneration().loadFromFile(".\\src\\main\\resources\\agreement_genaration.json");
        Agreement[] agreements = agreementGeneration.generate(amount);

        CountryGeneration countryGeneration = new CountryGeneration().loadFromFile(".\\src\\main\\resources\\country_genaration.json");
        Country[] countries = countryGeneration.generate(amount);

        EventGeneration eventGenaration = new EventGeneration().loadFromFile(".\\src\\main\\resources\\event_genaration.json");
        Event[] events = eventGenaration.generate(amount);

        LocationGeneration locationGenaration = new LocationGeneration().loadFromFile(".\\src\\main\\resources\\location_genaration.json");
        Location[] locations = locationGenaration.generate(amount);

        OrganizationGeneration organizationGenaration = new OrganizationGeneration().loadFromFile(".\\src\\main\\resources\\organization_genaration.json");
        Organization[] organizations = organizationGenaration.generate(amount);

        PersonGeneration personGenaration = new PersonGeneration().loadFromFile(".\\src\\main\\resources\\person_genaration.json");
        Person[] people = personGenaration.generate(N - amount*(Entity.numberTypeEntity -1));

        TimeGeneration timeGenaration = new TimeGeneration().loadFromFile(".\\src\\main\\resources\\time_genaration.json");
        Time[] times = timeGenaration.generate(amount);

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
        int amount = M/Relationship.numberTypeRelationship;

        Relationship[] agreementRelationships = relationshipGenaration.genarate(RelationshipName.KY_THOA_THUAN, amount);
        Relationship[] cancelRelationships = relationshipGenaration.genarate(RelationshipName.HUY_BO, amount);
        Relationship[] disagreeRelationships = relationshipGenaration.genarate(RelationshipName.PHAN_DOI, amount);
        Relationship[] expressRelationships = relationshipGenaration.genarate(RelationshipName.PHAT_BIEU_TAI, amount);
        Relationship[] meetingRelationships = relationshipGenaration.genarate(RelationshipName.GAP_GO,  M - amount*(Relationship.numberTypeRelationship -1));
        Relationship[] negotiateRelationships = relationshipGenaration.genarate(RelationshipName.DAM_PHAN_VOI, amount);
        Relationship[] organizationRelationships = relationshipGenaration.genarate(RelationshipName.TO_CHUC, amount);
        Relationship[] participateRelationships = relationshipGenaration.genarate(RelationshipName.THAM_GIA, amount);
        Relationship[] supportRelationships = relationshipGenaration.genarate(RelationshipName.UNG_HO, amount);
        Relationship[] tightenRelationships = relationshipGenaration.genarate(RelationshipName.CANG_THANG_VOI, amount);
        Relationship[] takesPlaceRelationships = relationshipGenaration.genarate(RelationshipName.DIEN_RA_TAI, amount);

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
