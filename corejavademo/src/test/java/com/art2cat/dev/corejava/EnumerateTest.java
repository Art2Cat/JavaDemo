package com.art2cat.dev.corejava;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
            System.out.println(Gender.valueOf(Gender.class, g.name()) + " " + g.getGender());
        }
    }
    
    @Test
    public void testZodiac() {
        Map<Zodiac, String> zodMap = Stream.of(Zodiac.values())
            .collect(Collectors.toMap(z -> Zodiac.valueOf(z.name()),
                Zodiac::toString));
        
        zodMap
            .forEach((zodiac, string) -> System.out
                .println(String.format("%s : %s", zodiac.name(), string)));
    }
}
