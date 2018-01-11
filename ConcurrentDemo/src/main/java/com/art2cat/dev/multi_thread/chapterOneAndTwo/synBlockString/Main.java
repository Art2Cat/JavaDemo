package com.art2cat.dev.multi_thread.chapterOneAndTwo.synBlockString;

/**
 * Created by Rorschach on 7/7/2017.
 */
public class Main {
    
    public static void main(String[] args) {
        Service service = new Service();
        Thread a = new Thread(() -> {
//            service.setUsernamePassword("a", "aa");
            service.test();
        });
        a.setName("A");
        a.start();
        Thread b = new Thread(() -> {
//            service.setUsernamePassword("b", "bb");
            service.b();
        });
        b.setName("B");
        b.start();
    }
}
