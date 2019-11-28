package database;


import entity.*;
import ralationship.Relationship;

public interface IEntityStorage {

    public void insertAgreements(Agreement[] agreements);

    public void insertCountries(Country[] countries);

    public void insertEvents(Event[] events);

    public void insertLocations(Location[] locations);

    public void insertOrganizations(Organization[] organizations);

    public void insertPeople(Person[] people);

    public void insertTimes(Time[] times);
}
