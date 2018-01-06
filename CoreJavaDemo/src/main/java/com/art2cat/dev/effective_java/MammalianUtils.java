package com.art2cat.dev.effective_java;

import java.util.HashSet;

/**
 * Created by Rorschach on 2017/2/8.
 */
public class MammalianUtils {

    private static int hash;
    private static MammalianUtils mammalianUtils;
    private static HashSet<MammalianUtils> hashSet;
    private Mammalian mammalian;

    private MammalianUtils() {
        hashSet = new HashSet<>();
    }

    public static void setHashSet(MammalianUtils mammalianUtils) {
        MammalianUtils.hashSet.add(mammalianUtils);
    }

    private static int getHash() {
        return hash;
    }

    private void setHash(int hash) {
        MammalianUtils.hash = hash;
    }

    private static MammalianUtils getMammalianUtils() {
        return mammalianUtils;
    }

    private void setMammalianUtils(MammalianUtils mammalianUtils) {
        MammalianUtils.mammalianUtils = mammalianUtils;
    }

    static MammalianUtils builder() {
        
        if (MammalianUtils.getHash() != 0) {
            return getMammalianUtils();
        } else {
            MammalianUtils mammalianUtils = new MammalianUtils();
            mammalianUtils.setHash(mammalianUtils.hashCode());
            mammalianUtils.setMammalianUtils(mammalianUtils);
            return mammalianUtils;
        }
    }

    MammalianUtils with(Mammalian mammalian) {
        this.mammalian = mammalian;
        System.out.println("hashcode: " + this.hashCode());
        return this;
    }

    void yell(String yell) {
        if (yell == null) {
            System.out.println(mammalian.getYell());
        } else {
            System.out.println(yell);
        }

    }

}
