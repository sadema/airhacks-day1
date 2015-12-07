package com.airhacks;

import javax.persistence.Entity;

/**
 *
 * @author airhacks.com
 */
@Entity
public class SpaceFlight extends Flight {

    private int height;

    public SpaceFlight() {
    }

    public SpaceFlight(int height, String name, int capacity) {
        super(name, capacity);
        this.height = height;
    }

}
