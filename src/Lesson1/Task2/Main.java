package Lesson1.Task2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException{
        TextContainer tc = new TextContainer();
        Class<?> cl = tc.getClass();
        SaveTo saveTo = cl.getAnnotation(SaveTo.class);
        Method[] methods =  cl.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Saver.class)) {
                method.invoke(tc, saveTo.path());
            }
            }

        }

    }

