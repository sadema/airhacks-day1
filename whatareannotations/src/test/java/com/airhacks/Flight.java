package com.airhacks;

/**
 *
 * @author airhacks.com
 */
@Category("business")
public class Flight {

    @FlightNumber
    private String code;

    private String description;

    @AirJect
    Airplane airplane;

    @Override
    public String toString() {
        return "Flight{" + "code=" + code + ", description=" + description + ", airplane=" + airplane + '}';
    }

}
