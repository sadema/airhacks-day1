package com.airhacks;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author airhacks.com
 */
@RequestScoped
public class First {

    private String content;

    @PostConstruct
    public void initHook() {
        this.content = " initial content";
        System.out.println("--- creating first");
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
