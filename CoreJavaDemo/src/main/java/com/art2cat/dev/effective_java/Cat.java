package com.art2cat.dev.effective_java;

/**
 * Created by Rorschach
 * on 2017/2/8.
 */
public class Cat extends Mammalian {
    protected Cat() {
    }

    public static Cat newInstance() {
        return new Cat();
    }

    private String yell;

    @Override
    String setNameTag(int tag, String name) {
        return name;
    }

    public String getYell() {
        return yell;
    }

    public void setYell(String yell) {
        this.yell = yell;
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }
}
