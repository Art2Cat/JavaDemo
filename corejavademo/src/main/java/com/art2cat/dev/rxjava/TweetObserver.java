package com.art2cat.dev.rxjava;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class TweetObserver implements Observer<Tweet> {

    @Override
    public void onSubscribe(Disposable disposable) {
        System.out.println("isDisposable: " + disposable.isDisposed());
    }

    @Override
    public void onNext(Tweet tweet) {
        System.out.println(tweet);
    }

    @Override
    public void onError(Throwable throwable) {
        System.err.println(throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("complete.");
    }
}
