package Lesson1.Task3;
import java.lang.annotation.*;
@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Save {
}
