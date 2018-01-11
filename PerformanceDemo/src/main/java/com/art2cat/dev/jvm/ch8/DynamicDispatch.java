package com.art2cat.dev.jvm.ch8;

public class DynamicDispatch {

    static abstract class Human {

        protected abstract void sayHello();
    }

    static class Man extends Human {

        @Override
        protected void sayHello() {
            System.out.println("gentleman say hello!");
        }
    }

    static class Woman extends Human {

        @Override
        protected void sayHello() {
            System.out.println("lady say hello!");
        }
    }

}
