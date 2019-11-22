package entity;

import java.util.Date;

public class Person extends Entity {
    private Boolean gender; // giới tính
    private Date birthdate;  // ngày sinh
    private String email;
    private String position;    // chức vụ

    public Person() {
    }

    public Person(String id, String label, String description, Boolean gender, Date birthdate, String email, String position) {
        super(id, label, description);
        this.gender = gender;
        this.birthdate = birthdate;
        this.email = email;
        this.position = position;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getAge() {
        return new Date().getYear() - birthdate.getYear();
    }

    public String toString() {
        return super.toString() + "\ngender: " + getGender() + "\nbirthdate: "
                + getBirthdate() + "\nemail: " + getEmail() + "\nposition: " + getPosition();
    }
}
