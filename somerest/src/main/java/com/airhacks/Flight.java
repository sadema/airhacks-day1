package com.airhacks;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Table(name = "AIRHACKS_FLIGHT")
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = "all", query = "SELECT f FROM Flight f")
public class Flight {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "FIRST_NAME")
    private String name;

    @Min(1)
    private int capacity;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Passenger> passengers;

    public Flight() {
        this.passengers = new HashSet<>();
    }

    public Flight(String name, int capacity) {
        this();
        this.name = name;
        this.capacity = capacity;
    }

    public void add(Passenger passenger) {
        this.passengers.add(passenger);
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Flight{" + "name=" + name + ", capacity=" + capacity + '}';
    }

}
