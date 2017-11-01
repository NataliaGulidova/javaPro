package Lesson1.Task2;
import java.lang.annotation.*;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value= {ElementType.METHOD, ElementType.FIELD})
public @interface Saver{


}
