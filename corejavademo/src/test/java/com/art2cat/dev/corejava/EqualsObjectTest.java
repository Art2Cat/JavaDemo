package com.art2cat.dev.corejava;

import com.art2cat.dev.effective_java.EqualsObject;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class EqualsObjectTest {

    @Test
    public void test() {
        List<Object> list = new ArrayList<>();
        EqualsObject equalsObject = new EqualsObject("test");

        EqualsObject equalsObject1 = new EqualsObject("test");

        EqualsObject equalsObject2 = new EqualsObject("test");

        Object equalsObject3 = new EqualsObject("test");

        list.add(equalsObject);
        System.out.println(list.contains(equalsObject1));
        System.out.println(equalsObject1.equals(equalsObject2));
        System.out.println(equalsObject2.equals(equalsObject3));
        System.out.println(equalsObject3.equals(equalsObject2));

    }


}
