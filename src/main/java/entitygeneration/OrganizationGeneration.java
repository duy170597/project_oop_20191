package entitygeneration;

import com.google.gson.Gson;
import entity.Organization;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Random;

public class OrganizationGeneration extends EntityGeneration {
    private String[] headquarter; // trụ sở

    public String[] getHeadquarter() {
        return headquarter;
    }

    public void setHeadquarter(String[] headquarter) {
        this.headquarter = headquarter;
    }

    public OrganizationGeneration loadFromFile(String fileName) {
        try {
            Gson gson = new Gson();
            Reader reader = new FileReader(fileName);
            // Convert JSON File to Java Object
            OrganizationGeneration og = gson.fromJson(reader, OrganizationGeneration.class);
            return og;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Organization[] generate(int amount) {
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
}
