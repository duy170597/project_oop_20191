package entitygenaration;

import com.google.gson.Gson;
import entity.Event;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Random;

public class EventGenaration extends EntityGenaration {
    public EventGenaration loadFromFile(String fileName) {
        try {
            Gson gson = new Gson();
            Reader reader = new FileReader(fileName);
            // Convert JSON File to Java Object
            EventGenaration eg = gson.fromJson(reader, EventGenaration.class);
            return eg;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Event[] genarate(int amount) {
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

    public static void main(String[] args) {
        EventGenaration ev = new EventGenaration().loadFromFile(".\\src\\main\\resources\\event_genaration.json");
        Event[] events = ev.genarate(4);
        for (Event event: events) {
            System.out.println(event.toString());
        }
    }
}
