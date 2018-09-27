package com.art2cat.dev.rxjava;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;

public class HelloWorld {
    
    public static void main(String[] args) {
        Disposable disposable = Flowable.just("Hello world").subscribe(System.out::println);
        System.out.println(disposable.isDisposed());
    }
}
