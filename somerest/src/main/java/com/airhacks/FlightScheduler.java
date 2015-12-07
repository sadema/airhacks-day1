package com.airhacks;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class FlightScheduler {

    @Inject
    FlightStore store;

    @Inject
    PassengerStore passengers;

    public List<Flight> all() {
        return store.all();
    }

    public Flight upsert(Flight flight) {
        flight.add(new Passenger("duke" + System.currentTimeMillis(), 2));
        return this.store.upsert(flight);
    }

    public Flight find(long nbr) {
        return this.store.find(nbr);
    }

}
