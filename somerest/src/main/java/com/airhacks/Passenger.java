package com.airhacks;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author airhacks.com
 */
@Entity
public class Passenger {

    @Id
    private String name;
    private int age;

    public Passenger() {
    }

    public Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
