package com.art2cat.dev.effective_java;

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
}
