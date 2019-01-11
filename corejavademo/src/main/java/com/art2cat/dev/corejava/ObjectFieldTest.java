package com.art2cat.dev.corejava;


import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Rorschach on 2017/3/30.
 */
public class ObjectFieldTest {

    private static final String TEST = "ss";
    private static PrintStream SP = System.out;

    public static void main(String[] args) {
        referenceObjectTest();
    }

    private static void referenceObjectTest() {
        Date date = new Date();
        SP.println(date.toString());

        Date birthday;

        birthday = date;

        SP.println("birthday hashcode: " + birthday.hashCode());
        SP.println("date hashcode: " + date.hashCode());
        SP.println("birthday hashcode: " + birthday.hashCode());
        SP.println(TEST);

        Male male = new Male("tobby", 23, 176);
        System.out.println(male.getName());
        Boy boy = new Boy("jimmy", 2);
        SP.println(male.getGender());
        SP.println(boy.getHeight());

        boy.setHeight(176);

        System.out.println(male.hashCode());
        System.out.println(boy.hashCode());

        if (male.equals(boy)) {
            System.out.println("Good");
        }
        List<Person> list = new ArrayList<>(100);
        list.add(male);
        list.add(boy);

        System.out.println(list.size());

        readList(list);

        System.out.println(male.getClass().getName() + " " + male.getName());
        System.out.println(boy.getClass().getName() + " " + boy.getName());
        boy.speak("fuck you!");
        Boy boy1 = null;
        try {
            boy1 = (Boy) boy.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(boy.equals(boy1));
        System.out.println(boy.compareTo(male));
    }

    private static void readList(List<Person> list) {
        for (Person person : list) {
            System.out.println(person.hashCode());
        }
    }
}
