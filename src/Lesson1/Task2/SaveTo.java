package Lesson1.Task2;
import java.lang.annotation.*;
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value= ElementType.TYPE)

public @interface SaveTo {
    String path();
}

