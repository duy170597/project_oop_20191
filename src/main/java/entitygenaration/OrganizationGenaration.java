package entitygenaration;

import com.google.gson.Gson;
import entity.Organization;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Random;

public class OrganizationGenaration extends EntityGenaration {
    private String[] headquarter; // trụ sở

    public OrganizationGenaration loadFromFile(String fileName) {
        try {
            Gson gson = new Gson();
            Reader reader = new FileReader(fileName);
            // Convert JSON File to Java Object
            OrganizationGenaration og = gson.fromJson(reader, OrganizationGenaration.class);
            return og;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Organization[] genarate(int amount) {
        Organization[] organizations = new Organization[amount];
        Random rd = new Random();
        for (int i = 0; i < amount; i++) {
            organizations[i] = new Organization(
                                        "organization"+i,
                                        getLabel()[rd.nextInt(getLabel().length)],
                                        getDescription()[rd.nextInt(getDescription().length)],
                                        getHeadquarter()[rd.nextInt(getHeadquarter().length)]);
        }
        return organizations;
    }

    public String[] getHeadquarter() {
        return headquarter;
    }

    public void setHeadquarter(String[] headquarter) {
        this.headquarter = headquarter;
    }

    public static void main(String[] args) {
        OrganizationGenaration og = new OrganizationGenaration().loadFromFile(".\\src\\main\\resources\\organization_genaration.json");
        Organization[] organizations = og.genarate(4);
        for (Organization k: organizations) {
            System.out.println(k.toString());
        }
    }
}
