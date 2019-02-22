package com.art2cat.dev.corejava;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.collections4.SetUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SetUtilsTest {

    @Test
    public void test() {
        List<Integer> aList = new ArrayList<>();
        aList.add(1);
        aList.add(2);
        aList.add(3);

        Set<Integer> aSet = new HashSet<>();
        aSet.add(1);
        aSet.add(2);
        aSet.add(3);

        Assertions.assertTrue(SetUtils.isEqualSet(aSet, aList));
    }

}
