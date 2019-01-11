package com.art2cat.dev.corejava;

/**
 * Created by Rorschach on 2017/3/30.
 */
public class Male extends Person implements Comparable<Person> {

    private static final String MALE = "Male";

    public Male(String name, int age, int height) {
        super(name, age, height, MALE);
    }

    @Override
    public String getGender() {
        return MALE;
    }

    @Override
    public int compareTo(Person o) {
        return Double.compare(this.getAge(), o.getAge());
    }

    @Override
    public void methodName(String name, int age, boolean off) {
//        super.methodName(name, age, off);
        System.out.println("male method 1");
    }

    @Override
    public void methodName(boolean name, int age, boolean off) {
//        super.methodName(name, age, off);
        System.out.println("male method 2");
    }
}
