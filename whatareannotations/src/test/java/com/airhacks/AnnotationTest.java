package com.airhacks;

import java.lang.reflect.Field;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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

    @Test
    public void injection() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> flightClass = Class.forName("com.airhacks.Flight");
        Object flightInstance = flightClass.newInstance();
        Field[] declaredFields = flightClass.getDeclaredFields();
        Set<Field> annotatedFields = Stream.of(declaredFields).
                filter(d -> d.getAnnotation(AirJect.class) != null).
                collect(Collectors.toSet());
        for (Field annotatedField : annotatedFields) {
            System.out.println("-- " + annotatedField.getName());
            Class<?> fieldType = annotatedField.getType();
            System.out.println("fieldType = " + fieldType);
            Object airplanceInstance = fieldType.newInstance();
            System.out.println("airplanceInstance = " + airplanceInstance);
            annotatedField.set(flightInstance, airplanceInstance);
            System.out.println("flightInstance = " + flightInstance);
        }

    }

}
