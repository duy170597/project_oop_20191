package genaration;

import entity.Entity;

import java.util.Date;

public class PersonGenaration extends EntityGenaration {
    private Boolean gender; // giới tính
    private Date birthdate;  // ngày sinh
    private String email;
    private String position;    // chức vụ

    public void readFile(String fileName) {

    }

    public Entity[] genatate(int amount) {
        return new Entity[0];
    }
}
