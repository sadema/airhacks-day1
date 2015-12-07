package com.airhacks;

import java.lang.reflect.Field;
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
        Field[] fields = flightClass.getDeclaredFields();
        for (Field field : fields) {
            FlightNumber nbr = field.getAnnotation(FlightNumber.class);
            if (nbr != null) {
                System.out.println("Annotated: " + field);
            } else {
                System.out.println("Is not annotated: " + field);
            }
        }
    }

}
