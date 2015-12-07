package com.airhacks;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FlightScheduler {

    @PersistenceContext
    EntityManager em;

    public Flight upsert(Flight flight) {
        return this.em.merge(flight);
    }

    public Flight find(long nbr) {
        return this.em.find(Flight.class, nbr);
    }

}
