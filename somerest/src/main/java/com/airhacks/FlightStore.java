package com.airhacks;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author airhacks.com
 */
public class FlightStore {

    @PersistenceContext
    EntityManager em;

    public Flight upsert(Flight flight) {
        return this.em.merge(flight);
    }

    public Flight find(long nbr) {
        return this.em.find(Flight.class, nbr);
    }

    public List<Flight> all() {
        return this.em.
                createNamedQuery("all", Flight.class).
                getResultList();
    }

}
