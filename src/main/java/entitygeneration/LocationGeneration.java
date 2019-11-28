package entitygeneration;

import com.google.gson.Gson;
import entity.Location;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Random;

public class LocationGeneration extends EntityGeneration {
    public LocationGeneration loadFromFile(String fileName) {
        try {
            Gson gson = new Gson();
            Reader reader = new FileReader(fileName);
            // Convert JSON File to Java Object
            LocationGeneration locationGenaration = gson.fromJson(reader, LocationGeneration.class);
            return locationGenaration;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Location[] generate(int amount) {
        Location[] locations = new Location[amount];
        Random rd = new Random();
        for (int i = 0; i < amount; i++) {
            locations[i] = new Location(
                    "location"+i,
                    getLabel()[rd.nextInt(getLabel().length)],
                    getDescription()[rd.nextInt(getDescription().length)]);
        }
        return locations;
    }
}
