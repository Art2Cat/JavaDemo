package com.art2cat.dev.rxjava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TweetObserverTest {

    private List<Tweet> tweets;

    @BeforeEach
    public void before() {
        tweets = IntStream.rangeClosed(1, 5)
            .boxed()
            .map(i -> {
                Tweet tweet = new Tweet();
                tweet.setPoster("Poster #" + i);
                tweet.setContent("Test message #" + i);
                tweet.setPostTime(LocalDateTime.now());
                return tweet;
            }).collect(Collectors.toList());
        System.out.println("init");
    }

    @Test
    public void test() {
        Tweet tweet = new Tweet();
        tweet.setContent("This is a test message.");
        tweet.setPoster("Tester");
        tweet.setPostTime(LocalDateTime.now());
        Observable observable = Observable.just(tweet);
        observable.subscribe(new TweetObserver());
    }

    @Test
    public void testCase1() {
        Observer<Tweet> tweetObserver = new TweetObserver();

        Observable observable = Observable.fromArray(tweets.toArray());

        observable.subscribe(tweetObserver);
    }

}
