package entitygenaration;

import com.google.gson.Gson;
import entity.Country;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Random;

public class CountryGenaration extends EntityGenaration {
    public CountryGenaration loadFromFile(String fileName) {
        try {
            Gson gson = new Gson();
            Reader reader = new FileReader(fileName);
            // Convert JSON File to Java Object
            CountryGenaration countryGenaration = gson.fromJson(reader, CountryGenaration.class);
            return countryGenaration;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Country[] genarate(int amount) {
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

    public static void main(String[] args) {
        CountryGenaration countryGenaration = new CountryGenaration().loadFromFile(".\\src\\main\\resources\\country_genaration.json");
        Country[] countries = countryGenaration.genarate(4);
        for (Country country: countries) {
            System.out.println(country.toString());
        }
    }
}
