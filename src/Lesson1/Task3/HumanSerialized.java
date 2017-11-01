package Lesson1.Task3;

import java.io.*;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class HumanSerialized implements Serializable {
    private static String path = "C:\\Users\\Admin\\Desktop\\javaPro\\2.txt";

    public static void save(Object obj) {
        Class<?> cls = obj.getClass();
        StringBuilder sb = new StringBuilder();
        try {

            Field[] fields = cls.getDeclaredFields();
            for (Field f : fields) {
                if (f.isAnnotationPresent(Save.class)) {
                    if (!f.isAccessible()) {
                        f.setAccessible(true);
                    }
                    sb.append(f.getName() + "=");
                    Class<?> fieldType = f.getType();
                    if (fieldType == String.class) {
                        sb.append(f.get(obj) + ";");
                    } else if (fieldType == int.class) {
                        sb.append(f.getInt(obj) + ";");

                    } else {
                        System.out.println("Unknown type - " + fieldType);
                    }

                }
            }

        } catch (IllegalAccessException e) {
            e.getMessage();
        }

        try (ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream(path))) {
            OOS.writeObject(sb.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Save Fields");

    }

    public static void load(Object obj) throws NoSuchFieldException, SecurityException,
            IllegalArgumentException, IllegalAccessException {

        Class<?> cls = obj.getClass();
        String str = "";

        try (ObjectInputStream OIS = new ObjectInputStream(new FileInputStream(path))) {
            str = (String) OIS.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String[] arr = str.split(";");
        for (String a : arr) {
            String[] arr2 = a.split("=");
            Field field = cls.getDeclaredField(arr2[0]);
            field.setAccessible(true);
            if (field.isAnnotationPresent(Save.class)) {
                if (field.getType() == int.class) {
                    field.setInt(obj, Integer.parseInt(arr2[1]));
                } else if (field.getType() == String.class) {
                    field.set(obj, arr2[1]);

                }

            }
        }
    }
}

