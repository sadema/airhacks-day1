package com.airhacks;

import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class AnnotationTest {

    @Test
    public void annotation() throws ClassNotFoundException {
        Class<?> flightClass = Class.forName("com.airhacks.Flight");
        Category annotation = flightClass.getAnnotation(Category.class);
        System.out.println("Annotation: " + annotation.value());
    }

}
