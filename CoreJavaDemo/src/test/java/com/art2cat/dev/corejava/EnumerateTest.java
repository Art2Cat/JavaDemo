package com.art2cat.dev.corejava;

import java.util.EnumMap;
import org.junit.Test;

/**
 * com.art2cat.dev.corejava
 *
 * @author Rorschach
 * @date 31/12/2017
 */
public class EnumerateTest {

    @Test
    public void testGenderValueOf() {
        Gender gender;
        gender = Gender.Female;
        System.out.println(Gender.valueOf(gender.name()));
        System.out.println(gender.getGender());
    }

    @Test
    public void testGenderValues() {
        for (Gender g : Gender.values()) {
            System.out.println(Gender.valueOf
                (Gender.class, g.name())
                + " " + g.getGender());
        }
    }

    @Test
    public void testZodiac() {
        EnumMap<Zodiac, String> zodMap =
            new EnumMap<>(Zodiac.class);
        for (Zodiac z : Zodiac.values()) {
            zodMap.put(Zodiac.valueOf(z.name()), z.toString());
        }

        for (Zodiac zz : zodMap.keySet()) {
            System.out.println(zz.name() + ": " + zz.toString());
        }
    }
}
