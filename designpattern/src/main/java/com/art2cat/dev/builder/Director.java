package com.art2cat.dev.builder;

/**
 * com.art2cat.dev.builder
 *
 * @author art2c
 * @date 5/24/2018
 */
public class Director {

    private AbstractBuilder builder;

    public Director(AbstractBuilder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.makeTitle("Greeting");
        builder.makeString("From morning to afternoon");
        builder.makeItems(new String[]{" Good morning. ", " Good afternoon. "});
        builder.makeString("night");
        builder.makeItems(new String[]{" Good evening. ", " Good night. ", " Good bye. "});
        builder.close();
    }
}
