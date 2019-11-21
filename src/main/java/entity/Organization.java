package entity;

public class Organization extends Entity {
    private String headquarter; // trụ sở

    public Organization(String id, String label, String description, String headquarter) {
        super(id, label, description);
        this.headquarter = headquarter;
    }

    public String getHeadquarter() {
        return headquarter;
    }

    public void setHeadquarter(String headquarter) {
        this.headquarter = headquarter;
    }

    public String toString() {
        return super.toString() + "\nheadquarter: " + headquarter;
    }
}
