package application;

import entity.Entity;
import entity.Person;

public class Test {
    public static void main(String[] args) {
        Entity enti = new Person();
        System.out.println(Entity.class.toString());
    }
}
