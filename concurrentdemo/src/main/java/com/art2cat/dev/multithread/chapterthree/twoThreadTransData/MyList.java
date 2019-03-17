package com.art2cat.dev.multithread.chapterthree.twoThreadTransData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rorschach on 7/7/2017.
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
