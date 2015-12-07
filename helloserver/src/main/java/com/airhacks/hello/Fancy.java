package com.airhacks.hello;

import javax.enterprise.inject.Model;
import javax.validation.constraints.Size;

/**
 *
 * @author airhacks.com
 */
@Model
public class Fancy {

    @Size(min = 1, max = 2)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object save() {
        System.out.println("Saving: " + this.name);
        return null;
    }

}
