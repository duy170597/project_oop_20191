package entitygeneration;

import com.google.gson.Gson;
import entity.Time;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

public class TimeGeneration extends EntityGeneration {
    private String[] time;

    public String[] getTime() {
        return time;
    }

    public void setTime(String[] time) {
        this.time = time;
    }

    public TimeGeneration loadFromFile(String fileName) {
        try {
            Gson gson = new Gson();
            Reader reader = new FileReader(fileName);
            // Convert JSON File to Java Object
            TimeGeneration timeGenaration = gson.fromJson(reader, TimeGeneration.class);
            return timeGenaration;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Time[] generate(int amount) {
        Time[] times = new Time[amount];
        Random rd = new Random();
        for (int i = 0; i < amount; i++) {
            try {
                times[i] = new Time(
                        "time"+i,
                        getLabel()[rd.nextInt(getLabel().length)],
                        getDescription()[rd.nextInt(getDescription().length)],
                        new SimpleDateFormat("dd/MM/yyyy").parse(getTime()[rd.nextInt(getTime().length)]));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return times;
    }
}
