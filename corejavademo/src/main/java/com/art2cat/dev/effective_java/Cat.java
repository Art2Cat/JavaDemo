package com.art2cat.dev.effective_java;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * Created by Rorschach on 2017/2/8.
 */
public class Cat extends Mammalian {

    private String yell;

    protected Cat() {
    }

    public static Cat newInstance() {
        return new Cat();
    }

    @Override
    String setNameTag(int tag, String name) {
        return name;
    }

    @Override
    @LookUp
    public String getYell() {
        return yell;
    }

    @Override
    public void setYell(String yell) {
        this.yell = yell;
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cat)) {
            return false;
        }
        Cat cat = (Cat) o;
        return Objects.equals(yell, cat.yell);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Cat.class.getSimpleName() + "[", "]")
            .add("yell='" + yell + "'")
            .toString();
    }
}
