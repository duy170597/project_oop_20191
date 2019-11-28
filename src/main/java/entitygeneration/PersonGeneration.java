package entitygeneration;

import com.google.gson.Gson;
import entity.Person;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

public class PersonGeneration extends EntityGeneration {
    private String[] gender; // giới tính
    private String[] birthdate;  // ngày sinh
    private String[] email;
    private String[] position;    // chức vụ

    public String[] getGender() {
        return gender;
    }

    public void setGender(String[] gender) {
        this.gender = gender;
    }

    public String[] getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String[] birthdate) {
        this.birthdate = birthdate;
    }

    public String[] getEmail() {
        return email;
    }

    public void setEmail(String[] email) {
        this.email = email;
    }

    public String[] getPosition() {
        return position;
    }

    public void setPosition(String[] position) {
        this.position = position;
    }

    public PersonGeneration loadFromFile(String fileName) {
        try {
            Gson gson = new Gson();
            Reader reader = new FileReader(fileName);
            // Convert JSON File to Java Object
            PersonGeneration personGenaration = gson.fromJson(reader, PersonGeneration.class);
            return personGenaration;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Person[] generate(int amount) {
        Person[] people = new Person[amount];
        Random rd = new Random();
        for (int i = 0; i < amount; i++) {
            try {
                people[i] = new Person(
                        "person"+i,
                        getLabel()[rd.nextInt(getLabel().length)],
                        getDescription()[rd.nextInt(getDescription().length)],
                        Boolean.parseBoolean(getGender()[rd.nextInt(getGender().length)]),
                        new SimpleDateFormat("dd/MM/yyyy").parse(getBirthdate()[rd.nextInt(getBirthdate().length)]),
                        getEmail()[rd.nextInt(getEmail().length)],
                        getPosition()[rd.nextInt(getPosition().length)]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return people;
    }
}
