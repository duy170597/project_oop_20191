package entitygeneration;

import com.google.gson.Gson;
import entity.Country;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Random;

public class CountryGeneration extends EntityGeneration {
    public CountryGeneration loadFromFile(String fileName) {
        try {
            Gson gson = new Gson();
            Reader reader = new FileReader(fileName);
            // Convert JSON File to Java Object
            CountryGeneration countryGeneration = gson.fromJson(reader, CountryGeneration.class);
            return countryGeneration;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Country[] generate(int amount) {
        Country[] countries = new Country[amount];
        Random rd = new Random();
        for (int i = 0; i < amount; i++) {
            countries[i] = new Country(
                    "country"+i,
                    getLabel()[rd.nextInt(getLabel().length)],
                    getDescription()[rd.nextInt(getDescription().length)]);
        }
        return countries;
    }
}
