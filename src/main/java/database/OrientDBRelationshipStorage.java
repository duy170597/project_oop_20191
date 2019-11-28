package database;

import com.orientechnologies.orient.core.record.OEdge;
import com.orientechnologies.orient.core.record.OVertex;
import ralationship.Relationship;

import java.util.ArrayList;
import java.util.Random;

public class OrientDBRelationshipStorage extends DBConnenction implements IRelationshipStorage {
    private OrientDBEntityStorage entityStorage;

    public OrientDBRelationshipStorage(OrientDBEntityStorage entityStorage) {
        this.entityStorage = entityStorage;
    }

    public OrientDBEntityStorage getEntityStorage() {
        return entityStorage;
    }

    public void setEntityStorage(OrientDBEntityStorage entityStorage) {
        this.entityStorage = entityStorage;
    }

    private void insertRelationships(Relationship[] supportRelationships, ArrayList<OVertex[]> subjects, ArrayList<OVertex[]> objects, String dbClassName) {
        Random rd = new Random();
        for (int i = 0; i < supportRelationships.length; i++) {
            OVertex[] subjectVertices = subjects.get(rd.nextInt(subjects.size()));
            OVertex subject = subjectVertices[rd.nextInt(subjectVertices.length)];

            OVertex[] objectVertices = objects.get(rd.nextInt(objects.size()));
            OVertex object = objectVertices[rd.nextInt(objectVertices.length)];

            OEdge oEdge = subject.addEdge(object, dbClassName);
            oEdge.setProperty("relationshipName", supportRelationships[i].getRelationshipName());
            oEdge.setProperty("extractedLink", supportRelationships[i].getExtractedLink());
            oEdge.setProperty("extractedDate", supportRelationships[i].getExtractedDate());
            oEdge.save();
        }
    }

    public void insertAgreementRelationships(Relationship[] agreementRelationships) {
        createDBConnection();
        createDBSession();

        ArrayList<OVertex[]> subjects = new ArrayList<OVertex[]>(); // chứa tập các subject có thể trong quan hệ ủng hộ
        subjects.add(entityStorage.getCountryVertices());
        ArrayList<OVertex[]> objects = new ArrayList<OVertex[]>();  // chứa tập các object có thể trong quan hệ ủng hộ
        objects.add(entityStorage.getCountryVertices());

        insertRelationships(agreementRelationships, subjects, objects, "HasAgree");

        closeDBSession();
        closeDBConnection();
    }

    public void insertCancelRelationships(Relationship[] cancelRelationships) {
        createDBConnection();
        createDBSession();

        ArrayList<OVertex[]> subjects = new ArrayList<OVertex[]>();
        subjects.add(entityStorage.getPersonVertices());
        subjects.add(entityStorage.getCountryVertices());
        ArrayList<OVertex[]> objects = new ArrayList<OVertex[]>();
        objects.add(entityStorage.getAgreementVertices());
        objects.add(entityStorage.getEventVertices());

        insertRelationships(cancelRelationships, subjects, objects, "HasCancelled");

        closeDBSession();
        closeDBConnection();
    }

    public void insertDisagreeRelationships(Relationship[] disagreeRelationships) {
        createDBConnection();
        createDBSession();

        ArrayList<OVertex[]> subjects = new ArrayList<OVertex[]>();
        subjects.add(entityStorage.getPersonVertices());
        subjects.add(entityStorage.getCountryVertices());
        ArrayList<OVertex[]> objects = new ArrayList<OVertex[]>();
        objects.add(entityStorage.getCountryVertices());
        objects.add(entityStorage.getAgreementVertices());
        objects.add(entityStorage.getEventVertices());

        insertRelationships(disagreeRelationships, subjects, objects, "HasDisagree");

        closeDBSession();
        closeDBConnection();
    }

    public void insertExpressRelationships(Relationship[] expressRelationships) {
        createDBConnection();
        createDBSession();

        ArrayList<OVertex[]> subjects = new ArrayList<OVertex[]>();
        subjects.add(entityStorage.getPersonVertices());
        ArrayList<OVertex[]> objects = new ArrayList<OVertex[]>();
        objects.add(entityStorage.getEventVertices());

        insertRelationships(expressRelationships, subjects, objects, "HasExpressed");

        closeDBSession();
        closeDBConnection();
    }

    public void insertMeetingRelationships(Relationship[] meetingRelationships) {
        createDBConnection();
        createDBSession();

        ArrayList<OVertex[]> subjects = new ArrayList<OVertex[]>();
        subjects.add(entityStorage.getPersonVertices());
        ArrayList<OVertex[]> objects = new ArrayList<OVertex[]>();
        objects.add(entityStorage.getPersonVertices());

        insertRelationships(meetingRelationships, subjects, objects, "HasMet");

        closeDBSession();
        closeDBConnection();
    }

    public void insertNegotiateRelationships(Relationship[] negotiateRelationships) {
        createDBConnection();
        createDBSession();

        ArrayList<OVertex[]> subjects = new ArrayList<OVertex[]>();
        subjects.add(entityStorage.getCountryVertices());
        ArrayList<OVertex[]> objects = new ArrayList<OVertex[]>();
        objects.add(entityStorage.getCountryVertices());

        insertRelationships(negotiateRelationships, subjects, objects, "HasNegotiated");

        closeDBSession();
        closeDBConnection();
    }

    public void insertOrganizationRelationships(Relationship[] organizationRelationships) {
        createDBConnection();
        createDBSession();

        ArrayList<OVertex[]> subjects = new ArrayList<OVertex[]>();
        subjects.add(entityStorage.getOrganizationVertices());
        subjects.add(entityStorage.getPersonVertices());
        ArrayList<OVertex[]> objects = new ArrayList<OVertex[]>();
        objects.add(entityStorage.getEventVertices());

        insertRelationships(organizationRelationships, subjects, objects, "HasOrganized");

        closeDBSession();
        closeDBConnection();
    }

    public void insertParticipateRelationships(Relationship[] participateRelationships) {
        createDBConnection();
        createDBSession();

        ArrayList<OVertex[]> subjects = new ArrayList<OVertex[]>();
        subjects.add(entityStorage.getPersonVertices());
        subjects.add(entityStorage.getOrganizationVertices());
        ArrayList<OVertex[]> objects = new ArrayList<OVertex[]>();
        objects.add(entityStorage.getOrganizationVertices());
        objects.add(entityStorage.getEventVertices());
        objects.add(entityStorage.getAgreementVertices());

        insertRelationships(participateRelationships, subjects, objects, "HasParticipated");

        closeDBSession();
        closeDBConnection();
    }

    public void insertSupportRelationships(Relationship[] supportRelationships) {
        createDBConnection();
        createDBSession();

        ArrayList<OVertex[]> subjects = new ArrayList<OVertex[]>();
        subjects.add(entityStorage.getPersonVertices());
        subjects.add(entityStorage.getCountryVertices());
        ArrayList<OVertex[]> objects = new ArrayList<OVertex[]>();
        objects.add(entityStorage.getCountryVertices());
        objects.add(entityStorage.getAgreementVertices());
        objects.add(entityStorage.getEventVertices());

        insertRelationships(supportRelationships, subjects, objects, "HasSupported");

        closeDBSession();
        closeDBConnection();
    }

    public void insertTightenRelationships(Relationship[] tightenRelationships) {
        createDBConnection();
        createDBSession();

        ArrayList<OVertex[]> subjects = new ArrayList<OVertex[]>();
        subjects.add(entityStorage.getCountryVertices());
        ArrayList<OVertex[]> objects = new ArrayList<OVertex[]>();
        objects.add(entityStorage.getCountryVertices());

        insertRelationships(tightenRelationships, subjects, objects, "HasTighten");

        closeDBSession();
        closeDBConnection();
    }

    public void insertTakesPlaceRelationships(Relationship[] takesPlaceRelationships) {
        createDBConnection();
        createDBSession();

        ArrayList<OVertex[]> subjects = new ArrayList<OVertex[]>();
        subjects.add(entityStorage.getEventVertices());
        ArrayList<OVertex[]> objects = new ArrayList<OVertex[]>();
        objects.add(entityStorage.getLocationVertices());
        objects.add(entityStorage.getCountryVertices());

        insertRelationships(takesPlaceRelationships, subjects, objects, "TakesPlace");

        closeDBSession();
        closeDBConnection();
    }
}
