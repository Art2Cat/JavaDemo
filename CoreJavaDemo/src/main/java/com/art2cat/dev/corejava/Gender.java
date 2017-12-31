package com.art2cat.dev.corejava;

/**
 * com.art2cat.dev.corejava
 *
 * @author Rorschach
 * @date 31/12/2017
 */
public enum Gender {

    Male(1), Female(2), Third(3);
    private int value;

    private Gender(int value) {
        this.value = value;
    }

    public int getGender() {
        return value;
    }
}
