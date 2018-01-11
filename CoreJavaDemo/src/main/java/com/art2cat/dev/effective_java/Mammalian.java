package com.art2cat.dev.effective_java;

/**
 * Created by Rorschach on 2017/2/8.
 */
public abstract class Mammalian {
    
    private String name;
    private String color;
    private int age;
    private String yell;
    
    abstract String setNameTag(int tag, String name);
    
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    
    public String getYell() {
        return yell;
    }
    
    public void setYell(String yell) {
        this.yell = yell;
    }
}
