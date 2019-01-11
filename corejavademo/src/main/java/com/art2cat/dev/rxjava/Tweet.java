package com.art2cat.dev.rxjava;

import java.time.LocalDateTime;

public class Tweet {

    private String content;
    private String poster;
    private LocalDateTime postTime;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public LocalDateTime getPostTime() {
        return postTime;
    }

    public void setPostTime(LocalDateTime postTime) {
        this.postTime = postTime;
    }

    @Override
    public String toString() {
        return "Tweet{" +
            "content='" + content + '\'' +
            ", poster='" + poster + '\'' +
            ", postTime=" + postTime +
            '}';
    }
}
