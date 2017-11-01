package Lesson1.Task1;

import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException  {
        Class<?> cls = TestReflection.class;
        Method [] method = cls.getDeclaredMethods();
        for (Method m:method)
        if (m.isAnnotationPresent(Test.class)){
            Test test = m.getAnnotation(Test.class);
            int res = (Integer)m.invoke(null, test.a(), test.b() );
            System.out.println(res);

        }
    }

}
