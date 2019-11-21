package genaration;

import com.google.gson.Gson;
import entity.Aggrement;
import entity.Entity;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Random;

public class AggrementGenaration extends EntityGenaration {
    public AggrementGenaration loadFromFile(String fileName) {
        try {
            Gson gson = new Gson();
            Reader reader = new FileReader(fileName);
            // Convert JSON File to Java Object
            AggrementGenaration aggrementGenaration = gson.fromJson(reader, AggrementGenaration.class);
            return aggrementGenaration;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Aggrement[] genarate(int amount) {
        Aggrement[] aggrements = new Aggrement[amount];
        Random rd = new Random();
        for (int i = 0; i < amount; i++) {
            aggrements[i] = new Aggrement(
                    "aggrement"+i,
                    getLabel()[rd.nextInt(getLabel().length)],
                    getDescription()[rd.nextInt(getDescription().length)]);
        }
        return aggrements;
    }

    public static void main(String[] args) {
        AggrementGenaration aggrementGenaration = new AggrementGenaration().loadFromFile(".\\src\\main\\resources\\aggrement_genaration.json");
        Aggrement[] aggrements = aggrementGenaration.genarate(4);
        for (Aggrement aggrement: aggrements) {
            System.out.println(aggrement.toString());
        }
    }
}
