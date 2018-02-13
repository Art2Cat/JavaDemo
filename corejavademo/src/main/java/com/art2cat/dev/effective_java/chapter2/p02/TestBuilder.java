package com.art2cat.dev.effective_java.chapter2.p02;

/**
 * Created by Rorschach on 2017/2/9.
 */
public class TestBuilder {

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    private TestBuilder(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public void print() {
        System.out.println(servings);
        System.out.println(servingSize);
        System.out.println(calories);
        System.out.println(carbohydrate);
        System.out.println(fat);
        System.out.println(sodium);

    }

    public static class Builder {

        private final int servingSize;
        private final int servings;
        private int calories = 0;
        private int carbohydrate = 0;
        private int fat = 0;
        private int sodium = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public TestBuilder build() {
            return new TestBuilder(this);
        }
    }
}
