package database;

import com.orientechnologies.orient.core.record.OEdge;
import com.orientechnologies.orient.core.record.OVertex;
import ralationship.Relationship;

import java.util.ArrayList;
import java.util.Random;

import static database.OrientDBEntityStorage.agreementVertices;
import static database.OrientDBEntityStorage.countryVertices;
import static database.OrientDBEntityStorage.eventVertices;
import static database.OrientDBEntityStorage.locationVertices;
import static database.OrientDBEntityStorage.organizationVertices;
import static database.OrientDBEntityStorage.personVertices;


public class OrientDBRelationshipStorage extends DBConnenction implements IRelationshipStorage {

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
        subjects.add(countryVertices);
        ArrayList<OVertex[]> objects = new ArrayList<OVertex[]>();  // chứa tập các object có thể trong quan hệ ủng hộ
        objects.add(countryVertices);

        insertRelationships(agreementRelationships, subjects, objects, "HasAgree");

        closeDBSession();
        closeDBConnection();
    }

    public void insertCancelRelationships(Relationship[] cancelRelationships) {
        createDBConnection();
        createDBSession();

        ArrayList<OVertex[]> subjects = new ArrayList<OVertex[]>(); // chứa tập các subject có thể trong quan hệ ủng hộ
        subjects.add(personVertices);
        subjects.add(countryVertices);
        ArrayList<OVertex[]> objects = new ArrayList<OVertex[]>();  // chứa tập các object có thể trong quan hệ ủng hộ
        objects.add(agreementVertices);
        objects.add(eventVertices);

        insertRelationships(cancelRelationships, subjects, objects, "HasCancelled");

        closeDBSession();
        closeDBConnection();
    }

    public void insertDisagreeRelationships(Relationship[] disagreeRelationships) {
        createDBConnection();
        createDBSession();

        ArrayList<OVertex[]> subjects = new ArrayList<OVertex[]>(); // chứa tập các subject có thể trong quan hệ ủng hộ
        subjects.add(personVertices);
        subjects.add(countryVertices);
        ArrayList<OVertex[]> objects = new ArrayList<OVertex[]>();  // chứa tập các object có thể trong quan hệ ủng hộ
        objects.add(countryVertices);
        objects.add(agreementVertices);
        objects.add(eventVertices);

        insertRelationships(disagreeRelationships, subjects, objects, "HasDisagree");

        closeDBSession();
        closeDBConnection();
    }

    public void insertExpressRelationships(Relationship[] expressRelationships) {
        createDBConnection();
        createDBSession();

        ArrayList<OVertex[]> subjects = new ArrayList<OVertex[]>(); // chứa tập các subject có thể trong quan hệ ủng hộ
        subjects.add(personVertices);
        ArrayList<OVertex[]> objects = new ArrayList<OVertex[]>();  // chứa tập các object có thể trong quan hệ ủng hộ
        objects.add(eventVertices);

        insertRelationships(expressRelationships, subjects, objects, "HasExpressed");

        closeDBSession();
        closeDBConnection();
    }

    public void insertMeetingRelationships(Relationship[] meetingRelationships) {
        createDBConnection();
        createDBSession();

        ArrayList<OVertex[]> subjects = new ArrayList<OVertex[]>(); // chứa tập các subject có thể trong quan hệ ủng hộ
        subjects.add(personVertices);
        ArrayList<OVertex[]> objects = new ArrayList<OVertex[]>();  // chứa tập các object có thể trong quan hệ ủng hộ
        objects.add(personVertices);

        insertRelationships(meetingRelationships, subjects, objects, "HasMet");

        closeDBSession();
        closeDBConnection();
    }

    public void insertNegotiateRelationships(Relationship[] negotiateRelationships) {
        createDBConnection();
        createDBSession();

        ArrayList<OVertex[]> subjects = new ArrayList<OVertex[]>(); // chứa tập các subject có thể trong quan hệ ủng hộ
        subjects.add(countryVertices);
        ArrayList<OVertex[]> objects = new ArrayList<OVertex[]>();  // chứa tập các object có thể trong quan hệ ủng hộ
        objects.add(countryVertices);

        insertRelationships(negotiateRelationships, subjects, objects, "HasNegotiated");

        closeDBSession();
        closeDBConnection();
    }

    public void insertOrganizationRelationships(Relationship[] organizationRelationships) {
        createDBConnection();
        createDBSession();

        ArrayList<OVertex[]> subjects = new ArrayList<OVertex[]>(); // chứa tập các subject có thể trong quan hệ ủng hộ
        subjects.add(organizationVertices);
        subjects.add(personVertices);
        ArrayList<OVertex[]> objects = new ArrayList<OVertex[]>();  // chứa tập các object có thể trong quan hệ ủng hộ
        objects.add(eventVertices);

        insertRelationships(organizationRelationships, subjects, objects, "HasOrganized");

        closeDBSession();
        closeDBConnection();
    }

    public void insertParticipateRelationships(Relationship[] participateRelationships) {
        createDBConnection();
        createDBSession();

        ArrayList<OVertex[]> subjects = new ArrayList<OVertex[]>(); // chứa tập các subject có thể trong quan hệ ủng hộ
        subjects.add(personVertices);
        subjects.add(organizationVertices);
        ArrayList<OVertex[]> objects = new ArrayList<OVertex[]>();  // chứa tập các object có thể trong quan hệ ủng hộ
        objects.add(organizationVertices);
        objects.add(eventVertices);
        objects.add(agreementVertices);

        insertRelationships(participateRelationships, subjects, objects, "HasParticipated");

        closeDBSession();
        closeDBConnection();
    }

    public void insertSupportRelationships(Relationship[] supportRelationships) {
        createDBConnection();
        createDBSession();

        ArrayList<OVertex[]> subjects = new ArrayList<OVertex[]>(); // chứa tập các subject có thể trong quan hệ ủng hộ
        subjects.add(personVertices);
        subjects.add(countryVertices);
        ArrayList<OVertex[]> objects = new ArrayList<OVertex[]>();  // chứa tập các object có thể trong quan hệ ủng hộ
        objects.add(countryVertices);
        objects.add(agreementVertices);
        objects.add(eventVertices);

        insertRelationships(supportRelationships, subjects, objects, "HasSupported");

        closeDBSession();
        closeDBConnection();
    }

    public void insertTightenRelationships(Relationship[] tightenRelationships) {
        createDBConnection();
        createDBSession();

        ArrayList<OVertex[]> subjects = new ArrayList<OVertex[]>(); // chứa tập các subject có thể trong quan hệ ủng hộ
        subjects.add(countryVertices);
        ArrayList<OVertex[]> objects = new ArrayList<OVertex[]>();  // chứa tập các object có thể trong quan hệ ủng hộ
        objects.add(countryVertices);

        insertRelationships(tightenRelationships, subjects, objects, "HasTighten");

        closeDBSession();
        closeDBConnection();
    }

    public void insertTakesPlaceRelationships(Relationship[] takesPlaceRelationships) {
        createDBConnection();
        createDBSession();

        ArrayList<OVertex[]> subjects = new ArrayList<OVertex[]>(); // chứa tập các subject có thể trong quan hệ ủng hộ
        subjects.add(eventVertices);
        ArrayList<OVertex[]> objects = new ArrayList<OVertex[]>();  // chứa tập các object có thể trong quan hệ ủng hộ
        objects.add(locationVertices);
        objects.add(countryVertices);

        insertRelationships(takesPlaceRelationships, subjects, objects, "TakesPlace");

        closeDBSession();
        closeDBConnection();
    }
}
