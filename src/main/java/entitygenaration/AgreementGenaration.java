package entitygenaration;

import com.google.gson.Gson;
import entity.Agreement;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Random;

public class AgreementGenaration extends EntityGenaration {
    public AgreementGenaration loadFromFile(String fileName) {
        try {
            Gson gson = new Gson();
            Reader reader = new FileReader(fileName);
            // Convert JSON File to Java Object
            AgreementGenaration agreementGenaration = gson.fromJson(reader, AgreementGenaration.class);
            return agreementGenaration;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Agreement[] genarate(int amount) {
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

    public static void main(String[] args) {
        AgreementGenaration agreementGenaration = new AgreementGenaration().loadFromFile(".\\src\\main\\resources\\agreement_genaration.json");
        Agreement[] agreements = agreementGenaration.genarate(4);
        for (Agreement agreement : agreements) {
            System.out.println(agreement.toString());
        }
    }
}
