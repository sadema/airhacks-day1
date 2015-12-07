package com.airhacks;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author airhacks.com
 */
@RequestScoped
public class Second {

    @Inject
    First first;

    public void check() {
        String content = first.getContent();
        System.out.println("content = " + content);
    }

}
