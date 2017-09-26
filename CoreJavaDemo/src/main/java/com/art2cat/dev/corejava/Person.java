package com.art2cat.dev.corejava;

/**
 * Created by Rorschach
 * on 2017/3/30.
 */
public class Person implements Cloneable {
    // final域表示构造方法之后，域的值不能再被改变了
    private final String name;
    private int age;
    private int height;
    private String gender;

    public Person(String name) {
        this.name = name;
    }


    public Person(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        return ((Person) obj).getAge() == this.getAge();
    }

    @Override
    public int hashCode() {
        return (7 * this.getAge() + 7 * this.getName().hashCode() + 11 * this.getHeight()) * 1024;
    }

    @Override
    protected Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }

    public void methodName(String name, int age, boolean off) {
        System.out.println("method 1");
    }

    public void methodName(int age, String name, boolean off) {
        System.out.println("method 2");
    }

    public void methodName(boolean off, String name, int age) {
        System.out.println("method 3");
    }

    public void methodName(boolean name, int age, boolean off) {
        System.out.println("method 4");
    }
}
