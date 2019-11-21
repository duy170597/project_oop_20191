package ralationship;

import java.util.Date;

public class Relationship {
    private String relationshipName;    // tên quan hệ
    private String extractedLink;   // link trích rút
    private Date extractedDate; // ngày trích rút

    public Relationship() {
    }

    public Relationship(String relationshipName, String extractedLink, Date extractedDate) {
        this.relationshipName = relationshipName;
        this.extractedLink = extractedLink;
        this.extractedDate = extractedDate;
    }

    public String toString() {
        return "\nrelationshipName: " + relationshipName + "\nextractedLink: " + extractedLink + "\nextractedDate: " + extractedDate;
    }
}
