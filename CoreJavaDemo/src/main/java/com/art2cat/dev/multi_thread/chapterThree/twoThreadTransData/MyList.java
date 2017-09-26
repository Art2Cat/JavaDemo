package com.art2cat.dev.multi_thread.chapterThree.twoThreadTransData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rorschach
 * on 7/7/2017.
 */
class MyList {
    private List<String> list = new ArrayList<>();

    void add() {
        list.add("Test");
    }

    int size() {
        return list.size();
    }

}
