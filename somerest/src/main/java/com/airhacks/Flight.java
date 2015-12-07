package com.airhacks;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Flight {

    private String name;
    private int capacity;

    public Flight() {
    }

    public Flight(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Flight{" + "name=" + name + ", capacity=" + capacity + '}';
    }

}
