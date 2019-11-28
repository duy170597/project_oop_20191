package entitygeneration;

import com.google.gson.Gson;
import entity.Agreement;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Random;

public class AgreementGeneration extends EntityGeneration {
    public AgreementGeneration loadFromFile(String fileName) {
        try {
            Gson gson = new Gson();
            Reader reader = new FileReader(fileName);
            // Convert JSON File to Java Object
            AgreementGeneration agreementGeneration = gson.fromJson(reader, AgreementGeneration.class);
            return agreementGeneration;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Agreement[] generate(int amount) {
        Agreement[] agreements = new Agreement[amount];
        Random rd = new Random();
        for (int i = 0; i < amount; i++) {
            agreements[i] = new Agreement(
                    "agreement"+i,
                    getLabel()[rd.nextInt(getLabel().length)],
                    getDescription()[rd.nextInt(getDescription().length)]);
        }
        return agreements;
    }
}
