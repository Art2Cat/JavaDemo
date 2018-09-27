package com.art2cat.dev;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;

import java.util.concurrent.TimeUnit;

public class SubscribleTest {

    private static void log(Object msg) {
        System.out.println(
                Thread.currentThread().getName() +
                        ": " + msg);
    }

    @Test
    public void test() {
        log("Before");
        Observable
                .range(5, 3)
                .subscribe(i -> log(i));
        log("After");
    }

    @Test
    public void test1() {
        Observable ints = Observable
                .create(observableEmitter -> {
                    log("Create");
                    observableEmitter.onNext(5);
                    observableEmitter.onNext(6);
                    observableEmitter.onNext(7);
                    observableEmitter.onComplete();
                    log("Completed");
                });
        log("Starting");
        ints.subscribe(i -> log("Element: " + i));
        log("Exit");
    }
}
