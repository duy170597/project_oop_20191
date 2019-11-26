package relationshipgenaration;

import com.google.gson.Gson;
import ralationship.Relationship;
import ralationship.RelationshipName;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

public class RelationshipGenaration {
    private String[] extractedLink;   // tập các link trích rút
    private String[] extractedDate; // tập các ngày trích rút

    public RelationshipGenaration loadFromFile(String fileName) {
        try {
            Gson gson = new Gson();
            Reader reader = new FileReader(fileName);
            // Convert JSON File to Java Object
            RelationshipGenaration relationshipGenaration = gson.fromJson(reader, RelationshipGenaration.class);
            return relationshipGenaration;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Relationship[] genarate(String nameRelationship, int amount) {
        Relationship[] relationships = new Relationship[amount];
        Random rd = new Random();
        for (int i = 0; i < amount; i++) {
            try {
                relationships[i] = new Relationship(
                        nameRelationship,
                        extractedLink[rd.nextInt(extractedLink.length)],
                        new SimpleDateFormat("dd/MM/yyyy").parse(extractedDate[rd.nextInt(extractedDate.length)])
                );
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return relationships;
    }

    public static void main(String[] args) {
        RelationshipGenaration relationshipGenaration = new RelationshipGenaration().loadFromFile(".\\src\\main\\resources\\relationship_genaration.json");
        Relationship[] organizationRelationship = relationshipGenaration.genarate(RelationshipName.TO_CHUC, 1);

        System.out.println(organizationRelationship[0].toString());
    }
}
