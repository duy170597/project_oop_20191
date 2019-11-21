package application;

import database.IStorage;
import entity.Organization;
import genaration.OrganizationGenaration;
import orientdb.OrientDBStorage;

public class Main {
    public static void main(String[] args) {
        OrganizationGenaration og = new OrganizationGenaration().loadFromFile(".\\src\\main\\resources\\organization_genaration.json");
        Organization[] organizations = og.genarate(2);
        for (Organization k: organizations) {
            System.out.println(k.toString());
        }

        IStorage storage = new OrientDBStorage();
        storage.insertOrganizations(organizations);
    }
}
