package database;


import entity.Entity;
import ralationship.Relationship;

public interface IStorage {

    public void insertEntity(Entity[] entity);

    public void insertRelationship(Entity[] subject, Relationship relationship, Entity[] object);
}
