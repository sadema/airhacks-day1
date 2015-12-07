package com.airhacks;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author airhacks.com
 */
@Model
public class Index {

    @Inject
    First first;

    @Inject
    Second second;

    public Object doIt() {
        first.setContent("duke");
        second.check();
        return "confirmation";
    }

}
