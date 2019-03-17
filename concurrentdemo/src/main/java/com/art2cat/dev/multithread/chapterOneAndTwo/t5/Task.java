package com.art2cat.dev.multithread.chapterOneAndTwo.t5;

/**
 * Created by Rorschach on 7/6/2017.
 */
class Task {

    private String getData1;
    private String getData2;

    void doLongTimeTask() {
        try {
            System.out.println("Begin task");
            Thread.sleep(3000);
            String privateGetData1 = "长时间处理任务后从远程返回的值 1 threadName= "
                + Thread.currentThread().getName();
            String privateGetData2 = "长时间处理任务后从远程返回的值 2 threadName= "
                + Thread.currentThread().getName();
            synchronized (this) {
                getData1 = privateGetData1;
                getData2 = privateGetData2;
            }
            System.out.println(getData1);
            System.out.println(getData2);
            System.out.println("end task");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
