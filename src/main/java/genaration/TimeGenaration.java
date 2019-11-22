package genaration;

import com.google.gson.Gson;
import entity.Entity;
import entity.Time;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class TimeGenaration extends EntityGenaration {
    private String[] time;

    public String[] getTime() {
        return time;
    }

    public void setTime(String[] time) {
        this.time = time;
    }

    public TimeGenaration loadFromFile(String fileName) {
        try {
            Gson gson = new Gson();
            Reader reader = new FileReader(fileName);
            // Convert JSON File to Java Object
            TimeGenaration timeGenaration = gson.fromJson(reader, TimeGenaration.class);
            return timeGenaration;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Time[] genarate(int amount) {
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

    public static void main(String[] args) {
        TimeGenaration timeGenaration = new TimeGenaration().loadFromFile(".\\src\\main\\resources\\time_genaration.json");
        Time[] times = timeGenaration.genarate(4);
        for (Time time: times) {
            System.out.println(time.toString());
        }
    }
}
