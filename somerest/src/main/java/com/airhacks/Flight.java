package com.airhacks;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Flight {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private int capacity;

    public Flight() {
    }

    public Flight(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Flight{" + "name=" + name + ", capacity=" + capacity + '}';
    }

}
