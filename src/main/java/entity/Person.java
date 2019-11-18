package entity;

import java.util.Date;

public class Person extends Entity {
    private Boolean gender; // giới tính
    private Date birthdate;  // ngày sinh
    private String email;
    private String position;    // chức vụ

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getAge() {
        return new Date().getYear() - birthdate.getYear();
    }
}
