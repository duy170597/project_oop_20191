package genaration;

import com.google.gson.Gson;
import entity.Aggrement;
import entity.Entity;
import entity.Location;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Random;

public class LocationGenaration extends EntityGenaration {
    public LocationGenaration loadFromFile(String fileName) {
        try {
            Gson gson = new Gson();
            Reader reader = new FileReader(fileName);
            // Convert JSON File to Java Object
            LocationGenaration locationGenaration = gson.fromJson(reader, LocationGenaration.class);
            return locationGenaration;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Location[] genarate(int amount) {
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

    public static void main(String[] args) {
        LocationGenaration locationGenaration = new LocationGenaration().loadFromFile(".\\src\\main\\resources\\location_genaration.json");
        Location[] locations = locationGenaration.genarate(4);
        for (Location location: locations) {
            System.out.println(location.toString());
        }
    }
}
