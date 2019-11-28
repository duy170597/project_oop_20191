package entitygeneration;

import com.google.gson.Gson;
import entity.Event;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Random;

public class EventGeneration extends EntityGeneration {
    public EventGeneration loadFromFile(String fileName) {
        try {
            Gson gson = new Gson();
            Reader reader = new FileReader(fileName);
            // Convert JSON File to Java Object
            EventGeneration eg = gson.fromJson(reader, EventGeneration.class);
            return eg;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Event[] generate(int amount) {
        Event[] events = new Event[amount];
        Random rd = new Random();
        for (int i = 0; i < amount; i++) {
            events[i] = new Event(
                    "event"+i,
                    getLabel()[rd.nextInt(getLabel().length)],
                    getDescription()[rd.nextInt(getDescription().length)]);
        }
        return events;
    }
}
