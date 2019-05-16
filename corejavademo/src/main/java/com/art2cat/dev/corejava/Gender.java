package com.art2cat.dev.corejava;

/**
 * com.art2cat.dev.corejava
 *
 * @author Rorschach
 * @date 31/12/2017
 */
public enum Gender {

    /**
     * Male
     */
    Male(1),
    /**
     * Female
     */
    Female(2),
    /**
     * Third
     */
    Third(3);

    private int value;

    Gender(int value) {
        this.value = value;
    }

    public int getGender() {
        return value;
    }
}
