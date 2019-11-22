package orientdb;

import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.orientechnologies.orient.core.record.OEdge;
import com.orientechnologies.orient.core.record.OVertex;
import database.IEntityStorage;
import entity.*;
import ralationship.Relationship;

import java.util.ArrayList;
import java.util.Random;

public class OrientDBEntityStorage extends DBConnenction implements IEntityStorage {
    public static OVertex[] agreementVertices;
    public static OVertex[] countryVertices;
    public static OVertex[] eventVertices;
    public static OVertex[] locationVertices;
    public static OVertex[] organizationVertices;
    public static OVertex[] personVertices;
    public static OVertex[] timeVertices;

    public void insertEntity(Entity[] entity) {

    }

    private OVertex insertAgreement(ODatabaseSession db, Agreement agreement) {
        OVertex result = db.newVertex("Agreement");
        result.setProperty("id", agreement.getId());
        result.setProperty("label", agreement.getLabel());
        result.setProperty("description", agreement.getDescription());
        result.save();
        return result;
    }

    public void insertAgreements(Agreement[] agreements) {
        createDBConnection();
        createDBSession();

        agreementVertices = new OVertex[agreements.length];

        for (int i = 0; i < agreements.length; i++) {
            agreementVertices[i] = insertAgreement(getDb(), agreements[i]);
        }

        closeDBSession();
        closeDBConnection();
    }

    private OVertex insertCountry(ODatabaseSession db, Country country) {
        OVertex result = db.newVertex("Country");
        result.setProperty("id", country.getId());
        result.setProperty("label", country.getLabel());
        result.setProperty("description", country.getDescription());
        result.save();
        return result;
    }

    public void insertCountries(Country[] countries) {
        createDBConnection();
        createDBSession();

        countryVertices = new OVertex[countries.length];

        for (int i = 0; i < countries.length; i++) {
            countryVertices[i] = insertCountry(getDb(), countries[i]);
        }

        closeDBSession();
        closeDBConnection();
    }

    private OVertex insertEvent(ODatabaseSession db, Event event) {
        OVertex result = db.newVertex("Event");
        result.setProperty("id", event.getId());
        result.setProperty("label", event.getLabel());
        result.setProperty("description", event.getDescription());
        result.save();
        return result;
    }

    public void insertEvents(Event[] events) {
        createDBConnection();
        createDBSession();

        eventVertices = new OVertex[events.length];

        for (int i = 0; i < events.length; i++) {
            eventVertices[i] = insertEvent(getDb(), events[i]);
        }

        closeDBSession();
        closeDBConnection();
    }

    private OVertex insertLocation(ODatabaseSession db, Location location) {
        OVertex result = db.newVertex("Location");
        result.setProperty("id", location.getId());
        result.setProperty("label", location.getLabel());
        result.setProperty("description", location.getDescription());
        result.save();
        return result;
    }

    public void insertLocations(Location[] locations) {
        createDBConnection();
        createDBSession();

        locationVertices = new OVertex[locations.length];

        for (int i = 0; i < locations.length; i++) {
            locationVertices[i] = insertLocation(getDb(), locations[i]);
        }

        closeDBSession();
        closeDBConnection();
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
        createDBConnection();
        createDBSession();

        organizationVertices = new OVertex[organizations.length];

        for (int i = 0; i < organizations.length; i++) {
            organizationVertices[i] = insertOrganization(getDb(), organizations[i]);
        }

        closeDBSession();
        closeDBConnection();
    }

    private OVertex insertPerson(ODatabaseSession db, Person person) {
        OVertex result = db.newVertex("Person");
        result.setProperty("id", person.getId());
        result.setProperty("label", person.getLabel());
        result.setProperty("description", person.getDescription());
        result.setProperty("gender", person.getGender());
        result.setProperty("birthdate", person.getBirthdate());
        result.setProperty("email", person.getEmail());
        result.setProperty("position", person.getPosition());
        result.save();
        return result;
    }

    public void insertPeople(Person[] people) {
        createDBConnection();
        createDBSession();

        personVertices = new OVertex[people.length];

        for (int i = 0; i < people.length; i++) {
            personVertices[i] = insertPerson(getDb(), people[i]);
        }

        closeDBSession();
        closeDBConnection();
    }

    private OVertex insertTime(ODatabaseSession db, Time time) {
        OVertex result = db.newVertex("Time");
        result.setProperty("id", time.getId());
        result.setProperty("label", time.getLabel());
        result.setProperty("description", time.getDescription());
        result.setProperty("time", time.getTime());
        result.save();
        return result;
    }

    public void insertTimes(Time[] times) {
        createDBConnection();
        createDBSession();

        timeVertices = new OVertex[times.length];

        for (int i = 0; i < times.length; i++) {
            timeVertices[i] = insertTime(getDb(), times[i]);
        }

        closeDBSession();
        closeDBConnection();
    }
}
