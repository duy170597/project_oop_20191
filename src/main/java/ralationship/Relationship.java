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

    public String getRelationshipName() {
        return relationshipName;
    }

    public void setRelationshipName(String relationshipName) {
        this.relationshipName = relationshipName;
    }

    public String getExtractedLink() {
        return extractedLink;
    }

    public void setExtractedLink(String extractedLink) {
        this.extractedLink = extractedLink;
    }

    public Date getExtractedDate() {
        return extractedDate;
    }

    public void setExtractedDate(Date extractedDate) {
        this.extractedDate = extractedDate;
    }

    public String toString() {
        return "\nrelationshipName: " + relationshipName + "\nextractedLink: " + extractedLink + "\nextractedDate: " + extractedDate;
    }
}
