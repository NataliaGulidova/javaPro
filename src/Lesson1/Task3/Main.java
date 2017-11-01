package Lesson1.Task3;

import Lesson1.Task1.Test;

public class Main {
    public static void main(String[] args)throws  IllegalAccessException, NoSuchFieldException {
       Human t = new Human("Natalia", 24);
        Human t2 = new Human("Rita", 25);

        HumanSerialized.save(t);
        System.out.println(t2);
        HumanSerialized.load(t2);

        System.out.println(t);
        System.out.println(t2);
    }
    }


