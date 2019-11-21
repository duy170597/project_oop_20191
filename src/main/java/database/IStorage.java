package database;


import entity.Entity;
import entity.Organization;
import ralationship.Relationship;

public interface IStorage {

    public void insertEntity(Entity[] entity);

    public void insertOrganizations(Organization[] organizations);

    public void insertRelationship(Entity[] subject, Relationship relationship, Entity[] object);
}
