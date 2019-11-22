package database;

import ralationship.Relationship;

public interface IRelationshipStorage {
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
