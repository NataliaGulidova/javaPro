package Lesson1.Task1;

import java.lang.annotation.*;
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
public @interface Test {
    int a();
    int b();

}
